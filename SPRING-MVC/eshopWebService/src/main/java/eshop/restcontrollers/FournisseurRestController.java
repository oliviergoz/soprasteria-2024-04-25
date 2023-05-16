package eshop.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import eshop.entities.Fournisseur;
import eshop.entities.jsonviews.JsonViews;
import eshop.entities.jsonviews.JsonViews.Base;
import eshop.services.FournisseurService;

@RestController
@RequestMapping("/api/fournisseur")
public class FournisseurRestController {

	@Autowired
	private FournisseurService fournisseurSrv;
	
	@GetMapping("")
	@JsonView(JsonViews.Fournisseur.class)
	public List<Fournisseur> getAll() {
		return fournisseurSrv.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Fournisseur.class)
	public Fournisseur getById(@PathVariable("id") Long id) {
		return fournisseurSrv.getById(id);
	}
	
	@GetMapping("/{id}/produits")
	@JsonView(JsonViews.FournisseurWithProduits.class)
	public Fournisseur getByIdWithProduits(@PathVariable("id") Long id) {
		return fournisseurSrv.getByIdWithProduits(id);
	}
}
