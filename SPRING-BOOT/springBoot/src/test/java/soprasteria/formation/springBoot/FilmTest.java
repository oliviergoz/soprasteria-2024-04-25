package soprasteria.formation.springBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import soprasteria.formation.springBoot.repositories.FilmRepository;
import soprasteria.formation.springBoot.services.FilmService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

@SpringBootTest
public class FilmTest {

	@Autowired
	FilmService filmSrv;

	@Test
	void filmRepositoryInjectionTest() {
		assertNotNull(filmSrv);
		assertNotNull(filmSrv.getAll());
	}
}
