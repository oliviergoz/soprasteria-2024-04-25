package soprasteria.formation.eshop.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import soprasteria.formation.eshop.entities.Produit;
import soprasteria.formation.eshop.services.FournisseurService;
import soprasteria.formation.eshop.services.ProduitService;

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
	public String save(@Valid @ModelAttribute Produit produit,BindingResult br, Model model) {
		if(br.hasErrors()) {
			return goForm(produit, model);
		}
		if(produit.getFournisseur()!=null&&produit.getFournisseur().getId()==null) {
			produit.setFournisseur(null);
		}
		if (produit.getId() == null) {
			produitSrv.create(produit);
		} else {
			produitSrv.update(produit);
		}
		return "redirect:/produit";
	}

}
