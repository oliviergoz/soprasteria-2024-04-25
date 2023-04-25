package cinema.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cinema.context.Singleton;
import cinema.model.Salle;

public class DAOSalle implements IDAO<Salle,Integer>{

	@Override
	public Salle findById(Integer id) {
		Salle salle=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("SELECT * from salle where id=?");
			ps.setInt(1, id);
			ResultSet rs  = ps.executeQuery();

			while(rs.next()) 
			{
				salle = new Salle(rs.getInt("id"),rs.getString("nom"),rs.getInt("places"));
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return salle;
	}

	@Override
	public List<Salle> findAll() {
		List<Salle> salles=new ArrayList();
		Salle salle=null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("SELECT * from salle");
			ResultSet rs  = ps.executeQuery();

			while(rs.next()) 
			{
				salle = new Salle(rs.getInt("id"),rs.getString("nom"),rs.getInt("places"));
				salles.add(salle);
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}


		return salles;
	}

	@Override
	public void insert(Salle salle) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("insert into salle (nom,places) VALUES (?,?)");
			ps.setString(1, salle.getNom());
			ps.setInt(2, salle.getPlaces());
			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Salle salle) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("update salle set nom=?,places=? where id=?");
			ps.setString(1, salle.getNom());
			ps.setInt(2, salle.getPlaces());
			ps.setInt(3, salle.getId());
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

			PreparedStatement ps  = conn.prepareStatement("DELETE from salle where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
