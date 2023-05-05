package cinema.repositories;

import java.time.LocalDate;
import java.util.List;

import cinema.entities.Acteur;
import cinema.entities.Film;
import cinema.entities.Langue;

public interface DaoFilm extends DaoGeneric<Film, Long> {

	List<Film> findByDisponible(boolean disponible);

	List<Film> findByAnneeSortie(int annee);

	List<Film> findByActeur(Acteur acteur);

	List<Film> findByEvalutationsNote(int note);

	List<Film> findBySeancesDateSeance(LocalDate dateSeance);

	List<Film> findBySeancesLangue(Langue langue);

	List<Film> findBySeancesDateSeanceAndSeanceLangue(LocalDate dateSeance, Langue langue);

	Film findByIdFetchEvaluations(Long id);

	Film findByIdFetchActeurs(Long id);

	Film findByIdFetchSeances(Long id);

	Film findByIdFetchEvaluationsAndActeursAndSeances(Long id);
	
	List<Film> findTop10();

}
