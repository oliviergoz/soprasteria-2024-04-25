package cinema.model;

public class Salle {
	
	private Integer id;
	private String nom;
	private int places;
	
	
	public Salle(Integer id, String nom, int places) {
		this.id = id;
		this.nom = nom;
		this.places = places;
	}
	
	public Salle(String nom, int places) {
		this.nom = nom;
		this.places = places;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPlaces() {
		return places;
	}

	public void setPlaces(int places) {
		this.places = places;
	}

	@Override
	public String toString() {
		return "Salle [id=" + id + ", nom=" + nom + ", places=" + places + "]";
	}

	
	
}
