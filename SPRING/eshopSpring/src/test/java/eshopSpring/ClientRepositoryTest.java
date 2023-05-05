package eshopSpring;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import eshop.configurations.JpaConfig;
import eshop.entities.Client;
import eshop.repositories.ClientRepository;

@SpringJUnitConfig(JpaConfig.class)
class ClientRepositoryTest {

	@Autowired
	ClientRepository clientRepo;

	@Test
	void test() {
		Client client = new Client("zzz", null, "zzz");

		clientRepo.save(client);
		assertNotNull(client.getId());
		
		Optional<Client> opt= clientRepo.findById(client.getId());
		if(opt.isPresent()) {
			assertTrue( opt.get() instanceof Client);
		}
	}

}
