package soprasteria.formation.eshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import soprasteria.formation.eshop.entities.Compte;
import soprasteria.formation.eshop.entities.Role;
import soprasteria.formation.eshop.exceptions.CompteException;
import soprasteria.formation.eshop.repositories.CompteRepository;

@Service
public class CompteService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private CompteRepository compteRepo;

	public Compte getByLogin(String login) {
		return compteRepo.findByLogin(login).orElseThrow(() -> {
			throw new UsernameNotFoundException("compte inconnu");
		});
	}

	public boolean loginExist(String login){
		return compteRepo.existsByLogin(login);
	}

	private Compte create(Compte compte) {
		compte.setPassword(passwordEncoder.encode(compte.getPassword()));
		if(!loginExist(compte.getLogin())){
			return compteRepo.save(compte);
		}
		throw new CompteException();
	}
	
	public Compte createAdmin(String login,String password) {
		return create(new Compte(login, password, Role.ROLE_ADMIN));
	}
	
	public Compte createClient(String login,String password) {
		return create(new Compte(login, password, Role.ROLE_CLIENT));
	}
}
