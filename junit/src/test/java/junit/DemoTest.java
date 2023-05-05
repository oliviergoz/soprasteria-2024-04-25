package junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class DemoTest {

	@Test
	void autreMethodeTest() {
		assertTrue(true);
	}

	@Test
	@Disabled
	void test() {
		assertEquals(5, 3 + 2);
		assertNotEquals(6, 3 + 2);
	}
	
	@Test
	void ExceptionTest() {
		assertThrows(NullPointerException.class, ()->{
			List<String> list=null;
			//list=new ArrayList<>();
			list.add("hello");
		});
		
	}

}
