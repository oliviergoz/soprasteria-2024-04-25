package soprasteria.formation.eshop;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import soprasteria.formation.eshop.entities.Adresse;
import soprasteria.formation.eshop.entities.Fournisseur;
import soprasteria.formation.eshop.exceptions.FournisseurException;
import soprasteria.formation.eshop.services.FournisseurService;

@SpringBootTest
class FournisseurTest {

	@Autowired
	private FournisseurService fournisseurSrv;

	@Test
	@Disabled
	void insertTest() {
		fournisseurSrv.create(new Fournisseur("frs1",
				new Adresse("frs1 numero", "frs1 rue", "frs1 codePostal", "frs1 ville"), "frs1"));
	}

	@Test
	void validationFournisseurTest() {
		assertThrows(FournisseurException.class, () -> {
			fournisseurSrv.create(new Fournisseur(null, null, null));
		});
	}

}
