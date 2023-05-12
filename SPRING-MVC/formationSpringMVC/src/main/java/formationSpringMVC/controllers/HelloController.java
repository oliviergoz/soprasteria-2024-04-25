package formationSpringMVC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	// definition de l'url qui amene sur cette methode
	@RequestMapping("/hello")
	// le retour correspond au nom d'une jsp
	public String hello() {
		return "hello";
	}

	@RequestMapping("/bye")
	public String bye() {
		return "bye";
	}
}
