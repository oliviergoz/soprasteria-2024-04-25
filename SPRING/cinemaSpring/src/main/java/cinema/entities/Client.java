package cinema.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Client extends Compte {

	private String nom;
	private String prenom;
	private String telephone;
	private LocalDate naissance;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "numero", column = @Column(name = "person_number", length = 50)),
			@AttributeOverride(name = "rue", column = @Column(name = "person_street")),
			@AttributeOverride(name = "codePostal", column = @Column(name = "person_zip_code", length = 50)),
			@AttributeOverride(name = "ville", column = @Column(name = "person_city")) })
	private Adresse adresse;
	@OneToMany(mappedBy = "id.client")
	private Set<Evaluation> evaluations;
	@OneToMany(mappedBy = "client")
	private Set<Reservation> reservations;

	public Client() {

	}

	public Client(String nom, String prenom, String telephone, LocalDate naissance, Adresse adresse) {
		super();
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

	public Set<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(Set<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

}
