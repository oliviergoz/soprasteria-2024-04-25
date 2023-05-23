package soprasteria.formation.springBoot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import soprasteria.formation.springBoot.entities.Admin;
import soprasteria.formation.springBoot.entities.Client;
import soprasteria.formation.springBoot.entities.Compte;
import soprasteria.formation.springBoot.exceptions.CompteException;
import soprasteria.formation.springBoot.repositories.AdminRepository;
import soprasteria.formation.springBoot.repositories.ClientRepository;

@Service
public class CompteService {

	@Autowired
	private AdminRepository adminRepo;
	@Autowired
	private ClientRepository clientRepo;
	@Autowired
	PasswordEncoder passwordEncoder;

	public Compte getByLogin(String login) throws UsernameNotFoundException {
		Optional<Client> opt = clientRepo.findByLogin(login);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return adminRepo.findByLogin(login).orElseThrow(() -> {
				throw new UsernameNotFoundException("utilisateur inconnu");
			});
		}
	}

	private void checkCompte(Compte compte) {
		if (compte.getLogin() == null || compte.getLogin().isBlank()) {
			throw new CompteException();
		}
	}
	
	private void encodePassword(Compte compte) {
		compte.setPassword(passwordEncoder.encode(compte.getPassword()));
	}

	public Admin createAdmin(Admin admin) {
		checkCompte(admin);
		encodePassword(admin);
		return adminRepo.save(admin);
	}

	public Client createClient(Client client) {
		checkCompte(client);
		encodePassword(client);
		return (Client) clientRepo.save(client);
	}

}
