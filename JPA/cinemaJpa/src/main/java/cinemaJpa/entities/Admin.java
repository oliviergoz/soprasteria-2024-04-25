package cinemaJpa.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("A")

public class Admin extends Compte {

	@Column(name="admin_login",nullable=false, length=20)
	private String login;
	@Column(name="admin_password",nullable=false, length=50)
	private String password;
	@Column(name="admin_email",length=50)
	private String email;
	
	public Admin() {
	}

	public Admin( String login, String password, String email) {
		super();
		this.login = login;
		this.password = password;
		this.email = email;
	}


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	
	
	
	
	
	
	
	
	
}
