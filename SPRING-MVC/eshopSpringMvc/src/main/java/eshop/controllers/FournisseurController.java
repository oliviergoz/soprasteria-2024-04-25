package eshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eshop.entities.Fournisseur;
import eshop.services.FournisseurService;

@Controller
@RequestMapping("/fournisseur")
public class FournisseurController {

	@Autowired
	private FournisseurService fournisseurSrv;

	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("fournisseurs", fournisseurSrv.getAll());
		return "fournisseur/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam(name = "id") Long id, Model model) {
		fournisseurSrv.delete(id);
		model.addAttribute("delete",id );
		return "redirect:/fournisseur/list";
	}

	@GetMapping("/edit")
	public String update(@RequestParam("id") Long id, Model model) {
		model.addAttribute("fournisseur", fournisseurSrv.getById(id));
		return goForm(model);
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("fournisseur", new Fournisseur());
		return goForm(model);
	}

	private String goForm(Model model) {
		return "fournisseur/edit";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Fournisseur fournisseur, Model model) {
		if (fournisseur.getId() == null) {
			fournisseur = fournisseurSrv.create(fournisseur);
			model.addAttribute("create", fournisseur.getId() );
		} else {
			fournisseur = fournisseurSrv.update(fournisseur);
			model.addAttribute("update", fournisseur.getId());
		}
		return "redirect:/fournisseur/list";
	}

}
