package formation.model;

public class Utilisateur {

	private String prenom;
	private String nom;
	private String login;

	public Utilisateur() {

	}

	public Utilisateur(String prenom, String nom, String login) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.login = login;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getInfos() {
		return prenom+" "+nom+" "+login;
	}
}
