package eshop.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eshop.entities.Client;
import eshop.entities.Fournisseur;

@Repository
public class DaoClientJpaImpl implements DaoClient {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void insert(Client obj) {
		em.persist(obj);
	}

	@Override
	@Transactional
	public Client update(Client obj) {
		return em.merge(obj);
	}

	@Override
	@Transactional
	public void delete(Client obj) {
		em.remove(em.merge(obj));
	}

	@Override
	@Transactional
	public void deleteByKey(Long key) {
		em.remove(em.find(Client.class, key));
	}

	@Override
	public Client findByKey(Long key) {
		return em.find(Client.class, key);
	}

	@Override
	public List<Client> findAll() {
		TypedQuery<Client> query = em.createQuery("select c from Client c", Client.class);
		List<Client> clients = query.getResultList();
		return clients;
	}

	public List<Client> findByNom(String nom) {
		TypedQuery<Client> query = em.createQuery("select c from Client c where c.nom=:nom", Client.class);
		query.setParameter("nom", nom);
		List<Client> clients = query.getResultList();
		return clients;
	}

	public List<Client> findByNomContaining(String nom) {
		TypedQuery<Client> query = em.createQuery("select c from Client c where c.nom like :nom", Client.class);
		query.setParameter("nom", "%" + nom + "%");
		List<Client> clients = query.getResultList();
		return clients;
	}

	public List<Client> findByPrenomAndNom(String prenom, String nom) {
		TypedQuery<Client> query = em.createQuery("select c from Client c where c.nom=:nom and c.prenom=:prenom",
				Client.class);
		query.setParameter("prenom", prenom);
		query.setParameter("nom", nom);
		List<Client> clients = query.getResultList();
		return clients;
	}

	public List<Client> findByPrenomContainingAndNomContaining(String prenom, String nom) {
		TypedQuery<Client> query = em
				.createQuery("select c from Client c where c.nom like :nom and c.prenom like :prenom", Client.class);
		query.setParameter("prenom", "%" + prenom + "%");
		query.setParameter("nom", "%" + nom + "%");
		List<Client> clients = query.getResultList();
		return clients;
	}

	public long count() {
		TypedQuery<Long> query = em.createQuery("select count(c) from Client c", Long.class);
		Long count = query.getSingleResult();
		return count;
	}

	public Client findByKeyFetchCommandes(Long key) {
		TypedQuery<Client> query = em.createQuery("select c from Client c left join fetch c.commandes where c.id=:key",
				Client.class);
		query.setParameter("key", key);
		Client client = null;
		try {
			client = query.getSingleResult();
		} catch (NoResultException ex) {
			// erreur traitee=>je ne fais rien
		}
		return client;
	}

	public Client findByKeyAndYearFetchCommandes(Long key, int year) {
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
		return client;
	}

}
