package soprasteria.formation.eshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import soprasteria.formation.eshop.entities.Fournisseur;
import soprasteria.formation.eshop.entities.Produit;
import soprasteria.formation.eshop.exceptions.ProduitException;
import soprasteria.formation.eshop.repositories.AchatRepository;
import soprasteria.formation.eshop.repositories.ProduitRepository;

@Service
public class ProduitService {
	@Autowired
	private ProduitRepository produitRepo;
	@Autowired
	private AchatRepository achatRepo;

	public Produit create(Produit produit) {
		if (produit.getNom() == null || produit.getNom().isEmpty()) {
			throw new ProduitException("nom obligatoire");
		}
		if (produit.getPrix() < 0.01) {
			throw new ProduitException("prix obligatoire");
		}
		return produitRepo.save(produit);
	}

	public Produit create(String nom, String description, double prix, Fournisseur fournisseur) {
		return this.create(new Produit(nom, description, prix, fournisseur));
	}

	public Produit getById(Long id) {
//		Optional<Produit> opt=produitRepo.findById(id);
//		if(opt.isEmpty()) {
//			throw new ProduitException("id inconnu");
//		}
//		return opt.get();
		if (id == null) {
			throw new ProduitException("id obligatoire");
		}
		return produitRepo.findById(id).orElseThrow(() -> {
			throw new ProduitException("id inconnu");
		});

		// return produitRepo.findById(id).orElseThrow(ProduitException::new);
		// pas de parametre avec cette derniere solution
	}

	public Produit update(Produit produit) {
		Produit produitEnBase = this.getById(produit.getId());
		if (produit.getNom() != null && !produit.getNom().isEmpty()) {
			produitEnBase.setNom(produit.getNom());
		}
		if (produit.getPrix() >= 0.01) {
			produitEnBase.setPrix(produit.getPrix());
		}
		produitEnBase.setFournisseur(produit.getFournisseur());
		produitEnBase.setDescription(produit.getDescription());
		return produitRepo.save(produitEnBase);
	}

	public List<Produit> getAll() {
		return produitRepo.findAll();
	}

	public Page<Produit> getPage() {
		return getPage(0, 20);
	}

	public Page<Produit> getPage(int size) {
		return getPage(0, size);
	}

	public Page<Produit> getPage(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return getPage(pageable);
	}
	
	public Page<Produit> getPage(Pageable pageable){
		return produitRepo.findAll(pageable);
	}

	public void delete(Produit produit) {
		achatRepo.setProduitToNull(produit);
		produitRepo.delete(produit);
	}

	public void delete(Long id) {
		this.delete(this.getById(id));
	}
}
