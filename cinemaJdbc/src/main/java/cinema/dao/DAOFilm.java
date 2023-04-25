package cinema.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import cinema.context.Singleton;
import cinema.model.Categorie;
import cinema.model.Film;

public class DAOFilm implements IDAO<Film,Integer> {

	@Override
	public Film findById(Integer id) {
		Film film=null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("SELECT * from film where id=?");
			ps.setInt(1, id);
			ResultSet rs  = ps.executeQuery();

			while(rs.next()) 
			{
				film = new Film(rs.getInt("id"),rs.getString("nom"),LocalDate.parse(rs.getString("sortie")),LocalTime.parse(rs.getString("duree")),rs.getBoolean("disponible"),Categorie.valueOf(rs.getString("categorie")));
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return film;
	}

	@Override
	public List<Film> findAll() {
		List<Film> films=new ArrayList();
		Film film=null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("SELECT * from film");
			ResultSet rs  = ps.executeQuery();

			while(rs.next()) 
			{
				film = new Film(rs.getInt("id"),rs.getString("nom"),LocalDate.parse(rs.getString("sortie")),LocalTime.parse(rs.getString("duree")),rs.getBoolean("disponible"),Categorie.valueOf(rs.getString("categorie")));
				films.add(film);
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return films;
	}

	@Override
	public void insert(Film film) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("insert into film (nom,sortie,duree,disponible,categorie) VALUES (?,?,?,?,?)");
			ps.setString(1, film.getNom());
			ps.setString(2, film.getSortie().toString());
			ps.setString(3, film.getDuree().toString());
			ps.setBoolean(4, film.isDisponible());
			ps.setString(5, film.getCategorie().toString());
			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Film film) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("update film set nom=?,sortie=?,duree=?,disponible=?,categorie=? where id=?");
			ps.setString(1, film.getNom());
			ps.setString(2, film.getSortie().toString());
			ps.setString(3, film.getDuree().toString());
			ps.setBoolean(4, film.isDisponible());
			ps.setString(5, film.getCategorie().toString());
			ps.setInt(6, film.getId());
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

			PreparedStatement ps  = conn.prepareStatement("DELETE from film where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	


	

}
