package cinema.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;


@MappedSuperclass
public class Compte {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="compte_id")
	private Integer id;
	@Column(name="compte_login",nullable=false, length=20)
	private String login;
	@Column(name="compte_password",nullable=false, length=50)
	private String password;	
	@Column(name="compte_email",length=50)
	private String email;
	public Compte() {
		
	}
	public Compte(Integer id, String login, String password, String email) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.email = email;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
		Compte other = (Compte) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
