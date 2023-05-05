package cinema.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Admin extends Compte {

	public Admin() {
	}

	public Admin(Integer id, String login, String password, String email) {
		super(id, login, password, email);

	}

}
