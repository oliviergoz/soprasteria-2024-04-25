package cinema.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import cinema.entities.Client;

public class DaoClientJpaImpl implements DaoClient {

	@Override
	public void insert(Client obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.persist(obj);
			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.rollback();
		}
		em.close();
	}

	@Override
	public Client update(Client obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Client client = null;
		tx.begin();
		try {
			client = em.merge(obj);
			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.rollback();
		}
		em.close();
		return client;
	}

	@Override
	public void delete(Client obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.remove(em.merge(obj));
			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
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
			em.remove(em.find(Client.class, key));
			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.rollback();
		}
		em.close();
	}

	@Override
	public Client findByKey(Long key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		Client client = em.find(Client.class, key);
		em.close();
		return client;
	}

	@Override
	public List<Client> findAll() {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Client> query = em.createQuery("from Client", Client.class);
		List<Client> clients = query.getResultList();
		em.close();
		return clients;
	}

	public List<Client> findMajeur() {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Client> query = em
				.createQuery("from Client c where timestampdiff(year,c.naissance,current_date)>=18 ", Client.class);
		List<Client> clients = query.getResultList();
		em.close();
		return clients;
	}

	public List<Client> findMineur() {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Client> query = em
				.createQuery("from Client c where timestampdiff(year,c.naissance,current_date)<18 ", Client.class);
		List<Client> clients = query.getResultList();
		em.close();
		return clients;
	}

	public List<Client> findSenior() {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Client> query = em
				.createQuery("from Client c where timestampdiff(year,c.naissance,current_date)>60 ", Client.class);
		List<Client> clients = query.getResultList();
		em.close();
		return clients;
	}

	@Override
	public Client findByIdFetchReservations(Long id) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Client> query = em.createQuery("from Client c left join fetch c.reservations where c.id=:id ",
				Client.class);
		query.setParameter("id", id);
		Client client = null;
		try {
			client = query.getSingleResult();
		} catch (Exception e) {
			// je ne veux pas de l'exception NoResultException
		}
		em.close();
		return client;
	}

	@Override
	public Client findByIdFetchEvaluations(Long id) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Client> query = em.createQuery("from Client c left join fetch c.evaluations where c.id=:id ",
				Client.class);
		query.setParameter("id", id);
		Client client = null;
		try {
			client = query.getSingleResult();
		} catch (Exception e) {
		}
		em.close();
		return client;
	}

	@Override
	public Client findByIdFetchReservationsAndEvaluations(Long id) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Client> query = em.createQuery(
				"from Client c left join fetch c.reservations left join fetch c.evaluations where c.id=:id ",
				Client.class);
		query.setParameter("id", id);
		Client client = null;
		try {
			client = query.getSingleResult();
		} catch (Exception e) {
		}
		em.close();
		return client;
	}

}
