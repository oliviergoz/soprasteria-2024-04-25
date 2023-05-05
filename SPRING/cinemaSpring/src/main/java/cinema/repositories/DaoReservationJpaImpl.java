package cinema.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import cinema.entities.Reservation;

public class DaoReservationJpaImpl implements DaoReservation {
	@Override
	public void insert(Reservation obj) {
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
	public Reservation update(Reservation obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Reservation reservation = null;
		tx.begin();
		try {
			reservation = em.merge(obj);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		}
		em.close();
		return reservation;
	}

	@Override
	public void delete(Reservation obj) {
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
			em.remove(em.find(Reservation.class, key));
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		}
		em.close();
	}

	@Override
	public Reservation findByKey(Long key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		Reservation reservation = em.find(Reservation.class, key);
		em.close();
		return reservation;
	}

	@Override
	public List<Reservation> findAll() {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Reservation> query = em.createQuery("from Reservation",Reservation.class);
		List<Reservation> reservations = query.getResultList();
		em.close();
		return reservations;
	}
}
