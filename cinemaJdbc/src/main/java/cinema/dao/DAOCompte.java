package cinema.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import cinema.context.Singleton;
import cinema.model.Admin;
import cinema.model.Adresse;
import cinema.model.Client;
import cinema.model.Compte;

public class DAOCompte  implements IDAO<Compte,Integer>{

	@Override
	public Compte findById(Integer id) {

		Compte compte=null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());
			//conn.setAutoCommit(true);
			PreparedStatement ps  = conn.prepareStatement("SELECT * from compte where id=?");
			ps.setInt(1, id);
			ResultSet rs  = ps.executeQuery();

			while(rs.next()) 
			{
				if(rs.getString("type_compte").equals("Admin"))
				{
					compte = new Admin(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("email"));
				}
				else if(rs.getString("type_compte").equals("Client")) 
				{
					Adresse adresse = new Adresse(rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"));
					compte = new Client(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("email"),rs.getString("nom"),rs.getString("prenom"),rs.getString("telephone"),LocalDate.parse(rs.getString("naissance")),adresse);
				}
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return compte;
	}

	@Override
	public List<Compte> findAll() {
		List<Compte> comptes=new ArrayList();

		Compte compte=null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("SELECT * from compte");
			ResultSet rs  = ps.executeQuery();

			while(rs.next()) 
			{
				if(rs.getString("type_compte").equals("Admin"))
				{
					compte = new Admin(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("email"));
				}
				else if(rs.getString("type_compte").equals("Client")) 
				{
					Adresse adresse = new Adresse(rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"));
					compte = new Client(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("email"),rs.getString("nom"),rs.getString("prenom"),rs.getString("telephone"),LocalDate.parse(rs.getString("naissance")),adresse);
				}
				comptes.add(compte);
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return comptes;
	}

	@Override
	public void insert(Compte compte) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("INSERT INTO compte (login,password,email,nom,prenom,telephone,naissance,numero,voie,ville,cp,type_compte) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");

			ps.setString(1, compte.getLogin());
			ps.setString(2, compte.getPassword());
			ps.setString(3, compte.getEmail());

			if(compte instanceof Admin) 
			{
				ps.setString(4,null);
				ps.setString(5,null);
				ps.setString(6,null);
				ps.setString(7,null);
				ps.setString(8,null);
				ps.setString(9,null);
				ps.setString(10,null);
				ps.setString(11,null);
				ps.setString(12,"Admin");
			}
			else if(compte instanceof Client) 
			{
				Client client = (Client) compte;
				ps.setString(4,client.getNom());
				ps.setString(5,client.getPrenom());
				ps.setString(6,client.getTelephone());
				ps.setString(7,client.getNaissance().toString());
				ps.setString(8,client.getAdresse().getNumero());
				ps.setString(9,client.getAdresse().getVoie());
				ps.setString(10,client.getAdresse().getVille());
				ps.setString(11,client.getAdresse().getCp());
				ps.setString(12,"Client");
			}

			ps.executeUpdate();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Compte compte) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("update compte set login=?,password=?,email=?,nom=?,prenom=?,telephone=?,naissance=?,numero=?,voie=?,ville=?,cp=?,type_compte=? where id=?");

			ps.setString(1, compte.getLogin());
			ps.setString(2, compte.getPassword());
			ps.setString(3, compte.getEmail());

			if(compte instanceof Admin) 
			{
				ps.setString(4,null);
				ps.setString(5,null);
				ps.setString(6,null);
				ps.setString(7,null);
				ps.setString(8,null);
				ps.setString(9,null);
				ps.setString(10,null);
				ps.setString(11,null);
				ps.setString(12,"Admin");
			}
			else if(compte instanceof Client) 
			{
				Client client = (Client) compte;
				ps.setString(4,client.getNom());
				ps.setString(5,client.getPrenom());
				ps.setString(6,client.getTelephone());
				ps.setString(7,client.getNaissance().toString());
				ps.setString(8,client.getAdresse().getNumero());
				ps.setString(9,client.getAdresse().getVoie());
				ps.setString(10,client.getAdresse().getVille());
				ps.setString(11,client.getAdresse().getCp());
				ps.setString(12,"Client");
			}
			ps.setInt(13, compte.getId());

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("DELETE from compte where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public  List<Client> findAllClient() 
	{
		List<Client> comptes=new ArrayList();

		Client compte=null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("SELECT * from compte where type_compte='Client'");
			ResultSet rs  = ps.executeQuery();

			while(rs.next()) 
			{
				Adresse adresse = new Adresse(rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"));
				compte = new Client(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("email"),rs.getString("nom"),rs.getString("prenom"),rs.getString("telephone"),LocalDate.parse(rs.getString("naissance")),adresse);
				
				comptes.add(compte);
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return comptes;
	}



	public  Compte findByLoginAndPassword(String login, String password) {
		Compte compte=null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("SELECT * from compte where login=? and password=?");
			ps.setString(1, login);
			ps.setString(2, password);
			ResultSet rs  = ps.executeQuery();

			while(rs.next()) 
			{
				if(rs.getString("type_compte").equals("Admin"))
				{
					compte = new Admin(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("email"));
				}
				else if(rs.getString("type_compte").equals("Client")) 
				{
					Adresse adresse = new Adresse(rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"));
					compte = new Client(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("email"),rs.getString("nom"),rs.getString("prenom"),rs.getString("telephone"),LocalDate.parse(rs.getString("naissance")),adresse);
				}
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return compte;
	}



}
