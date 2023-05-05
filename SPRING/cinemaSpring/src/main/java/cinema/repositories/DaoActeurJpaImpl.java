package cinema.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import cinema.entities.Acteur;

@Repository
public class DaoActeurJpaImpl implements DaoActeur {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void insert(Acteur obj) {
		em.persist(obj);
	}

	@Override
	@Transactional
	public Acteur update(Acteur obj) {
		Acteur acteur = em.merge(obj);
		return acteur;
	}

	@Override
	@Transactional
	public void delete(Acteur obj) {
		em.remove(em.merge(obj));
	}

	@Override
	@Transactional
	public void deleteByKey(Long key) {
		em.remove(em.find(Acteur.class, key));
	}

	@Override
	public Acteur findByKey(Long key) {
		Acteur acteur = em.find(Acteur.class, key);
		return acteur;
	}

	@Override
	public List<Acteur> findAll() {
		TypedQuery<Acteur> query = em.createQuery("from Acteur", Acteur.class);
		List<Acteur> acteurs = query.getResultList();
		return acteurs;
	}

	@Override
	public Acteur findByIdFetchFilms(Long id) {
		TypedQuery<Acteur> query = em.createQuery("from Acteur a left join fetch a.films where a.id=:id", Acteur.class);
		query.setParameter("id", id);
		Acteur acteur = query.getSingleResult();
		return acteur;
	}

}
