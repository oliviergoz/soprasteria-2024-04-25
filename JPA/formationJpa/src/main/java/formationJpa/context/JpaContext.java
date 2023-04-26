package formationJpa.context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import formationJpa.repositories.DaoProduit;
import formationJpa.repositories.DaoProduitJpaImpl;

public class JpaContext {

	private static EntityManagerFactory entityManagerFactory=null;
	private static DaoProduit daoProduit=new DaoProduitJpaImpl();
	
	public static DaoProduit getDaoProduit() {
		return daoProduit;
	}
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if(entityManagerFactory==null) {
			entityManagerFactory=Persistence.createEntityManagerFactory("eshop");
		}
		return entityManagerFactory;
	}
	
	public static void destroy() {
		if(entityManagerFactory!=null) {
			entityManagerFactory.close();
			entityManagerFactory=null;
		}
	}
}
