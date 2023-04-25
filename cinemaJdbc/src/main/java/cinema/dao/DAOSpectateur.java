package cinema.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cinema.context.Singleton;
import cinema.model.Spectateur;
import cinema.model.Statut;

public class DAOSpectateur implements IDAO<Spectateur,Integer> {

	@Override
	public Spectateur findById(Integer id) {
		Spectateur spectateur=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("SELECT * from spectateur where id=?");
			ps.setInt(1, id);
			ResultSet rs  = ps.executeQuery();

			while(rs.next()) 
			{
				spectateur = new Spectateur(rs.getInt("id"), rs.getInt("age"),Statut.valueOf(rs.getString("statut")));
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return spectateur;
	}

	@Override
	public List<Spectateur> findAll() {
		List<Spectateur> spectateurs=new ArrayList();
		Spectateur spectateur=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("SELECT * from spectateur");
			ResultSet rs  = ps.executeQuery();

			while(rs.next()) 
			{
				spectateur = new Spectateur(rs.getInt("id"), rs.getInt("age"),Statut.valueOf(rs.getString("statut")));
				spectateurs.add(spectateur);
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return spectateurs;
	}

	@Override
	public void insert(Spectateur spectateur) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("insert into spectateur (age,statut) VALUES(?,?)",Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1,spectateur.getAge());
			ps.setString(2, spectateur.getStatut().toString());

			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) 
			{
				spectateur.setId(rs.getInt(1));
			}
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Spectateur spectateur) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("update spectateur set age=?,statut=?  where id=?");
			ps.setInt(1,spectateur.getAge());
			ps.setString(2, spectateur.getStatut().toString());
			ps.setInt(3, spectateur.getId());

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

			PreparedStatement ps  = conn.prepareStatement("DELETE from spectateur where id=?");

			ps.setInt(1,id);

			ps.executeUpdate();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void insertTicket(Integer idReservation,Integer idSpectateur) 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("insert into ticket VALUES (?,?)");
			
			ps.setInt(1, idReservation);
			ps.setInt(2, idSpectateur);
			ps.executeUpdate();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Spectateur> findAllByReservation(Integer idReservation) 
	{
		List<Spectateur> spectateurs=new ArrayList();
		Spectateur spectateur=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("SELECT * from spectateur JOIN ticket ON spectateur.id=ticket.spectateur_id where reservation_id=?");
			ps.setInt(1,idReservation);

			ResultSet rs  = ps.executeQuery();

			while(rs.next()) 
			{
				spectateur = new Spectateur(rs.getInt("id"), rs.getInt("age"),Statut.valueOf(rs.getString("statut")));
				spectateurs.add(spectateur);
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return spectateurs;
	}

}
