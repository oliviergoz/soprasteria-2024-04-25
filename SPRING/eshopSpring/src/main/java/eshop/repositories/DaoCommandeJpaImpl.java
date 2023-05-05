package eshop.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import eshop.entities.Client;
import eshop.entities.Commande;

@Repository
public class DaoCommandeJpaImpl implements DaoCommande {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void insert(Commande obj) {
		em.persist(obj);
	}

	@Override
	@Transactional
	public Commande update(Commande obj) {
		obj = em.merge(obj);
		return obj;
	}

	@Override
	@Transactional
	public void delete(Commande obj) {
		em.remove(em.merge(obj));
	}

	@Override
	@Transactional
	public void deleteByKey(Long key) {
		em.remove(em.find(Commande.class, key));
	}

	@Override
	public Commande findByKey(Long key) {
		Commande commande = em.find(Commande.class, key);
		return commande;
	}

	@Override
	public List<Commande> findAll() {
		TypedQuery<Commande> query = em.createQuery("from Commande", Commande.class);
		List<Commande> commandes = query.getResultList();
		return commandes;
	}

	// client=>null
	@Transactional
	public void setClientToNullByClient(Client client) {
		Query query = em.createQuery("update Commande c set c.client=null where c.client=:client");
		query.setParameter("client", client);
		query.executeUpdate();
	}

	// deleteByClient
	@Transactional
	public void deleteByClient(Client client) {
		Query query = em.createQuery("delete Commande c where c.client=:client");
		query.setParameter("client", client);
		query.executeUpdate();
	}
}
