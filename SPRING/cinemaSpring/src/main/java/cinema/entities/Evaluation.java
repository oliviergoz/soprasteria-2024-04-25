package cinema.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "evaluation")
public class Evaluation {
	@EmbeddedId
	private EvaluationKey id;
	private double note;
	@Lob
	@Column(name = "evalution_commentaire", columnDefinition = "TEXT")
	private String commentaire;

	public Evaluation() {

	}

	public Evaluation(EvaluationKey id, int note, String commentaire) {
		super();
		this.id = id;
		this.note = note;
		this.commentaire = commentaire;
	}

	public EvaluationKey getId() {
		return id;
	}

	public void setId(EvaluationKey id) {
		this.id = id;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
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
		Evaluation other = (Evaluation) obj;
		return Objects.equals(id, other.id);
	}

}
