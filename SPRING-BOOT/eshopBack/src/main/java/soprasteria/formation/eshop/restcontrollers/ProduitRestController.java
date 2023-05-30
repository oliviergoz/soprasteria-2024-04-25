package soprasteria.formation.eshop.restcontrollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import soprasteria.formation.eshop.entities.Produit;
import soprasteria.formation.eshop.entities.jsonviews.JsonViews;
import soprasteria.formation.eshop.services.ProduitService;

@RestController
@RequestMapping("/api/produit")
@CrossOrigin(origins = "http://localhost:4200")
public class ProduitRestController {
	@Autowired
	private ProduitService produitSrv;
	
	@GetMapping("")
	@JsonView(JsonViews.ProduitWithFournisseur.class)
	public List<Produit> getAll() {
		return produitSrv.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.ProduitWithFournisseur.class)
	public Produit getById(@PathVariable("id") Long id) {
		return produitSrv.getById(id);
	}
	
	
	@PostMapping("")
	@JsonView(JsonViews.ProduitWithFournisseur.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Produit create(@Valid @RequestBody Produit produit,BindingResult br) {
		if(br.hasErrors()) {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return produitSrv.create(produit);
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.ProduitWithFournisseur.class)
	public Produit update(@Valid @RequestBody Produit produit,BindingResult br,@PathVariable Long id) {
		produit.setId(id);
		return produitSrv.update(produit);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		produitSrv.delete(id);
	}
}	
