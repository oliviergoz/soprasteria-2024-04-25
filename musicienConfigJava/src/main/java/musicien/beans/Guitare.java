package musicien.beans;

import org.springframework.stereotype.Component;

@Component("guitare")
public class Guitare implements Instrument {

	@Override
	public void jouer() {
		System.out.println("je suis une guitare");
	}

}
