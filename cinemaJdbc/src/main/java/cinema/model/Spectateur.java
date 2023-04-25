package cinema.model;

public class Spectateur {

	private Integer id;
	private int age;
	private Statut statut;
	
	
	public Spectateur(Integer id, int age, Statut statut) {
		this.id = id;
		this.age = age;
		this.statut = statut;
	}
	
	public Spectateur(int age, Statut statut) {
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
	public String toString() {
		return "Spectateur [id=" + id + ", age=" + age + ", statut=" + statut + "]";
	}
	
	
	
	
	
	
}
