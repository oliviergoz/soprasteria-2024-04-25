package formationJpa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import formationJpa.entities.Adresse;
import formationJpa.entities.Client;
import formationJpa.entities.Commande;
import formationJpa.entities.Fournisseur;
import formationJpa.entities.Produit;
import formationJpa.repositories.DaoClient;
import formationJpa.repositories.DaoCommande;
import formationJpa.repositories.DaoFournisseur;
import formationJpa.repositories.DaoProduit;
import formationJpa.repositories.JpaContext;

public class AppTest {
	public static void main(String[] args) {
		DaoClient daoClient = JpaContext.getDaoClient();
		DaoProduit daoProduit = JpaContext.getDaoProduit();
		DaoFournisseur daoFournisseur = JpaContext.getDaoFournisseur();
		DaoCommande daoCommande=JpaContext.getDaoCommande();
		
		Fournisseur frs=new Fournisseur("amazon", null, "amazon");
		
		Produit p1 = new Produit();
		p1.setNom("tele");
		p1.setPrix(500);
		
		daoFournisseur.insert(frs);

		daoProduit.insert(p1);
		p1.setFournisseur(frs);
		daoProduit.update(p1);
		
		
		Produit pc=new Produit("pc", null, 500, frs);
		daoProduit.insert(pc);
		
		
		Client client=new Client("toto", null, "toto");
		daoClient.insert(client);
		
		Commande commande=new Commande(client);
		Set<Produit> produits=new HashSet<>();
		produits.add(pc);
		produits.add(p1);
		commande.setProduitsCommandes(produits);
		daoCommande.insert(commande);
		
		commande=daoCommande.findByKey(1L);
		
		
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
