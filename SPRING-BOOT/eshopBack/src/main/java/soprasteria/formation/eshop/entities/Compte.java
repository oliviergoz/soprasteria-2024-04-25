package soprasteria.formation.eshop.entities;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonView;

import soprasteria.formation.eshop.entities.jsonviews.JsonViews;

@Entity
@Table(name = "account")
public class Compte implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private Long id;
	@Column(name = "account_login", nullable = false, unique = true, length = 200)
	@JsonView(JsonViews.Base.class)
	private String login;
	@Column(name = "account_password", nullable = false, length = 255)
	private String password;
	@Enumerated(EnumType.STRING)
	@Column(name = "account_role")
	@JsonView(JsonViews.Base.class)
	private Role role;
	@OneToOne(mappedBy = "compte")
	@JsonView(JsonViews.CompteWithClient.class)
	private Client client;

	public Compte() {

	}

	public Compte(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public Compte(String login, String password, Role role) {
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public Compte(String login, String password, Role role, Client client) {
		this.login = login;
		this.password = password;
		this.role = role;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority(role.toString()));
	}

	@Override
	public String getUsername() {
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
