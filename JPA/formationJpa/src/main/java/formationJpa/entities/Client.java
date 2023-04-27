package formationJpa.entities;

import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="customer")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
	private Long id;
	@Column(name="customer_first_name")
	private String prenom;
	@Column(name="customer_last_name")
	private String nom;
	//@Transient
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "numero",column = @Column(name="customer_number",length = 50)),
		@AttributeOverride(name="rue",column = @Column(name="customer_street")),
		@AttributeOverride(name="codePostal",column = @Column(name="customer_zip_code",length = 50)),
		@AttributeOverride(name="ville",column = @Column(name="customer_city"))
	})
	private Adresse adresse;
	
	public Client() {
		
	}
	
	

	public Client(String prenom, String nom, Adresse adresse) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.adresse = adresse;
	}



	public Client(String prenom, String nom) {
		super();
		this.prenom = prenom;
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
