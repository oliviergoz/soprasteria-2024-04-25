package soprasteria.formation.springBoot.entities;

import javax.persistence.Entity;

@Entity
public class Admin extends Compte {

	public Admin() {
	}

	public Admin(Integer id, String login, String password, String email) {
		super(id, login, password, email);

	}

}
