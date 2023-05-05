package eshop.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import eshop.entities.Achat;
import eshop.entities.AchatKey;
import eshop.entities.Commande;

@Repository
public class DaoAchatJpaImpl implements DaoAchat {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void insert(Achat obj) {
		em.persist(obj);
	}

	@Override
	@Transactional
	public Achat update(Achat obj) {
		obj = em.merge(obj);
		return obj;
	}

	@Override
	@Transactional
	public void delete(Achat obj) {
		em.remove(em.merge(obj));
	}

	@Override
	@Transactional
	public void deleteByKey(AchatKey key) {
		em.remove(em.find(Achat.class, key));
	}

	@Override
	public Achat findByKey(AchatKey key) {
		Achat achat = em.find(Achat.class, key);
		return achat;
	}

	@Override
	public List<Achat> findAll() {
		TypedQuery<Achat> query = em.createQuery("from Achat", Achat.class);
		List<Achat> achats = query.getResultList();
		return achats;
	}

	@Transactional
	public void deleteByCommande(Commande commande) {
		Query query = em.createQuery("delete Achat a where a.id.commande=:commande");
		query.setParameter("commande", commande);
		query.executeUpdate();
	}
}
