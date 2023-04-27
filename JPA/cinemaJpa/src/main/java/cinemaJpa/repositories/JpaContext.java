package cinemaJpa.repositories;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaContext {
	private static EntityManagerFactory emf=null;
	private static DaoFilm daoFilm=new DaoFilmImpl();
	
	public static DaoFilm getDaoFilm() {
		return daoFilm;
	}
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if(emf==null) {
			emf=Persistence.createEntityManagerFactory("cinema");
		}
		return emf;
	}
	
	public static void destroy() {
		if(emf!=null) {
			emf.close();
			emf=null;
		}
	}
}
