package soprasteria.formation.eshop.restcontrollers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import soprasteria.formation.eshop.entities.Compte;
import soprasteria.formation.eshop.entities.jsonviews.JsonViews;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
//manque une annotation pour angular
public class AuthentificationRestController {

	@GetMapping("")
	@JsonView(JsonViews.CompteWithClient.class)
	public Compte authentification(@AuthenticationPrincipal Compte compte) {
		return compte;
	}
}
