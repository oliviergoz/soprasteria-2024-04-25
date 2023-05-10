package eshopSpring;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import eshop.configurations.JpaConfig;
import eshop.entities.Adresse;
import eshop.entities.Fournisseur;
import eshop.services.FournisseurService;

@SpringJUnitConfig(JpaConfig.class)
class FournisseurTest {

	@Autowired
	private FournisseurService fournisseurSrv;

	@Test
	@Disabled
	void insertTest() {
		fournisseurSrv.create(new Fournisseur("frs1",
				new Adresse("frs1 numero", "frs1 rue", "frs1 codePostal", "frs1 ville"), "frs1"));
	}

}
