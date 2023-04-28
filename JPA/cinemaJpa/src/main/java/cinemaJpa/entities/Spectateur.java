package cinemaJpa.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Spectateur")
public class Spectateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "spect_id")
	private Integer id;
	@Column(name = "spect_age")
	private int age;
	@Column(name = "spect_statut")
	private Statut statut;

	public Spectateur() {
	}

	public Spectateur(Integer id, int age, Statut statut) {
		this.id = id;
		this.age = age;
		this.statut = statut;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
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
		Spectateur other = (Spectateur) obj;
		return Objects.equals(id, other.id);
	}

}
