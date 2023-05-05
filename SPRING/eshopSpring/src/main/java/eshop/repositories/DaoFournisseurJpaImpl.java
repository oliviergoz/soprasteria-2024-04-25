package eshop.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import eshop.entities.Fournisseur;

@Repository
public class DaoFournisseurJpaImpl implements DaoFournisseur {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void insert(Fournisseur obj) {
		em.persist(obj);
	}

	@Override
	@Transactional
	public Fournisseur update(Fournisseur obj) {
		obj = em.merge(obj);
		return obj;
	}

	@Override
	@Transactional
	public void delete(Fournisseur obj) {
		em.remove(em.merge(obj));
	}

	@Override
	@Transactional
	public void deleteByKey(Long key) {
		em.remove(em.find(Fournisseur.class, key));
	}

	@Override
	public Fournisseur findByKey(Long key) {
		Fournisseur fournisseur = em.find(Fournisseur.class, key);
		return fournisseur;
	}

	@Override
	public List<Fournisseur> findAll() {
		TypedQuery<Fournisseur> query = em.createQuery("from Fournisseur", Fournisseur.class);
		List<Fournisseur> fournisseurs = query.getResultList();
		return fournisseurs;
	}

}
