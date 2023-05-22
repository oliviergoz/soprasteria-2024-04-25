package soprasteria.formation.springBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import soprasteria.formation.springBoot.entities.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {

}
