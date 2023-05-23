package soprasteria.formation.springBoot;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import soprasteria.formation.springBoot.entities.Admin;
import soprasteria.formation.springBoot.entities.Client;
import soprasteria.formation.springBoot.services.CompteService;

@SpringBootTest
public class CompteTest {

	@Autowired
	CompteService compteSrv;


	@Test
	@Disabled
	void creationCompte() {
		compteSrv.createAdmin(new Admin("admin", "admin", "mail admin"));

		compteSrv.createClient(new Client("client","client","mail client","nom client","prenom client","111111",LocalDate.now(),null));
	}
}
