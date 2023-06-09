package cinema.model;

public abstract class Compte {
	protected Integer id;
	protected String login;
	protected String password;	
	protected String email;
	
	public Compte(Integer id, String login, String password,String email) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.email=email;
	}
	public Compte(String login, String password,String email) {
		this.login = login;
		this.password = password;
		this.email=email;
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
		
	
}
