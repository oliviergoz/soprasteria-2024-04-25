package eshop.services;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eshop.entities.Achat;
import eshop.entities.AchatKey;
import eshop.entities.Client;
import eshop.entities.Commande;
import eshop.entities.Produit;
import eshop.exceptions.ClientException;
import eshop.exceptions.CommandeException;
import eshop.repositories.AchatRepository;
import eshop.repositories.CommandeRepository;

@Service
public class CommandeService {

	@Autowired
	private CommandeRepository commandeRepo;
	@Autowired
	private AchatRepository achatRepo;
	@Autowired
	private ClientService clientSrv;

	private void checkNumero(Long numero) {
		if (numero == null) {
			throw new ClientException("numero null");
		}
	}

	private void checkClient(Client client) {
		if (client == null) {
			throw new CommandeException("client inconnu");
		}
		checkClient(client.getId());
	}

	private void checkClient(Long id) {
		clientSrv.getById(id);
	}

	public Commande getByNumero(Long numero) {
		checkNumero(numero);
		return commandeRepo.findById(numero).orElseThrow(CommandeException::new);
	}

	public Commande getByNumeroWithAchats(Long numero) {
		checkNumero(numero);
		return commandeRepo.findByIdFetchAchats(numero).orElseThrow(CommandeException::new);
	}

	public void delete(Commande commande) {
		delete(commande.getNumero());
	}

	public void delete(Long numero) {
		Commande commandeEnBase = getByNumero(numero);
		achatRepo.deleteByIdCommande(commandeEnBase);
		commandeRepo.delete(commandeEnBase);
	}

	public List<Commande> getAll() {
		return commandeRepo.findAll();
	}

	public List<Commande> getByClient(Client client) {
		return clientSrv.getByIdWithCommandes(client.getId()).getCommandes().stream().collect(Collectors.toList());
	}

	public Commande create(Commande commande) {
		checkClient(commande.getClient());
		return commandeRepo.save(commande);
	}

	public Commande create(Client client, Map<Produit, Integer> panier) {
		Commande commande = new Commande(client);
		Set<Achat> achats = new HashSet<>();
		panier.forEach((produit, quantite) -> {
			achats.add(new Achat(new AchatKey(commande, produit), quantite));
		});
		commande.setAchats(achats);
		return create(commande);
	}
}
