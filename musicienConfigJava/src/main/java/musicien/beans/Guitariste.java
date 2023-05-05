package musicien.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import musicien.exceptions.FausseNoteException;

@Component("guitariste")
public class Guitariste implements Musicien {

	@Autowired
	@Qualifier("guitare")
	private Instrument instrument;

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	@Override
	public void performer() {
		System.out.println("le guitariste joue de son de instrument");
		instrument.jouer();
		throw new FausseNoteException();
	}

}
