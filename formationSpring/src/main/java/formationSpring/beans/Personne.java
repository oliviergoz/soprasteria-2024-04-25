package formationSpring.beans;

public class Personne implements SePresenter {
	private String nom;
	private Adresse adresse;

	public Personne() {

	}

	public void bonjour() {
		System.out.println("hello world");
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}
