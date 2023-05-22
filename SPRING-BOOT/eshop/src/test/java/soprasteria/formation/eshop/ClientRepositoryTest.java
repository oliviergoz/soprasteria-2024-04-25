package soprasteria.formation.eshop;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import soprasteria.formation.eshop.entities.Client;
import soprasteria.formation.eshop.repositories.ClientRepository;

@SpringBootTest
class ClientRepositoryTest {

	@Autowired
	ClientRepository clientRepo;


	@Test
	void test() {
		Client client = new Client("aaa", null, "zzz");

		clientRepo.save(client);
		assertNotNull(client.getId());
		
		Optional<Client> opt= clientRepo.findById(client.getId());
		if(opt.isPresent()) {
			assertTrue( opt.get() instanceof Client);
		}
	}

}
