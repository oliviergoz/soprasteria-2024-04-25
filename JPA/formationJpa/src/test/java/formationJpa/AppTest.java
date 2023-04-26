package formationJpa;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import formationJpa.context.JpaContext;
import formationJpa.entities.Produit;
import formationJpa.repositories.DaoProduit;

public class AppTest {
	public static void main(String[] args) {

		Produit p1=new Produit();
		p1.setId(1L);
		p1.setNom("tele");
		p1.setPrix(500);
		
		DaoProduit daoProduit=JpaContext.getDaoProduit();
		
		daoProduit.insert(p1);
		
		
		p1.setDescription("lkjlkkljlkjlk lkj lkjlk jj");
		daoProduit.update(p1);
		
		System.out.println(daoProduit.findAll());
		
		
		//en dernier
		JpaContext.destroy();
		
	}
	
	private static void exempleEnVracAvantModeleDao() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eshop");
		System.out.println(emf);
		
		Produit p1=new Produit();
		p1.setId(1L);
		p1.setNom("tele");
		p1.setPrix(500);
		
		
		EntityManager em=emf.createEntityManager();
		//pour insert,update ou delete=>obligation de gerer un transaction
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.persist(p1);
		tx.commit();
		em.close();
		
		
		em=emf.createEntityManager();
		Produit produitEnBase=em.find(Produit.class, 1L);
		System.out.println(produitEnBase);
		em.close();
		
		produitEnBase.setDescription("une tele 4K HD qui tue");
		System.out.println("--------merge---------");
		em=emf.createEntityManager();
		tx=em.getTransaction();
		tx.begin();
		produitEnBase=em.merge(produitEnBase);
		produitEnBase.setPrix(10000);
		tx.commit();
		em.close();
		
		
		em=emf.createEntityManager();
		tx=em.getTransaction();
		tx.begin();
		em.remove(em.merge(produitEnBase));
		tx.commit();
		em.close();
		
		
		emf.close();
		System.out.println("----------un autre entityManagerFactory-----------------");
		emf= Persistence.createEntityManagerFactory("eshop");
		emf.close();
	}
}
