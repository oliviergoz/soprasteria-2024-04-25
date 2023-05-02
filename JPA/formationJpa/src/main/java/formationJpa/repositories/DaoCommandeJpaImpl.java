package formationJpa.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import formationJpa.entities.Client;
import formationJpa.entities.Commande;

public class DaoCommandeJpaImpl implements DaoCommande {
	@Override
	public void insert(Commande obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Commande update(Commande obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Commande obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();
	}

	@Override
	public void deleteByKey(Long key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Commande.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Commande findByKey(Long key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		Commande commande = em.find(Commande.class, key);
		em.close();
		return commande;
	}

	@Override
	public List<Commande> findAll() {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Commande> query = em.createQuery("from Commande", Commande.class);
		List<Commande> commandes = query.getResultList();
		em.close();
		return commandes;
	}

	// client=>null
	public void setClientToNullByClient(Client client) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("update Commande c set c.client=null where c.client=:client");
		query.setParameter("client", client);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		query.executeUpdate();
		tx.commit();
		em.close();
	}

	// deleteByClient
	public void deleteByClient(Client client) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("delete Commande c where c.client=:client");
		query.setParameter("client", client);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		query.executeUpdate();
		tx.commit();
		em.close();
	}
}
