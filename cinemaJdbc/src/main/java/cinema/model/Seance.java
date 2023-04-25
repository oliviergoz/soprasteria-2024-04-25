package cinema.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Seance {
	
	private Integer id;
	private LocalDate dateSeance;
	private LocalTime horaire;
	private double prix;
	private Film film;
	private Salle salle;
	private Langue langue;
	
	
	
	
	public Seance(Integer id, LocalDate dateSeance, LocalTime horaire, double prix, Film film, Salle salle, Langue langue) {
		this.id = id;
		this.dateSeance = dateSeance;
		this.horaire = horaire;
		this.prix = prix;
		this.film = film;
		this.salle = salle;
		this.langue = langue;
	}
	
	public Seance(LocalDate dateSeance, LocalTime horaire, double prix, Film film, Salle salle, Langue langue) {
		
		this.dateSeance = dateSeance;
		this.horaire = horaire;
		this.prix = prix;
		this.film = film;
		this.salle = salle;
		this.langue = langue;
	}



	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public LocalDate getDateSeance() {
		return dateSeance;
	}


	public void setDateSeance(LocalDate dateSeance) {
		this.dateSeance = dateSeance;
	}


	public LocalTime getHoraire() {
		return horaire;
	}


	public void setHoraire(LocalTime horaire) {
		this.horaire = horaire;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public Film getFilm() {
		return film;
	}


	public void setFilm(Film film) {
		this.film = film;
	}


	public Salle getSalle() {
		return salle;
	}


	public void setSalle(Salle salle) {
		this.salle = salle;
	}


	public Langue getLangue() {
		return langue;
	}


	public void setLangue(Langue langue) {
		this.langue = langue;
	}


	@Override
	public String toString() {
		return "Seance [id=" + id + ", dateSeance=" + dateSeance + ", horaire=" + horaire + ", prix=" + prix + ", film="
				+ film + ", salle=" + salle + ", langue=" + langue + "]";
	}


	

}
