package soprasteria.formation.eshop.entities;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

import soprasteria.formation.eshop.entities.jsonviews.JsonViews;

@Entity
@Table(name = "customer")
@AttributeOverride(name = "id", column = @Column(name = "customer_id"))
@AttributeOverride(name = "nom", column = @Column(name = "customer_last_name", nullable = false))
@AttributeOverride(name = "adresse.numero", column = @Column(name = "customer_number", length = 50))
@AttributeOverride(name = "adresse.rue", column = @Column(name = "customer_street"))
@AttributeOverride(name = "adresse.codePostal", column = @Column(name = "customer_zip_code", length = 50))
@AttributeOverride(name = "adresse.ville", column = @Column(name = "customer_city"))
public class Client extends Personne {
	@Column(name = "customer_first_name")
	@NotBlank
	@JsonView(JsonViews.Base.class)
	private String prenom;
	@OneToMany(mappedBy = "client")
	@JsonView(JsonViews.ClientWithCommandes.class)
	private Set<Commande> commandes;
	@OneToOne
	@JoinColumn(name = "customer_account_id", foreignKey = @ForeignKey(name = "customer_account_id_fk"))
	@NotNull
	private Compte compte;

	public Client() {

	}

	public Client(String nom, Adresse adresse, String prenom) {
		super(nom, adresse);
		this.prenom = prenom;
	}

	public Client(String nom, Adresse adresse, @NotBlank String prenom, @NotBlank Compte compte) {
		super(nom, adresse);
		this.prenom = prenom;
		this.compte = compte;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Set<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

}
