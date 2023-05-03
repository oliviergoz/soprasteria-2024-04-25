package cinemaJpa;

import cinemaJpa.repositories.JpaContext;

public class AppTest {
	public static void main(String[] args) {

		JpaContext.getEntityManagerFactory();

		JpaContext.getDaoFilm().findTop10();
		JpaContext.destroy();
	}
}
