package formationJpa.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import formationJpa.entities.Client;

public class DaoClientJpaImpl implements DaoClient{

	@Override
	public void insert(Client obj) {
		EntityManager em=JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
		
	}

	@Override
	public Client update(Client obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Client obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByKey(Long key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Client findByKey(Long key) {
		EntityManager em=JpaContext.getEntityManagerFactory().createEntityManager();
		Client client=em.find(Client.class, key);
		em.close();
		return client;
	}

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
