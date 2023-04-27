package cinemaJpa;

import java.time.LocalDate;
import java.time.LocalTime;

import cinemaJpa.entities.Categorie;
import cinemaJpa.entities.Film;
import cinemaJpa.repositories.DaoFilm;
import cinemaJpa.repositories.JpaContext;

public class AppTest {
	public static void main(String[] args) {
		DaoFilm daoFilm=JpaContext.getDaoFilm();
		
		Film film=new Film("titre", Categorie.Action, LocalTime.of(1, 30), LocalDate.now(), false);
		System.out.println(film.getId());
		daoFilm.insert(film);
		System.out.println(film.getId());
		
		
		JpaContext.destroy();
	}
}
