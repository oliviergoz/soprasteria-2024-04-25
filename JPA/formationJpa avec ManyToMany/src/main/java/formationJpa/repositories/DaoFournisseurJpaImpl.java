package formationJpa.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import formationJpa.entities.Fournisseur;

public class DaoFournisseurJpaImpl implements DaoFournisseur {

	@Override
	public void insert(Fournisseur obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Fournisseur update(Fournisseur obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Fournisseur obj) {
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
		em.remove(em.find(Fournisseur.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Fournisseur findByKey(Long key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		Fournisseur fournisseur = em.find(Fournisseur.class, key);
		System.out.println("--------------------------");
		//System.out.println(fournisseur.getProduits());
		em.close();
		return fournisseur;
	}

	@Override
	public List<Fournisseur> findAll() {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Fournisseur> query = em.createQuery("from Fournisseur", Fournisseur.class);
		List<Fournisseur> fournisseurs = query.getResultList();
		em.close();
		return fournisseurs;
	}

}
