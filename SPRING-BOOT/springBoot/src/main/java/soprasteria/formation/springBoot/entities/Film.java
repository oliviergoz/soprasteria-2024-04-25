package soprasteria.formation.springBoot.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Film")
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "film_id")
	private Long id;
	@Column(name = "film_titre", nullable = false)
	private String titre;
	@Column(name = "film_categorie", length = 20)
	@Enumerated(EnumType.STRING)
	private Categorie categorie;
	@Column(name = "film_duree")
	private LocalTime duree;
	@Column(name = "film_sortie")
	private LocalDate sortie;
	@Column(name = "film_dispo")
	private boolean disponible;
	@OneToMany(mappedBy = "film")
	private Set<Seance> seances;
	@ManyToMany
	@JoinTable(name = "participation", joinColumns = @JoinColumn(name = "participation_film_id", foreignKey = @ForeignKey(name = "participation_film_id_fk")), inverseJoinColumns = @JoinColumn(name = "participation_acteur_id", foreignKey = @ForeignKey(name = "participation_acteur_id_fk")))
	private Set<Acteur> acteurs;
	@OneToMany(mappedBy = "id.film")
	private Set<Evaluation> evaluations;

	public Film() {

	}

	public Film(String titre, Categorie categorie, LocalTime duree, LocalDate sortie, boolean disponible) {
		super();
		this.titre = titre;
		this.categorie = categorie;
		this.duree = duree;
		this.sortie = sortie;
		this.disponible = disponible;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public LocalTime getDuree() {
		return duree;
	}

	public void setDuree(LocalTime duree) {
		this.duree = duree;
	}

	public LocalDate getSortie() {
		return sortie;
	}

	public void setSortie(LocalDate sortie) {
		this.sortie = sortie;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public Set<Seance> getSeances() {
		return seances;
	}

	public void setSeances(Set<Seance> seances) {
		this.seances = seances;
	}

	public Set<Acteur> getActeurs() {
		return acteurs;
	}

	public void setActeurs(Set<Acteur> acteurs) {
		this.acteurs = acteurs;
	}

	public Set<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(Set<Evaluation> evaluations) {
		this.evaluations = evaluations;
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
		Film other = (Film) obj;
		return Objects.equals(id, other.id);
	}

}
