package formationJpa.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import formationJpa.entities.Achat;
import formationJpa.entities.AchatKey;

public class DaoAchatJpaImpl implements DaoAchat{
	@Override
	public void insert(Achat obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Achat update(Achat obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Achat obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();
	}

	@Override
	public void deleteByKey(AchatKey key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Achat.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Achat findByKey(AchatKey key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		Achat achat = em.find(Achat.class, key);
		em.close();
		return achat;
	}

	@Override
	public List<Achat> findAll() {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Achat> query = em.createQuery("from Achat", Achat.class);
		List<Achat> achats = query.getResultList();
		em.close();
		return achats;
	}
}
