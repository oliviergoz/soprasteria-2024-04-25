package musicien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import musicien.beans.Musicien;

public class AppSpring {

	@Autowired
	@Qualifier("guitariste")
	private Musicien guitariste;
	
	public void run(String ...args) {
		guitariste.performer();
	}
}
