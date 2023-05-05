package cinema.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Salle")
public class Salle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "salle_id")
	private Integer id;
	@Column(name = "salle_nom")
	private String nom;
	@Column(name = "salle_places")
	private int places;

	public Salle() {
	}

	public Salle(Integer id, String nom, int places) {
		this.id = id;
		this.nom = nom;
		this.places = places;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPlaces() {
		return places;
	}

	public void setPlaces(int places) {
		this.places = places;
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
		Salle other = (Salle) obj;
		return Objects.equals(id, other.id);
	}

}
