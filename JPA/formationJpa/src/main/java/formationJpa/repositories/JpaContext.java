package formationJpa.repositories;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaContext {

	private static EntityManagerFactory entityManagerFactory = null;
	private static DaoProduit daoProduit = new DaoProduitJpaImpl();
	private static DaoClient daoClient = new DaoClientJpaImpl();
	private static DaoFournisseur daoFournisseur = new DaoFournisseurJpaImpl();
	private static DaoCommande daoCommande = new DaoCommandeJpaImpl();
	private static DaoAchat daoAchat = new DaoAchatJpaImpl();

	public static DaoAchat getDaoAchat() {
		return daoAchat;
	}

	public static DaoCommande getDaoCommande() {
		return daoCommande;
	}

	public static DaoFournisseur getDaoFournisseur() {
		return daoFournisseur;
	}

	public static DaoClient getDaoClient() {
		return daoClient;
	}

	public static DaoProduit getDaoProduit() {
		return daoProduit;
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("eshop");
		}
		return entityManagerFactory;
	}

	public static void destroy() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
			entityManagerFactory = null;
		}
	}
}
