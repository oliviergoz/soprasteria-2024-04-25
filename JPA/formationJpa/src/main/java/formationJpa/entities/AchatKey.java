package formationJpa.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class AchatKey implements Serializable{
	@ManyToOne
	@JoinColumn(name="purchase_shipping_id",foreignKey = @ForeignKey(name="purchase_shipping_id_FK"))
	private Commande commande;
	@ManyToOne
	@JoinColumn(name="purchase_product_id",foreignKey = @ForeignKey(name="purchase_product_id_FK"))
	private Produit produit;

	public AchatKey() {

	}

	public AchatKey(Commande commande, Produit produit) {
		super();
		this.commande = commande;
		this.produit = produit;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(commande, produit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AchatKey other = (AchatKey) obj;
		return Objects.equals(commande, other.commande) && Objects.equals(produit, other.produit);
	}
	
	

}
