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
import cinema.model.Film;
import cinema.model.Langue;
import cinema.model.Salle;
import cinema.model.Seance;

public class DAOSeance implements IDAO<Seance,Integer>{

	@Override
	public Seance findById(Integer id) {
		Seance seance=null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("SELECT * from seance where id=?");
			ps.setInt(1, id);
			ResultSet rs  = ps.executeQuery();

			while(rs.next()) 
			{
				Film film = (Film) Singleton.getInstance().getDaoFilm().findById(rs.getInt("film_id"));
				Salle salle = (Salle)Singleton.getInstance().getDaoSalle().findById(rs.getInt("salle_id"));
				seance = new Seance(rs.getInt("id"), LocalDate.parse(rs.getString("date_seance")), LocalTime.parse(rs.getString("horaire")),rs.getDouble("prix"), film, salle, Langue.valueOf(rs.getString("langue")));
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}


		return seance;
	}

	@Override
	public List<Seance> findAll() {
		List<Seance> seances=new ArrayList();

		Seance seance=null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("SELECT * from seance");
			ResultSet rs  = ps.executeQuery();

			while(rs.next()) 
			{
				Film film = (Film) Singleton.getInstance().getDaoFilm().findById(rs.getInt("film_id"));
				Salle salle = (Salle)Singleton.getInstance().getDaoSalle().findById(rs.getInt("salle_id"));
				seance = new Seance(rs.getInt("id"), LocalDate.parse(rs.getString("date_seance")), LocalTime.parse(rs.getString("horaire")),rs.getDouble("prix"), film, salle, Langue.valueOf(rs.getString("langue")));
				seances.add(seance);

			}


			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return seances;
	}

	@Override
	public void insert(Seance seance) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("INSERT INTO seance (date_seance,horaire,prix,langue,film_id,salle_id) VALUES (?,?,?,?,?,?)");


			ps.setString(1,seance.getDateSeance().toString());
			ps.setString(2, seance.getHoraire().toString());
			ps.setDouble(3, seance.getPrix());
			ps.setString(4, seance.getLangue().toString());
			ps.setInt(5, seance.getFilm().getId());
			ps.setInt(6, seance.getSalle().getId());

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Seance seance) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("UPDATE seance set date_seance=?,horaire=?,prix=?,langue=?,film_id=?,salle_id=? where id=?");

			ps.setString(1,seance.getDateSeance().toString());
			ps.setString(2, seance.getHoraire().toString());
			ps.setDouble(3, seance.getPrix());
			ps.setString(4, seance.getLangue().toString());
			ps.setInt(5, seance.getFilm().getId());
			ps.setInt(6, seance.getSalle().getId());
			ps.setInt(7, seance.getId());

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

			PreparedStatement ps  = conn.prepareStatement("delete from seance where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public List<Seance> findAllByDateSeance(String dateComparaison)
	{
		List<Seance> seances=new ArrayList();

		Seance seance=null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("SELECT * from seance WHERE date_seance=? ");
			ps.setString(1, dateComparaison);
			ResultSet rs  = ps.executeQuery();



			while(rs.next()) 
			{
				Film film = (Film) Singleton.getInstance().getDaoFilm().findById(rs.getInt("film_id"));
				Salle salle = (Salle)Singleton.getInstance().getDaoSalle().findById(rs.getInt("salle_id"));
				
				seance = new Seance(rs.getInt("id"), LocalDate.parse(rs.getString("date_seance")), LocalTime.parse(rs.getString("horaire")),rs.getDouble("prix"), film, salle, Langue.valueOf(rs.getString("langue")));
				seances.add(seance);

			}


			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return seances;

	}

}
