package cinema.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cinema.context.Singleton;
import cinema.model.Acteur;

public class DAOActeur implements IDAO<Acteur,Integer> {

	@Override
	public Acteur findById(Integer id) {
		Acteur acteur=null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("SELECT * from acteur where id=?");
			ps.setInt(1, id);
			ResultSet rs  = ps.executeQuery();

			while(rs.next()) 
			{
				acteur = new Acteur(rs.getInt("id"),rs.getString("nom"), rs.getString("prenom"), rs.getString("nationalite"));
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return acteur;
	}

	@Override
	public List<Acteur> findAll() {
		List<Acteur> acteurs=new ArrayList();
		Acteur acteur=null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("SELECT * from acteur");
			ResultSet rs  = ps.executeQuery();

			while(rs.next()) 
			{
				acteur = new Acteur(rs.getInt("id"),rs.getString("nom"), rs.getString("prenom"), rs.getString("nationalite"));
				acteurs.add(acteur);
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return acteurs;
	}

	@Override
	public void insert(Acteur acteur) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("insert into acteur (nom,prenom,nationalite) VALUES (?,?,?)");
			ps.setString(1, acteur.getNom());
			ps.setString(2, acteur.getPrenom());
			ps.setString(3, acteur.getNationalite());
			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Acteur acteur) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("Update acteur set nom=?,prenom=?,nationalite=? where id=?");
			ps.setString(1, acteur.getNom());
			ps.setString(2, acteur.getPrenom());
			ps.setString(3, acteur.getNationalite());
			ps.setInt(4, acteur.getId());
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

			PreparedStatement ps  = conn.prepareStatement("delete from acteur where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
