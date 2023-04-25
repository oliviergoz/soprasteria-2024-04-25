package cinema.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cinema.context.Singleton;
import cinema.model.Client;
import cinema.model.Evaluation;
import cinema.model.Film;

public class DAOEvaluation implements IDAO<Evaluation,Integer> {

	
	@Override
	public Evaluation findById(Integer id) {
		Evaluation evaluation=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("SELECT * from evaluation where id=?");
			ps.setInt(1, id);
			ResultSet rs  = ps.executeQuery();

			while(rs.next()) 
			{
				Client client = (Client) Singleton.getInstance().getDaoCompte().findById((rs.getInt("client_id")));
				Film film = Singleton.getInstance().getDaoFilm().findById((rs.getInt("film_id")));
				evaluation = new Evaluation(rs.getInt("id"), rs.getInt("note"),rs.getString("commentaire"),film,client);
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return evaluation;
	}

	@Override
	public List<Evaluation> findAll() {
		List<Evaluation> evaluations=new ArrayList();
		Evaluation evaluation =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("SELECT * from evaluation");
			ResultSet rs  = ps.executeQuery();

			while(rs.next()) 
			{
				Client client = (Client) Singleton.getInstance().getDaoCompte().findById((rs.getInt("client_id")));
				Film film = Singleton.getInstance().getDaoFilm().findById((rs.getInt("film_id")));
				evaluation = new Evaluation(rs.getInt("id"), rs.getInt("note"),rs.getString("commentaire"),film,client);
				evaluations.add(evaluation);
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return evaluations;
	}

	@Override
	public void insert(Evaluation evaluation) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("insert into evaluation (note,commentaire,film_id,client_id) VALUES(?,?,?,?)");
			ps.setInt(1,evaluation.getNote());
			ps.setString(2, evaluation.getCommentaire());
			ps.setInt(3, evaluation.getFilm().getId());
			ps.setInt(4, evaluation.getClient().getId());


			ps.executeUpdate();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Evaluation evaluation) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Singleton.getInstance().getUrlBdd(),Singleton.getInstance().getLoginBdd(),Singleton.getInstance().getPasswordBdd());

			PreparedStatement ps  = conn.prepareStatement("UPDATE  evaluation set note=?,commentaire=?,film_id=?,client_id=? WHERE id=?");
			ps.setInt(1,evaluation.getNote());
			ps.setString(2, evaluation.getCommentaire());
			ps.setInt(3, evaluation.getFilm().getId());
			ps.setInt(4, evaluation.getClient().getId());
			ps.setInt(5, evaluation.getId());



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

			PreparedStatement ps  = conn.prepareStatement("DELETE FROM evaluation WHERE id=?");
			ps.setInt(1, id);


			ps.executeUpdate();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
