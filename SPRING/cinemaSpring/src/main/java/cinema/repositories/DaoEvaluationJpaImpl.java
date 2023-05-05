package cinema.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import cinema.entities.Evaluation;
import cinema.entities.EvaluationKey;

public class DaoEvaluationJpaImpl implements DaoEvaluation {
	@Override
	public void insert(Evaluation obj) {
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
	public Evaluation update(Evaluation obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Evaluation evaluation = null;
		tx.begin();
		try {
			evaluation = em.merge(obj);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		}
		em.close();
		return evaluation;
	}

	@Override
	public void delete(Evaluation obj) {
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
	public void deleteByKey(EvaluationKey key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.remove(em.find(Evaluation.class, key));
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		}
		em.close();
	}

	@Override
	public Evaluation findByKey(EvaluationKey key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		Evaluation evaluation = em.find(Evaluation.class, key);
		em.close();
		return evaluation;
	}

	@Override
	public List<Evaluation> findAll() {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Evaluation> query = em.createQuery("from Evaluation", Evaluation.class);
		List<Evaluation> evaluations = query.getResultList();
		em.close();
		return evaluations;
	}
}
