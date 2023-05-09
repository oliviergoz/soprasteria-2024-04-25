package eshopSpring;

import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import eshop.configurations.JpaConfig;
import eshop.entities.Produit;
import eshop.exceptions.ProduitException;
import eshop.services.ProduitService;

@SpringJUnitConfig(JpaConfig.class)
@Transactional
@Rollback
class ProduitServiceTest {

	@Autowired
	private ProduitService produitSrv;

	@Test
	void getByIdExceptionTest() {
		assertThrows(ProduitException.class, () -> {
			produitSrv.getById(9999999L);
		});
	}

	@Disabled
	@Test
	// @Commit
	void createProduitTest() {
		assertThrows(ProduitException.class, () -> {
			produitSrv.create(new Produit(null, null, 0.1, null));
		});
		assertThrows(ProduitException.class, () -> {
			produitSrv.create(new Produit("aaa", null, 0, null));
		});
		assertNotNull(produitSrv.getById(produitSrv.create(new Produit("testtttt", "testttttt", 1, null)).getId()));
	}

}
