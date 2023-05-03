package cinemaJpa.repositories;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import cinemaJpa.entities.Acteur;
import cinemaJpa.entities.Film;
import cinemaJpa.entities.Langue;

class DaoFilmImpl implements DaoFilm {

	@Override
	public void insert(Film obj) {
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
	public Film update(Film obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Film film = null;
		tx.begin();
		try {
			film = em.merge(obj);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		}
		em.close();
		return film;
	}

	@Override
	public void delete(Film obj) {
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
			em.remove(em.find(Film.class, key));
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		}
		em.close();
	}

	@Override
	public Film findByKey(Long key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		Film film = em.find(Film.class, key);
		em.close();
		return film;
	}

	@Override
	public List<Film> findAll() {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Film> query = em.createQuery("from Film", Film.class);
		List<Film> films = query.getResultList();
		em.close();
		return films;
	}

	@Override
	public List<Film> findByDisponible(boolean disponible) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Film> query = em.createQuery("from Film f where f.disponible=:disponible", Film.class);
		query.setParameter("disponible", disponible);
		List<Film> films = query.getResultList();
		em.close();
		return films;
	}

	@Override
	public List<Film> findByAnneeSortie(int annee) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Film> query = em.createQuery("from Film f where year(f.sortie)=:annee", Film.class);
		query.setParameter("annee", annee);
		List<Film> films = query.getResultList();
		em.close();
		return films;
	}

	@Override
	public List<Film> findByActeur(Acteur acteur) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Film> query = em.createQuery("from Film f join f.acteurs as a where a=:acteur", Film.class);
		query.setParameter("acteur", acteur);
		List<Film> films = query.getResultList();
		em.close();
		return films;
	}

	@Override
	public List<Film> findByEvalutationsNote(int note) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Film> query = em.createQuery(
				"select e.id.film from Evaluation e group by e.id.film having trunc(avg(e.note))=:note", Film.class);
		query.setParameter("note", note);
		List<Film> films = query.getResultList();
		em.close();
		return films;
	}

	@Override
	public List<Film> findBySeancesDateSeance(LocalDate dateSeance) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Film> query = em.createQuery("from Film f join f.seances as s where s.dateSeance=:dateSeance",
				Film.class);
		query.setParameter("dateSeance", dateSeance);
		List<Film> films = query.getResultList();
		em.close();
		return films;
	}

	@Override
	public List<Film> findBySeancesLangue(Langue langue) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Film> query = em.createQuery("from Film f join f.seances as s where s.langue=:langue", Film.class);
		query.setParameter("langue", langue);
		List<Film> films = query.getResultList();
		em.close();
		return films;
	}

	@Override
	public List<Film> findBySeancesDateSeanceAndSeanceLangue(LocalDate dateSeance, Langue langue) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Film> query = em.createQuery(
				"from Film f join f.seances as s where s.langue=:langue and s.dateSeance=:dateSeance", Film.class);
		query.setParameter("langue", langue);
		query.setParameter("dateSeance", dateSeance);
		List<Film> films = query.getResultList();
		em.close();
		return films;
	}

	@Override
	public Film findByIdFetchEvaluations(Long id) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Film> query = em.createQuery("from Film f left join fetch f.evaluations where f.id=:id", Film.class);
		query.setParameter("id", id);
		Film film = null;
		film = query.getSingleResult();
		em.close();
		return film;
	}

	@Override
	public Film findByIdFetchActeurs(Long id) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Film> query = em.createQuery("from Film f left join fetch f.acteurs where f.id=:id", Film.class);
		query.setParameter("id", id);
		Film film = null;
		film = query.getSingleResult();
		em.close();
		return film;
	}

	@Override
	public Film findByIdFetchSeances(Long id) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Film> query = em.createQuery("from Film f left join fetch f.seances where f.id=:id", Film.class);
		query.setParameter("id", id);
		Film film = null;
		film = query.getSingleResult();
		em.close();
		return film;
	}

	@Override
	public Film findByIdFetchEvaluationsAndActeursAndSeances(Long id) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Film> query = em.createQuery(
				"from Film f left join fetch f.evaluations left join fetch f.acteurs left join fetch f.seances where f.id=:id",
				Film.class);
		query.setParameter("id", id);
		Film film = null;
		film = query.getSingleResult();
		em.close();
		return film;
	}

	@Override
	public List<Film> findTop10() {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Film> query = em
				.createQuery("select e.id.film from Evaluation e group by e.id.film order by avg(e.note)", Film.class);
		query.setMaxResults(10);
		List<Film> films = query.getResultList();
		em.close();
		return films;
	}

}
