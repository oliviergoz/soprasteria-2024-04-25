package cinema.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Reservation")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reservation_id")
	private Integer id;
	@Column(name = "reservation_prix")
	private double prix;
	@Column(name = "reservation_date")
	private LocalDate dateReservation;
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	@ManyToOne
	@JoinColumn(name = "seance_id")
	private Seance seance;

	public Reservation() {

	}

	public Reservation(Integer id, double prix, LocalDate dateReservation, Client client, Seance seance) {
		this.id = id;
		this.prix = prix;
		this.dateReservation = dateReservation;
		this.client = client;
		this.seance = seance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public LocalDate getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(LocalDate dateReservation) {
		this.dateReservation = dateReservation;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Seance getSeance() {
		return seance;
	}

	public void setSeance(Seance seance) {
		this.seance = seance;
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
		Reservation other = (Reservation) obj;
		return Objects.equals(id, other.id);
	}

}
