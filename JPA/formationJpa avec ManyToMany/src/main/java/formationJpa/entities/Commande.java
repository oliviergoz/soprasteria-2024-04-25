package formationJpa.entities;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "purchase")
public class Commande {
	@Id
	@Column(name = "purchase_number")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numero;
	@Column(name = "purchase_date")
	private LocalDate date;
	@ManyToOne
	@JoinColumn(name = "purchase_customer_id", foreignKey = @ForeignKey(name = "purchase_customer_id_fk"))
	private Client client;
	@ManyToMany
	@JoinTable(
			name="purchase_product",
			joinColumns = @JoinColumn(name="purchase_product_purchase_number",foreignKey = @ForeignKey(name="purchase_product_purchase_number_fk")),
			inverseJoinColumns = @JoinColumn(name="purchase_product_product_id",foreignKey = @ForeignKey(name="purchase_product_product_id_fk")))	
	private Set<Produit> produitsCommandes;

	public Commande() {

	}

	public Commande(Client client) {
		this.date = LocalDate.now();
		this.client = client;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<Produit> getProduitsCommandes() {
		return produitsCommandes;
	}

	public void setProduitsCommandes(Set<Produit> produitsCommandes) {
		this.produitsCommandes = produitsCommandes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commande other = (Commande) obj;
		return Objects.equals(numero, other.numero);
	}

}
