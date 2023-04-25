package cinema.context;

import cinema.dao.DAOActeur;
import cinema.dao.DAOCompte;
import cinema.dao.DAOEvaluation;
import cinema.dao.DAOFilm;
import cinema.dao.DAOReservation;
import cinema.dao.DAOSalle;
import cinema.dao.DAOSeance;
import cinema.dao.DAOSpectateur;
import cinema.model.Compte;

public class Singleton {
	
	
	private String urlBdd;
	private String loginBdd="root";
	private String passwordBdd;	
	private Compte connected;
	private DAOActeur daoActeur = new DAOActeur();
	private DAOCompte daoCompte = new DAOCompte();
	private DAOEvaluation daoEvaluation = new DAOEvaluation();
	private DAOFilm daoFilm = new DAOFilm();
	private DAOReservation daoReservation = new DAOReservation();
	private DAOSalle daoSalle = new DAOSalle();
	private DAOSeance daoSeance = new DAOSeance();
	private DAOSpectateur daoSpectateur = new DAOSpectateur();
	
	
	
	
	private static Singleton instance;


	private Singleton() {
		if (System.getProperty("os.name").contains("Mac")) {
			urlBdd = "jdbc:mysql://localhost:3306/cinema?characterEncoding=UTF-8";
			passwordBdd="root123@";
		}
		else {
			urlBdd = "jdbc:mysql://localhost:3306/cinema?characterEncoding=UTF-8";
			passwordBdd="";
		}
	}

	public static Singleton getInstance() {
		
		if(instance==null) 
		{
			instance=new Singleton();
		}
		return instance;
		
	}

	public String getUrlBdd() {
		return urlBdd;
	}


	public void setUrlBdd(String urlBdd) {
		this.urlBdd = urlBdd;
	}


	public String getLoginBdd() {
		return loginBdd;
	}


	public void setLoginBdd(String loginBdd) {
		this.loginBdd = loginBdd;
	}


	public String getPasswordBdd() {
		return passwordBdd;
	}


	public void setPasswordBdd(String passwordBdd) {
		this.passwordBdd = passwordBdd;
	}

	public Compte getConnected() {
		return connected;
	}

	public void setConnected(Compte connected) {
		this.connected = connected;
	}

	public DAOActeur getDaoActeur() {
		return daoActeur;
	}

	public void setDaoActeur(DAOActeur daoActeur) {
		this.daoActeur = daoActeur;
	}

	public DAOCompte getDaoCompte() {
		return daoCompte;
	}

	public void setDaoCompte(DAOCompte daoCompte) {
		this.daoCompte = daoCompte;
	}

	public DAOEvaluation getDaoEvaluation() {
		return daoEvaluation;
	}

	public void setDaoEvaluation(DAOEvaluation daoEvaluation) {
		this.daoEvaluation = daoEvaluation;
	}

	public DAOFilm getDaoFilm() {
		return daoFilm;
	}

	public void setDaoFilm(DAOFilm daoFilm) {
		this.daoFilm = daoFilm;
	}

	public DAOReservation getDaoReservation() {
		return daoReservation;
	}

	public void setDaoReservation(DAOReservation daoReservation) {
		this.daoReservation = daoReservation;
	}

	public DAOSalle getDaoSalle() {
		return daoSalle;
	}

	public void setDaoSalle(DAOSalle daoSalle) {
		this.daoSalle = daoSalle;
	}

	public DAOSeance getDaoSeance() {
		return daoSeance;
	}

	public void setDaoSeance(DAOSeance daoSeance) {
		this.daoSeance = daoSeance;
	}

	public DAOSpectateur getDaoSpectateur() {
		return daoSpectateur;
	}

	public void setDaoSpectateur(DAOSpectateur daoSpectateur) {
		this.daoSpectateur = daoSpectateur;
	}



	
	
	
	
	

}
