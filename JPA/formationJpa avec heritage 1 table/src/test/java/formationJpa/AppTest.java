package formationJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import formationJpa.entities.Adresse;
import formationJpa.entities.Client;
import formationJpa.entities.Fournisseur;
import formationJpa.entities.Personne;
import formationJpa.entities.Produit;
import formationJpa.repositories.DaoClient;
import formationJpa.repositories.DaoPersonne;
import formationJpa.repositories.DaoProduit;
import formationJpa.repositories.JpaContext;

public class AppTest {
	public static void main(String[] args) {
		// DaoClient daoClient=JpaContext.getDaoClient();
		DaoProduit daoProduit = JpaContext.getDaoProduit();
		DaoPersonne daoPersonne = JpaContext.getDaoPersonne();
		Produit p1 = new Produit();
		p1.setNom("tele");
		p1.setPrix(500);

		daoProduit.insert(p1);

		p1.setDescription("lkjlkkljlkjlk lkj lkjlk jj");
		daoProduit.update(p1);

		System.out.println(daoProduit.findAll());

		Client olivier = new Client("gozlan", new Adresse("11", "rue aaa", "11111", "paris"), "olivier");

		daoPersonne.insert(olivier);

		Personne clientEnBase = daoPersonne.findByKey(olivier.getId());

		System.out.println(clientEnBase.getAdresse().getRue());

		Fournisseur f=new Fournisseur("amazon", null, "amazon");
		daoPersonne.insert(f);

		// en dernier
		JpaContext.destroy();

	}

	private static void exempleEnVracAvantModeleDao() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eshop");
		System.out.println(emf);

		Produit p1 = new Produit();
		p1.setId(1L);
		p1.setNom("tele");
		p1.setPrix(500);

		EntityManager em = emf.createEntityManager();
		// pour insert,update ou delete=>obligation de gerer un transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(p1);
		tx.commit();
		em.close();

		em = emf.createEntityManager();
		Produit produitEnBase = em.find(Produit.class, 1L);
		System.out.println(produitEnBase);
		em.close();

		produitEnBase.setDescription("une tele 4K HD qui tue");
		System.out.println("--------merge---------");
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		produitEnBase = em.merge(produitEnBase);
		produitEnBase.setPrix(10000);
		tx.commit();
		em.close();

		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(produitEnBase));
		tx.commit();
		em.close();

		emf.close();
		System.out.println("----------un autre entityManagerFactory-----------------");
		emf = Persistence.createEntityManagerFactory("eshop");
		emf.close();
	}
}
