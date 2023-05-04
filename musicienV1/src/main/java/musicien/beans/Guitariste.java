package musicien.beans;

public class Guitariste implements Musicien{
	
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
	}

}
