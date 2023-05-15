package eshop.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

@Entity // associe la class Produit à une table
@Table(name = "product")
public class Produit {
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name", nullable = false)
	@NotBlank
	private String nom;
	@Column(name = "description",columnDefinition = "TEXT")
	@Lob
	private String description;
	@Column(name = "price")
	@DecimalMin(value = "0.01",message="*prix minimum:0.01")
	private double prix;
	@ManyToOne
	@JoinColumn(name="product_supplier_id",foreignKey = @ForeignKey(name="product_supplier_id_fk"))
	private Fournisseur fournisseur;

	public Produit() {

	}

	public Produit(String nom, String description, double prix, Fournisseur fournisseur) {
		super();
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.fournisseur = fournisseur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
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
		Produit other = (Produit) obj;
		return Objects.equals(id, other.id);
	}

}
