package eshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fournisseur")
public class FournisseurController {
	
	@GetMapping("/list")
	public String list() {
		return "fournisseur/list";
	}
	
	@GetMapping("/form")
	public String form() {
		return "fournisseur/edit";
	}
}
