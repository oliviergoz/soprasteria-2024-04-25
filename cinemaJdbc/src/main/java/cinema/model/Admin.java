package cinema.model;

public class Admin extends Compte{

	public Admin(Integer id, String login, String password,String email) {
		super(id, login, password,email);
	}
	
	public Admin(String login, String password,String email) {
		super(login, password,email);
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", login=" + login + ", password=" + password + ", email="+email+"]";
	}
	
	
	
}
