package formationJpa.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="customer")
@AttributeOverride(name="id",column = @Column(name="customer_id"))
@AttributeOverride(name="nom",column = @Column(name="customer_last_name"))
@AttributeOverride(name="adresse.numero",column = @Column(name="customer_number",length = 50))
@AttributeOverride(name="adresse.rue",column = @Column(name="customer_street"))
@AttributeOverride(name="adresse.codePostal",column = @Column(name="customer_zip_code",length = 50))
@AttributeOverride(name="adresse.ville",column = @Column(name="customer_city"))
public class Client extends Personne {
	@Column(name="customer_first_name")
	private String prenom;

	public Client() {

	}

	public Client(String nom, Adresse adresse, String prenom) {
		super(nom, adresse);
		this.prenom = prenom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
