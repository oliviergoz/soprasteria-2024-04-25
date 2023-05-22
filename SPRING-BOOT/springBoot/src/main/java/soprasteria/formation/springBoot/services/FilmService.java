package soprasteria.formation.springBoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soprasteria.formation.springBoot.entities.Film;
import soprasteria.formation.springBoot.repositories.FilmRepository;

@Service
public class FilmService {
	@Autowired
	private FilmRepository filmRepo;
	
	public List<Film> getAll(){
		return filmRepo.findAll();
	}
}
