package formationSpringMVC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	// definition de l'url qui amene sur cette methode
	// @RequestMapping(path ="",method = RequestMethod.GET)
	// le retour correspond au nom d'une jsp
	@GetMapping({ "", "/home" })
	public String hello(@RequestParam(name = "prenom", required = false, defaultValue = "world") String prenom,
			@RequestParam(name = "age", required = false, defaultValue = "0") Integer age, Model model) {
		model.addAttribute("prenom", prenom);
		model.addAttribute("age", age);
		return "hello";
	}

	@GetMapping("/bye")
	public String bye() {
		return "bye";
	}

	@PostMapping("/bye")
	public String byeEnPost() {
		return "pageEnPost";
	}
}
