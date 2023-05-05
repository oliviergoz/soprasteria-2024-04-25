package cinema.repositories;

import cinema.entities.Acteur;

public interface DaoActeur extends DaoGeneric<Acteur, Long> {
	Acteur findByIdFetchFilms(Long id);
}
