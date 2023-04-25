package cinema.model;

import java.time.LocalDate;

public class Client extends Compte {
	
	private String nom;
	private String prenom;
	private String telephone;
	private LocalDate naissance;
	private Adresse adresse;
	
	public Client(Integer id, String login, String password, String email, String nom, String prenom, String telephone,
			LocalDate naissance, Adresse adresse) {
		super(id, login, password,email);
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.naissance = naissance;
		this.adresse = adresse;
	}
	
	public Client(String login, String password, String email, String nom, String prenom, String telephone,
			LocalDate naissance, Adresse adresse) {
		super(login, password,email);
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.naissance = naissance;
		this.adresse = adresse;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public LocalDate getNaissance() {
		return naissance;
	}


	public void setNaissance(LocalDate naissance) {
		this.naissance = naissance;
	}
	
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	@Override
	public String toString() {
		return "Client [id=" + id + ", login=" + login + ", password=" + password + ", email=" + email + ", nom=" + nom
				+ ", prenom=" + prenom + ", telephone=" + telephone + ", naissance=" + naissance + ", adresse="
				+ adresse + "]";
	}


	
	
	
}
