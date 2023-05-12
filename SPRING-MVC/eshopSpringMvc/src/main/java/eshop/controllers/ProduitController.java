package eshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eshop.entities.Produit;
import eshop.services.FournisseurService;
import eshop.services.ProduitService;

@Controller
@RequestMapping("/produit")
public class ProduitController {

	@Autowired
	private ProduitService produitSrv;
	@Autowired
	private FournisseurService fournisseurSrv;

	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("produits", produitSrv.getAll());
		return "produit/list";
	}

	@GetMapping("/update")
	public String update(@RequestParam Long id, Model model) {
		return goForm(produitSrv.getById(id), model);
	}

	@GetMapping("/add")
	public String add(Model model) {
		return goForm(new Produit(), model);
	}

	private String goForm(Produit produit, Model model) {
		model.addAttribute("produit", produit);
		model.addAttribute("fournisseurs", fournisseurSrv.getAll());
		return "produit/edit";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Long id, Model model) {
		produitSrv.delete(id);
		return "redirect:/produit";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Produit produit, Model model) {
		if (produit.getId() == null) {
			produitSrv.create(produit);
		} else {
			produitSrv.update(produit);
		}
		return "redirect:/produit";
	}

}
