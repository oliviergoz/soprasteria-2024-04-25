package soprasteria.formation.eshop.services;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soprasteria.formation.eshop.entities.Achat;
import soprasteria.formation.eshop.entities.AchatKey;
import soprasteria.formation.eshop.entities.Client;
import soprasteria.formation.eshop.entities.Commande;
import soprasteria.formation.eshop.entities.Produit;
import soprasteria.formation.eshop.exceptions.ClientException;
import soprasteria.formation.eshop.exceptions.CommandeException;
import soprasteria.formation.eshop.repositories.AchatRepository;
import soprasteria.formation.eshop.repositories.CommandeRepository;

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
		commandeRepo.save(commande);
		achatRepo.saveAll(commande.getAchats());
		return commande;
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
