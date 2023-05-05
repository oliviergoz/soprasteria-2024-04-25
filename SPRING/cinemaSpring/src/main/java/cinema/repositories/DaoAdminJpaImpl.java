package cinema.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import cinema.entities.Admin;


public class DaoAdminJpaImpl implements DaoAdmin{

	@Override
	public void insert(Admin obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.persist(obj);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		}
		em.close();
	}

	@Override
	public Admin update(Admin obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Admin admin = null;
		tx.begin();
		try {
			admin = em.merge(obj);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		}
		em.close();
		return admin;
	}

	@Override
	public void delete(Admin obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.remove(em.merge(obj));
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		}
		em.close();
	}

	@Override
	public void deleteByKey(Long key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.remove(em.find(Admin.class, key));
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		}
		em.close();
	}

	@Override
	public Admin findByKey(Long key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		Admin admin = em.find(Admin.class, key);
		em.close();
		return admin;
	}

	@Override
	public List<Admin> findAll() {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Admin> query = em.createQuery("from Admin",Admin.class);
		List<Admin> admins = query.getResultList();
		em.close();
		return admins;
	}

}
