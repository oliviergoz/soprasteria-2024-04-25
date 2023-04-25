package cinema.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Film {
	
	private Integer id;
	private String nom;
	private LocalDate sortie;
	private LocalTime duree;
	private boolean disponible;
	private Categorie categorie;
	private List<Acteur> acteurs = new ArrayList();
	
	public Film(Integer id, String nom, LocalDate sortie, LocalTime duree, boolean disponible, Categorie categorie) {
		this.id = id;
		this.nom = nom;
		this.sortie = sortie;
		this.duree = duree;
		this.disponible = disponible;
		this.categorie = categorie;
	}
	public Film(String nom, LocalDate sortie, LocalTime duree, boolean disponible, Categorie categorie) {
		this.nom = nom;
		this.sortie = sortie;
		this.duree = duree;
		this.disponible = disponible;
		this.categorie = categorie;
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

	public LocalDate getSortie() {
		return sortie;
	}

	public void setSortie(LocalDate sortie) {
		this.sortie = sortie;
	}

	public LocalTime getDuree() {
		return duree;
	}

	public void setDuree(LocalTime duree) {
		this.duree = duree;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<Acteur> getActeurs() {
		return acteurs;
	}

	public void setActeurs(List<Acteur> acteurs) {
		this.acteurs = acteurs;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", nom=" + nom + ", sortie=" + sortie + ", duree=" + duree + ", disponible="
				+ disponible + ", categorie=" + categorie + ", acteurs=" + acteurs + "]";
	}
	
	
	
	
}
