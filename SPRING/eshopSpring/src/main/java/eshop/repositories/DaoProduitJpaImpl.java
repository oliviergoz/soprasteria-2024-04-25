package eshop.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import eshop.entities.Produit;

@Repository
class DaoProduitJpaImpl implements DaoProduit {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void insert(Produit obj) {
		em.persist(obj);
	}

	@Override
	@Transactional
	public Produit update(Produit obj) {
		obj = em.merge(obj);
		return obj;
	}

	@Override
	@Transactional
	public void delete(Produit obj) {
		em.remove(em.merge(obj));
	}

	@Override
	@Transactional
	public void deleteByKey(Long key) {
		em.remove(em.find(Produit.class, key));
	}

	@Override
	public Produit findByKey(Long key) {
		Produit produit = em.find(Produit.class, key);
		return produit;
	}

	@Override
	public List<Produit> findAll() {
		TypedQuery<Produit> query = em.createQuery("from Produit", Produit.class);
		List<Produit> produits = query.getResultList();
		return produits;
	}

}
