package eshop.repositories;

import java.util.ArrayList;
import java.util.List;

import eshop.entities.Produit;

public class DaoProduitForTest implements DaoProduit {

	@Override
	public void insert(Produit obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public Produit update(Produit obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Produit obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteByKey(Long key) {
		// TODO Auto-generated method stub

	}

	@Override
	public Produit findByKey(Long key) {
		Produit p = new Produit();
		p.setId(9999L);
		p.setNom("produit pour test");
		p.setDescription("description pour test");
		p.setPrix(10000);
		return p;
	}

	@Override
	public List<Produit> findAll() {
		List<Produit> produits = new ArrayList<>();
		Produit p = new Produit();
		p.setId(1L);
		p.setNom("produit pour test");
		p.setDescription("description pour test");
		p.setPrix(10000);
		produits.add(p);
		p = new Produit();
		p.setId(2L);
		p.setNom("produit2 pour test");
		p.setDescription("description2 pour test");
		p.setPrix(20000);
		produits.add(p);
		return produits;
	}

}
