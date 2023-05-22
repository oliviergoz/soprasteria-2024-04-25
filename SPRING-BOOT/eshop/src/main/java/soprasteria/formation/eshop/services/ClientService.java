package soprasteria.formation.eshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import soprasteria.formation.eshop.entities.Client;
import soprasteria.formation.eshop.exceptions.ClientException;
import soprasteria.formation.eshop.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepo;
	@Autowired
	private CommandeService commandesSrv;

	private void checkClient(Client client) {
		if (client == null) {
			throw new ClientException("client null");
		}
		if (client.getNom() == null || client.getNom().isEmpty()) {
			throw new ClientException("nom obligatoire");
		}
	}

	private void checkId(Long id) {
		if (id == null) {
			throw new ClientException("id null");
		}
	}

	public Client create(Client client) {
		checkClient(client);
		return clientRepo.save(client);
	}

	public Client update(Client client) {
		Client clientEnBase = getById(client.getId());
		checkClient(client);
		clientEnBase.setNom(client.getNom());
		clientEnBase.setPrenom(client.getPrenom());
		clientEnBase.setAdresse(client.getAdresse());
		return clientRepo.save(clientEnBase);
	}

	public Client getById(Long id) {
		checkId(id);
		return clientRepo.findById(id).orElseThrow(() -> {
			throw new ClientException("id inconnu");
		});
	}

	public Client getByIdWithCommandes(Long id) {
		checkId(id);
		return clientRepo.findByIdFetchCommandes(id).orElseThrow(() -> {
			throw new ClientException("id inconnu");
		});
	}

	public List<Client> getAll() {
		return clientRepo.findAll();
	}

	public List<Client> getByNom(String nom) {
		return clientRepo.findByNomContaining(nom);
	}

	public Page<Client> getPage() {
		return getPage(0, 20);
	}

	public Page<Client> getPage(int size) {
		return getPage(0, size);
	}

	public Page<Client> getPage(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return getPage(pageable);
	}

	public Page<Client> getPage(Pageable pageable) {
		return clientRepo.findAll(pageable);
	}

	public void delete(Client client) {
		delete(client.getId());
	}

	public void delete(Long id) {
		Client client = getByIdWithCommandes(id);
		client.getCommandes().forEach(commandesSrv::delete);
		client.setCommandes(null);
		clientRepo.delete(client);

	}

}
