package cinema.entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Acteur")
public class Acteur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "acteur_id")
	private Integer id;
	@Column(name = "acteur_nom")
	private String nom;
	@Column(name = "acteur_prenom")
	private String prenom;
	@Column(name = "acteur_nationalite")
	private String nationalite;
	@ManyToMany(mappedBy = "acteurs")
	private Set<Film> films;

	public Acteur() {
	}

	public Acteur(Integer id, String nom, String prenom, String nationalite) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.nationalite = nationalite;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public Set<Film> getFilms() {
		return films;
	}

	public void setFilms(Set<Film> films) {
		this.films = films;
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
		Acteur other = (Acteur) obj;
		return Objects.equals(id, other.id);
	}

}
