package cinema.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import cinema.context.Singleton;
import cinema.model.Client;
import cinema.model.Reservation;
import cinema.model.Seance;

public class DAOReservation implements IDAO<Reservation,Integer> {

	@Override
	public Reservation findById(Integer id) {
		Reservation reservation=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("SELECT * from reservation where id=?");
			ps.setInt(1, id);
			ResultSet rs  = ps.executeQuery();

			while(rs.next()) 
			{
				Client client = (Client) Singleton.getInstance().getDaoCompte().findById((rs.getInt("client_id")));

				Seance seance = Singleton.getInstance().getDaoSeance().findById((rs.getInt("seance_id")));
				reservation = new Reservation(rs.getInt("id"), rs.getDouble("prix"), LocalDate.parse(rs.getString("date_reservation")), client, seance);
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return reservation;
	}

	@Override
	public List<Reservation> findAll() {
		List<Reservation> reservations=new ArrayList();
		Reservation reservation=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("SELECT * from reservation");
			ResultSet rs  = ps.executeQuery();

			while(rs.next()) 
			{
				Client client = (Client) Singleton.getInstance().getDaoCompte().findById((rs.getInt("client_id")));

				Seance seance = Singleton.getInstance().getDaoSeance().findById((rs.getInt("seance_id")));
				reservation = new Reservation(rs.getInt("id"), rs.getDouble("prix"), LocalDate.parse(rs.getString("date_reservation")), client, seance);
				reservations.add(reservation);
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reservations;
	}

	@Override
	public void insert(Reservation reservation) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("insert into reservation (prix,date_reservation,client_id,seance_id) VALUES(?,?,?,?)");
			ps.setDouble(1, reservation.getPrix());
			ps.setString(2,reservation.getDateReservation().toString());
			ps.setInt(3, reservation.getClient().getId());
			ps.setInt(4, reservation.getSeance().getId());

			ps.executeUpdate();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Reservation reservation) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("update reservation set prix=?,date_reservation=?,client_id=?,seance_id=? where id=?");
			ps.setDouble(1, reservation.getPrix());
			ps.setString(2,reservation.getDateReservation().toString());
			ps.setInt(3, reservation.getClient().getId());
			ps.setInt(4, reservation.getSeance().getId());
			ps.setInt(5, reservation.getId());
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

			PreparedStatement ps  = conn.prepareStatement("delete from reservation where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public  List<Reservation> findAllByClient(Integer id) 
	{
		List<Reservation> reservations=new ArrayList();
		Reservation reservation=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("SELECT * from reservation where client_id=?");
			ps.setInt(1, id);
			ResultSet rs  = ps.executeQuery();

			while(rs.next()) 
			{
				Client client = (Client) Singleton.getInstance().getDaoCompte().findById((rs.getInt("client_id")));

				Seance seance = Singleton.getInstance().getDaoSeance().findById((rs.getInt("seance_id")));
				reservation = new Reservation(rs.getInt("id"), rs.getDouble("prix"), LocalDate.parse(rs.getString("date_reservation")), client, seance);
				reservations.add(reservation);
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reservations;
	}
}
