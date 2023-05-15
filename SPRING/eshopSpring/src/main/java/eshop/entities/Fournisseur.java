package eshop.entities;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "supplier")
@AttributeOverride(name = "id", column = @Column(name = "supplier_id"))
@AttributeOverride(name = "nom", column = @Column(name = "supplier_name",nullable = false))
@AttributeOverride(name = "adresse.numero", column = @Column(name = "supplier_number", length = 50))
@AttributeOverride(name = "adresse.rue", column = @Column(name = "supplier_street"))
@AttributeOverride(name = "adresse.codePostal", column = @Column(name = "supplier_zip_code", length = 50))
@AttributeOverride(name = "adresse.ville", column = @Column(name = "supplier_city"))
public class Fournisseur extends Personne {

	@Column(name = "supplier_contact")
	@NotBlank
	private String contact;
	@OneToMany(mappedBy = "fournisseur")
	private Set<Produit> produits;

	public Fournisseur() {

	}

	public Fournisseur(String nom, Adresse adresse, String contact) {
		super(nom, adresse);
		this.contact = contact;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Set<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}

}
