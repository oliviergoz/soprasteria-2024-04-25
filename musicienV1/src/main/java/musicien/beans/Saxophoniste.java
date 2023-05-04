package musicien.beans;

public class Saxophoniste implements Musicien {
	private Saxophone instrument;

	public Saxophone getInstrument() {
		return instrument;
	}

	public void setInstrument(Saxophone instrument) {
		this.instrument = instrument;
	}

	@Override
	public void performer() {
		System.out.println("le saxophoniste joue de son de instrument");
		instrument.jouer();
	}

}
