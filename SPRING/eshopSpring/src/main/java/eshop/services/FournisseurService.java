package eshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import eshop.entities.Fournisseur;
import eshop.exceptions.FournisseurException;
import eshop.repositories.FournisseurRepository;
import eshop.repositories.ProduitRepository;

@Service
public class FournisseurService {

	@Autowired
	private FournisseurRepository fournisseurRepo;
	@Autowired
	private ProduitRepository produitRepo;

	private void checkFournisseur(Fournisseur fournisseur) {
		if (fournisseur == null) {
			throw new FournisseurException("fournisseur null");
		}
		if (fournisseur.getNom() == null || fournisseur.getNom().isEmpty()) {
			throw new FournisseurException("nom obligatoire");
		}
		if (fournisseur.getContact() == null || fournisseur.getContact().isEmpty()) {
			throw new FournisseurException("contact obligatoire");
		}
	}

	private void checkId(Long id) {
		if (id == null) {
			throw new FournisseurException("id null");
		}
	}

	public Fournisseur create(Fournisseur fournisseur) {
		checkFournisseur(fournisseur);
		return fournisseurRepo.save(fournisseur);
	}

	public Fournisseur update(Fournisseur fournisseur) {
		Fournisseur fournisseurEnBase = getById(fournisseur.getId());
		checkFournisseur(fournisseur);
		fournisseurEnBase.setNom(fournisseur.getNom());
		fournisseurEnBase.setContact(fournisseur.getContact());
		fournisseurEnBase.setAdresse(fournisseur.getAdresse());
		return fournisseurRepo.save(fournisseurEnBase);
	}

	public Fournisseur getById(Long id) {
		checkId(id);
		return fournisseurRepo.findById(id).orElseThrow(() -> {
			throw new FournisseurException("id inconnu");
		});
	}

	public Fournisseur getByIdWithProduits(Long id) {
		checkId(id);
		return fournisseurRepo.findByIdFetchProduits(id).orElseThrow(() -> {
			throw new FournisseurException("id inconnu");
		});
	}

	public List<Fournisseur> getAll() {
		return fournisseurRepo.findAll();
	}

	public Page<Fournisseur> getPage() {
		return getPage(0, 20);
	}

	public Page<Fournisseur> getPage(int size) {
		return getPage(0, size);
	}

	public Page<Fournisseur> getPage(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return getPage(pageable);
	}

	public Page<Fournisseur> getPage(Pageable pageable) {
		return fournisseurRepo.findAll(pageable);
	}

	public void delete(Fournisseur fournisseur) {
		delete(fournisseur.getId());
	}

	public void delete(Long id) {
		Fournisseur fournisseurEnBase = getById(id);
		produitRepo.setFournisseurToNull(fournisseurEnBase);
		fournisseurRepo.delete(fournisseurEnBase);
	}
}
