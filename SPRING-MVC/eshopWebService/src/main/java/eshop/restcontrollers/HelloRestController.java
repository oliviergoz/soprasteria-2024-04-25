package eshop.restcontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eshop.model.Categorie;
import eshop.model.Utilisateur;

@RestController
public class HelloRestController {

	@GetMapping("/hello")
	public String sayHello() {
		return "hello";
	}

	@GetMapping("/utilisateur")
	public Utilisateur getUtilisateur() {
		return new Utilisateur("olivier", "gozlan", new Categorie("vip"));
	}

	@PostMapping("/utilisateur")
	public Utilisateur createUtilisateur(@RequestParam String prenom,@RequestParam String nom) {
		Utilisateur utilisateur = new Utilisateur(prenom, nom);
		System.out.println(utilisateur.getPrenom() + " " + utilisateur.getNom());
		return utilisateur;
	}
	
	@PostMapping("/utilisateur/create")
	public void createUtilisateur(@RequestBody Utilisateur utilisateur) {
		System.out.println(utilisateur.getPrenom() + " " + utilisateur.getNom());
		
	}
	

}
