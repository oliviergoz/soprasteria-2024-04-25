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

import soprasteria.formation.eshop.entities.Fournisseur;
import soprasteria.formation.eshop.services.FournisseurService;

@Controller
@RequestMapping("/fournisseur")
public class FournisseurController {

	@Autowired
	private FournisseurService fournisseurSrv;

	@GetMapping({ "", "/list" })
	public String list(Model model) {
		model.addAttribute("fournisseurs", fournisseurSrv.getAll());
		return "fournisseur/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam(name = "id") Long id, Model model) {
		fournisseurSrv.delete(id);
		model.addAttribute("delete", id);
		return "redirect:/fournisseur/list";
	}

	@GetMapping("/edit")
	public String update(@RequestParam("id") Long id, Model model) {
		return goForm(fournisseurSrv.getById(id), model);
	}

	@GetMapping("/add")
	public String add(Model model) {
		return goForm(new Fournisseur(), model);
	}

	private String goForm(Fournisseur fournisseur, Model model) {
		model.addAttribute("fournisseur", fournisseur);
		return "fournisseur/edit";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute Fournisseur fournisseur,BindingResult br, Model model) {
		if(br.hasErrors()) {
			return goForm(fournisseur,model);
		}
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
