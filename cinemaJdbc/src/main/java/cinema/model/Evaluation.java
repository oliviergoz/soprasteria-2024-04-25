package cinema.model;

public class Evaluation {
	private Integer id;
	private int note;
	private String commentaire;
	private Film film;
	private Client client;
	
	public Evaluation(Integer id, int note, String commentaire, Film film, Client client) {
		this.id = id;
		this.note = note;
		this.commentaire = commentaire;
		this.film = film;
		this.client = client;
	}

	
	public Evaluation(int note, String commentaire, Film film, Client client) {
		this.note = note;
		this.commentaire = commentaire;
		this.film = film;
		this.client = client;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String com) {
		this.commentaire = com;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Evaluation [id=" + id + ", note=" + note + ", commentaire=" + commentaire + ", film=" + film + ", client=" + client
				+ "]";
	}
	
	
	

}
