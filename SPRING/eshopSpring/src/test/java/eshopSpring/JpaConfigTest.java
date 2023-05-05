package eshopSpring;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import eshop.configurations.JpaConfig;
import eshop.entities.Client;
import eshop.repositories.DaoClient;

@SpringJUnitConfig(JpaConfig.class)
public class JpaConfigTest {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Autowired
	private DaoClient daoClient;

	@Test
	void dataSourceTest() {
		assertNotNull(dataSource);
		assertNotNull(entityManagerFactory);
		assertNotNull(daoClient);
		
		Client client=new Client("aa", null, "aa");
		daoClient.insert(client);
		assertNotNull(client.getId());
	}
}
