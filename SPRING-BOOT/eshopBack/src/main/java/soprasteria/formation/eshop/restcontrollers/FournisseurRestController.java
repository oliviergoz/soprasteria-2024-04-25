package soprasteria.formation.eshop.restcontrollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
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

import soprasteria.formation.eshop.entities.Fournisseur;
import soprasteria.formation.eshop.entities.jsonviews.JsonViews;
import soprasteria.formation.eshop.services.FournisseurService;

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
	
	@PostMapping("")
	@JsonView(JsonViews.Fournisseur.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Fournisseur create(@Valid @RequestBody Fournisseur fournisseur,BindingResult br) {
		if(br.hasErrors()) {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return fournisseurSrv.create(fournisseur);
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Fournisseur.class)
	public Fournisseur update(@Valid @RequestBody Fournisseur fournisseur,BindingResult br,@PathVariable Long id) {
		fournisseur.setId(id);
		return fournisseurSrv.update(fournisseur);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		fournisseurSrv.delete(id);
	}
	
}
