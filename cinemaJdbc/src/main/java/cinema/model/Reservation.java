package cinema.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reservation {

	private Integer id;
	private double prix;
	private LocalDate dateReservation;
	private List<Spectateur> spectateurs = new ArrayList(); 
	private Client client;
	private Seance seance;
	
	public Reservation(Integer id, double prix, LocalDate dateReservation, Client client, Seance seance) {
		this.id = id;
		this.prix = prix;
		this.dateReservation = dateReservation;
		this.client = client;
		this.seance = seance;
	}
	
	public Reservation(double prix, LocalDate dateReservation, Client client, Seance seance) {
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

	public List<Spectateur> getSpectateurs() {
		return spectateurs;
	}

	public void setSpectateurs(List<Spectateur> spec) {
		this.spectateurs = spec;
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
	public String toString() {
		return "Reservation [id=" + id + ", prix=" + prix + ", dateReservation=" + dateReservation + ", spectateurs=" + spectateurs
				+ ", client=" + client + ", seance=" + seance + "]";
	}
	
	
	
	
	
}
