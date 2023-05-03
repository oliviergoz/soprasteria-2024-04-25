package cinemaJpa.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Entity
@Table(name = "Seance")
public class Seance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seance_id")
	private Integer id;
	@Column(name = "seance_date")
	private LocalDate dateSeance;
	@Column(name = "seance_horaire")
	private LocalTime horaire;
	@Column(name = "seance_prix")
	private double prix;
	@ManyToOne
	@JoinColumn(name = "seance_film_id")
	private Film film;
	@ManyToOne
	@JoinColumn(name = "seance_salle_id", foreignKey = @ForeignKey(name = "seance_salle_id_fk"))
	private Salle salle;
	@Column(name = "seance_langue")
	private Langue langue;

	public Seance() {
	}

	public Seance(Integer id, LocalDate dateSeance, LocalTime horaire, double prix, Film film, Salle salle,
			Langue langue) {
		this.id = id;
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
		Seance other = (Seance) obj;
		return Objects.equals(id, other.id);
	}

}
