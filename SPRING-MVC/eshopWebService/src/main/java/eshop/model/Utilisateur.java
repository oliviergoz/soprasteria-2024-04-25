package eshop.model;

public class Utilisateur {
	private String prenom;
	private String nom;
	private Categorie categorie;

	public Utilisateur() {

	}

	public Utilisateur(String prenom, String nom) {
		this.prenom = prenom;
		this.nom = nom;
	}

	public Utilisateur(String prenom, String nom, Categorie categorie) {
		this.prenom = prenom;
		this.nom = nom;
		this.categorie = categorie;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

}
