package musicienV1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import musicien.beans.Musicien;
import musicien.configurations.AppConfig;

class NeSersARienTest {
	
	static AnnotationConfigApplicationContext ctx;
	
	@BeforeAll
	static void beforeAll() {
		ctx=new AnnotationConfigApplicationContext(AppConfig.class);
	}
	
	@AfterAll
	static void afterAll() {
		ctx.close();
	}
	

	@Test
	void guitaristeOktest() {	
		assertNotNull(ctx.getBean("guitariste",Musicien.class));
	}
	
	@Test
	void saxophonisteOkTest() {
		assertNotNull(ctx.getBean("saxophoniste",Musicien.class));
	}

}
