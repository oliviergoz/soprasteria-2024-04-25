package cinemaJpa.repositories;

import cinemaJpa.entities.Acteur;

public interface DaoActeur extends DaoGeneric<Acteur, Long> {
	Acteur findByIdFetchFilms(Long id);
}
