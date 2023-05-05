package musicienV1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import musicien.beans.Musicien;
import musicien.configurations.AppConfig;

@SpringJUnitConfig(AppConfig.class)
class SpringTest {

	@Autowired
	@Qualifier("guitariste")
	Musicien guitariste;
	
	@Test
	void test() {
		assertNotNull(guitariste);
	}

}
