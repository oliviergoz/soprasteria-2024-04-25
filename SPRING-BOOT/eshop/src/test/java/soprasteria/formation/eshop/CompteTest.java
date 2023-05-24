package soprasteria.formation.eshop;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import soprasteria.formation.eshop.entities.Adresse;
import soprasteria.formation.eshop.entities.Client;
import soprasteria.formation.eshop.entities.Compte;
import soprasteria.formation.eshop.services.ClientService;
import soprasteria.formation.eshop.services.CompteService;

@SpringBootTest
public class CompteTest {

	@Autowired
	ClientService clientSrv;
	@Autowired
	CompteService compteSrv;

	@Test
	@Disabled
	void initCompteTest() {
		compteSrv.createAdmin("admin", "admin");
		clientSrv.create(new Client("nom client", new Adresse("1", "rue xx", "75000", "paris"), "prenom client",
				new Compte("client", "client")));
	}
}
