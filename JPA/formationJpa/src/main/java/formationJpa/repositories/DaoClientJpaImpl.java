package formationJpa.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import formationJpa.entities.Client;
import formationJpa.entities.Fournisseur;

public class DaoClientJpaImpl implements DaoClient {

	@Override
	public void insert(Client obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();

	}

	@Override
	public Client update(Client obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Client obj) {
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
		em.remove(em.find(Client.class, key));
		tx.commit();
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
		// select =>remonter des infos
		// from =>Entity
		// where

		TypedQuery<Client> query = em.createQuery("select c from Client c", Client.class);
		List<Client> clients = query.getResultList();
		em.close();
		return clients;
	}

	public List<Client> findByNom(String nom) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Client> query = em.createQuery("select c from Client c where c.nom=:nom", Client.class);
		// le nom du parametre apres : ici "nom"
		query.setParameter("nom", nom);
		List<Client> clients = query.getResultList();
		em.close();
		return clients;
	}

	public List<Client> findByNomContaining(String nom) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Client> query = em.createQuery("select c from Client c where c.nom like :nom", Client.class);
		// le nom du parametre apres : ici "nom"
		query.setParameter("nom", "%" + nom + "%");
		List<Client> clients = query.getResultList();
		em.close();
		return clients;
	}

	public List<Client> findByPrenomAndNom(String prenom, String nom) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Client> query = em.createQuery("select c from Client c where c.nom=:nom and c.prenom=:prenom",
				Client.class);
		query.setParameter("prenom", prenom);
		query.setParameter("nom", nom);
		List<Client> clients = query.getResultList();
		em.close();
		return clients;
	}

	public List<Client> findByPrenomContainingAndNomContaining(String prenom, String nom) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Client> query = em
				.createQuery("select c from Client c where c.nom like :nom and c.prenom like :prenom", Client.class);
		query.setParameter("prenom", "%" + prenom + "%");
		query.setParameter("nom", "%" + nom + "%");
		List<Client> clients = query.getResultList();
		em.close();
		return clients;
	}

	public long count() {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();

		TypedQuery<Long> query = em.createQuery("select count(c) from Client c", Long.class);
		Long count = query.getSingleResult();
		em.close();
		return count;
	}

	public Client findByKeyFetchCommandes(Long key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Client> query = em.createQuery("select c from Client c left join fetch c.commandes where c.id=:key",
				Client.class);
		query.setParameter("key", key);
		Client client = null;
		try {
			client = query.getSingleResult();
		} catch (NoResultException ex) {
			// erreur traitee=>je ne fais rien
		}
		em.close();
		return client;
	}

	public Client findByKeyAndYearFetchCommandes(Long key, int year) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Client> query = em.createQuery(
				"select c from Client as c left join fetch c.commandes as cmd where c.id=:key and year(cmd.date)=:year",
				Client.class);
		query.setParameter("key", key);
		query.setParameter("year", year);
		Client client = null;
		try {
			client = query.getSingleResult();
		} catch (NoResultException ex) {
			// erreur traitee=>je ne fais rien
		}
		em.close();
		return client;
	}
	
	
	//juste pour l'exemple
	//à ne pas faire dans un cas concret
	//requete trop lourde pour rien le plus souvent
	public List<Client> findAllFetchCommandes(){
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Client> query = em.createQuery("select distinct c from Client c left join fetch c.commandes", Client.class);
		List<Client> clients = query.getResultList();
		em.close();
		return clients;
	}

}
