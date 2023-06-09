package formationJpa;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import formationJpa.entities.Achat;
import formationJpa.entities.AchatKey;
import formationJpa.entities.Client;
import formationJpa.entities.Commande;
import formationJpa.entities.Fournisseur;
import formationJpa.entities.Produit;
import formationJpa.repositories.DaoAchat;
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
		DaoCommande daoCommande = JpaContext.getDaoCommande();
		DaoAchat daoAchat = JpaContext.getDaoAchat();
		System.out.println(daoClient.count());

		Fournisseur frs = new Fournisseur("amazon", null, "amazon");
		daoFournisseur.insert(frs);

		Produit p1 = new Produit();
		p1.setNom("tele");
		p1.setPrix(500);

		frs = new Fournisseur();
		frs.setId(1L);

		p1.setFournisseur(frs);

		daoProduit.insert(p1);

		Produit pc = new Produit("pc", null, 500, frs);
		daoProduit.insert(pc);

		Client client = new Client("toto", null, "toto");
		daoClient.insert(client);

		Commande commande = new Commande(client);
		commande.setDate(LocalDate.of(2022, 1, 1));
		daoCommande.insert(commande);

		Achat achat1 = new Achat(new AchatKey(commande, pc), 2);
		daoAchat.insert(achat1);
		daoAchat.insert(new Achat(new AchatKey(commande, p1), 5));

		commande = new Commande(client);
		Set<Achat> achats = Set.of(new Achat(new AchatKey(commande, pc), 2), new Achat(new AchatKey(commande, p1), 5));
		commande.setAchats(achats);
		daoCommande.insert(commande);
		commande.getAchats().forEach(achat -> {
			daoAchat.insert(achat);
		});

		commande = new Commande(client);
		achats = Set.of(new Achat(new AchatKey(commande, pc), 2), new Achat(new AchatKey(commande, p1), 5));
		commande.setAchats(achats);
		daoCommande.insert(commande);
		commande.getAchats().forEach(achat -> {
			daoAchat.insert(achat);
		});

		deleteClientById(1L);
		// en dernier
		JpaContext.destroy();

	}

	private static void deleteClientById(Long id) {
		Client client = JpaContext.getDaoClient().findByKeyFetchCommandes(id);
		// daoCommande.setClientToNullByClient(client);
//		client.getCommandes().forEach(c -> {
//			JpaContext.getDaoAchat().deleteByCommande(c);
//		});

		client.getCommandes().forEach(JpaContext.getDaoAchat()::deleteByCommande);

		JpaContext.getDaoCommande().deleteByClient(client);
		client.setCommandes(null);
		JpaContext.getDaoClient().delete(client);
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
