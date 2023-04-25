package cinema;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import cinema.context.Singleton;
import cinema.dao.DAOActeur;
import cinema.dao.DAOCompte;
import cinema.dao.DAOEvaluation;
import cinema.dao.DAOFilm;
import cinema.dao.DAOReservation;
import cinema.dao.DAOSalle;
import cinema.dao.DAOSeance;
import cinema.dao.DAOSpectateur;
import cinema.model.Acteur;
import cinema.model.Admin;
import cinema.model.Adresse;
import cinema.model.Categorie;
import cinema.model.Client;
import cinema.model.Compte;
import cinema.model.Evaluation;
import cinema.model.Film;
import cinema.model.Langue;
import cinema.model.Reservation;
import cinema.model.Salle;
import cinema.model.Seance;
import cinema.model.Spectateur;
import cinema.model.Statut;

// Ceci est un autre commentaire

public class App {


	static DAOActeur daoActeur = Singleton.getInstance().getDaoActeur();
	static DAOCompte daoCompte = Singleton.getInstance().getDaoCompte();
	static DAOEvaluation daoEvaluation = Singleton.getInstance().getDaoEvaluation();
	static DAOFilm daoFilm= Singleton.getInstance().getDaoFilm();
	static DAOReservation daoReservation = Singleton.getInstance().getDaoReservation();
	static DAOSalle daoSalle = Singleton.getInstance().getDaoSalle();
	static DAOSeance daoSeance = Singleton.getInstance().getDaoSeance();
	static DAOSpectateur daoSpectateur = Singleton.getInstance().getDaoSpectateur();

	public static String saisieString(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		String valeur = sc.nextLine();
		return valeur;
	}

	public static boolean saisieBoolean(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		boolean valeur = sc.nextBoolean();
		return valeur;
	}


	public static int saisieInt(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		int valeur = sc.nextInt();
		return valeur;
	}


	public static double saisieDouble(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextDouble();
	}


	public static void menuPrincipal() {

		System.out.println("\nAppli Cinema");
		System.out.println("1 - Se connecter");
		System.out.println("2 - Inscription");
		System.out.println("3 - Quitter");

		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : seConnecter();break;
		case 2 : inscription();break;
		case 3 : System.exit(0);break;
		}

		menuPrincipal();

	}





	public static void seConnecter() {
		String login= saisieString("Saisir login");
		String password = saisieString("Saisir password");

		Compte connected = daoCompte.findByLoginAndPassword(login,password);
		Singleton.getInstance().setConnected(connected);

		if(connected instanceof Admin)
		{
			menuAdmin();
		}
		else if(connected instanceof Client) 
		{
			menuClient();
		}
		else 
		{
			System.out.println("Identifiants invalides");
		}
	}




	public static void menuClient() {
		System.out.println("\nMenu Client");
		System.out.println("1- Voir toutes les séances");
		System.out.println("2- Voir toutes les séances à une date precise");
		System.out.println("3- Faire une reservation");
		System.out.println("4- Gestion de mes reservations");
		System.out.println("5- Faire une evaluation");
		System.out.println("6- Se deconnecter");
		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : afficherSeances();break;
		case 2 : afficherSeancesDate();break;
		case 3 : faireReservation();break;
		case 4 : gestionMesReservations();break;
		case 5 : faireEvaluation();break;
		case 6 : menuPrincipal();break;
		}

		menuClient();
	}


	private static void gestionMesReservations() {
		System.out.println("\nGestion de mes reservations :");
		System.out.println("1 - Afficher mes reservations");
		System.out.println("2 - Ajouter un spectateur");
		System.out.println("3 - Modifier un spectateur");
		System.out.println("4 - Supprimer un spectateur");
		System.out.println("5 - Retour");
		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : afficherMesReservations();break;
		case 2 : ajouterSpectateur();break;
		case 3 : modiferMesSpectateurs();break;
		case 4 : supprimerMonSpectateur();break;
		case 5 : menuClient();break;
		}
		gestionMesReservations();
	}




	private static void supprimerMonSpectateur() {
		afficherMesReservations();
		int idReservation = saisieInt("Choisir une reservation");

		List<Spectateur> spectateurs = daoSpectateur.findAllByReservation(idReservation);

		if(spectateurs.isEmpty()) 
		{
			System.out.println("Aucun spectateur pour cette reservation...");
		}
		else 
		{
			for(Spectateur s : spectateurs) 
			{
				System.out.println(s);
			}
			int id = saisieInt("Saisir l'id du spectateur");
			daoSpectateur.delete(id);		
		}	
	}




	private static void modiferMesSpectateurs() {
		afficherMesReservations();
		int idReservation = saisieInt("Choisir une reservation");

		List<Spectateur> spectateurs = daoSpectateur.findAllByReservation(idReservation);

		if(spectateurs.isEmpty()) 
		{
			System.out.println("Aucun spectateur pour cette reservation...");
		}
		else 
		{
			for(Spectateur s : spectateurs) 
			{
				System.out.println(s);
			}
			int id = saisieInt("Saisir l'id du spectateur");
			int age = saisieInt("Saisir l'age du spectateur");
			String statutS = saisieString("Saisir statut : "+Arrays.toString(Statut.values()));
			Spectateur spectateur = new Spectateur(id,age,Statut.valueOf(statutS));
			daoSpectateur.update(spectateur);

		}	
	}




	private static void ajouterSpectateur() {
		afficherMesReservations();
		int idReservation = saisieInt("Choisir une reservation");
		int age = saisieInt("Saisir l'age du spectateur");
		String statutS = saisieString("Saisir statut : "+Arrays.toString(Statut.values()));

		Spectateur s = new Spectateur(age,Statut.valueOf(statutS));
		daoSpectateur.insert(s);

		daoSpectateur.insertTicket(idReservation,s.getId());

	}




	private static void afficherMesReservations() {
		List<Reservation> reservations = daoReservation.findAllByClient(Singleton.getInstance().getConnected().getId());
		if(reservations.isEmpty()) 
		{
			System.out.println("Vous n'avez pas de reservation");
		}
		for(Reservation r : reservations) 
		{
			System.out.println(r);
		}
	}




	private static void faireReservation() {
		System.out.println("1 - Toutes les seances : ");
		System.out.println("2 - Toutes les seances à une date precise :");
		int choix = saisieInt("Choix :");

		switch(choix) 
		{
		case 1 : afficherSeances();break;
		case 2 : afficherSeancesDate();break;
		}

		int id = saisieInt("Saisir l'id de la seance");
		Seance s = daoSeance.findById(id);


		Reservation r = new Reservation(s.getPrix(),LocalDate.now(),(Client) Singleton.getInstance().getConnected(),s);
		daoReservation.insert(r);
	}



	public static void menuAdmin() {
		System.out.println("\nMenu Admin");
		System.out.println("1- Gestion des Comptes");
		System.out.println("2- Gestion des Films");
		System.out.println("3- Gestion des Acteurs");
		System.out.println("4- Gestion des Seances");
		System.out.println("5- Gestion des Salles");
		System.out.println("6- Gestion des Reservations");
		System.out.println("7- Gestion des Spectateurs");
		System.out.println("8- Gestion des Evaluations");
		System.out.println("9- Se deconnecter");
		int choix = saisieInt("Choisir un menu");
		switch(choix) 
		{
		case 1 : gestionComptes();break;
		case 2 : gestionFilms();break;
		case 3 : gestionActeurs();break;
		case 4 : gestionSeances();break;
		case 5 : gestionSalles();break;
		case 6 : gestionReservations();break;
		case 7 : gestionSpectateurs();break;
		case 8 : gestionEvaluations();break;
		case 9 : menuPrincipal();break;
		}

		menuAdmin();	
	}


	////----------------------------GROUPE 1------------------------------------///



	private static void gestionActeurs() {
		System.out.println("\nGestion des Acteurs");
		System.out.println("1 - Afficher tous les acteurs");
		System.out.println("2 - Ajouter un acteur");
		System.out.println("3 - Modifier un acteur");
		System.out.println("4 - supprimer un acteur");
		System.out.println("5 - retour");
		int choix = saisieInt("Choisir un menu :");

		switch(choix) 
		{
		case 1 : afficherActeurs(); break;
		case 2 : ajouterActeur();break;
		case 3 : modifierActeur(); break;
		case 4 : supprimerActeur();break;
		case 5 : menuAdmin();break;
		}
		gestionActeurs();

	}




	private static void supprimerActeur() {
		afficherActeurs();
		int id =saisieInt("Saisir l'id de l'acteur");
		daoActeur.delete(id);

	}




	private static void modifierActeur() {
		afficherActeurs();
		int id =saisieInt("Saisir l'id de l'acteur");

		Acteur a = daoActeur.findById(id);
		String nom=saisieString("Saisir le nom de l'acteur");
		String prenom=saisieString("Saisir le prénom de l'acteur");
		String nationalite=saisieString("Saisir la nationalite de l'acteur");
		a =new Acteur(id,nom, prenom, nationalite);
		daoActeur.update(a);

	}




	private static void ajouterActeur() {

		String nom=saisieString("Saisir le nom de l'acteur");
		String prenom=saisieString("Saisir le prénom de l'acteur");
		String nationalite=saisieString("Saisir la nationalite de l'acteur");
		Acteur a =new Acteur(nom, prenom, nationalite);
		daoActeur.insert(a);
	}





	private static void afficherActeurs() {
		List<Acteur> acteurs = daoActeur.findAll();
		if(acteurs.isEmpty()) 
		{
			System.out.println("Aucun acteur....");
		}
		for(Acteur a : acteurs) 
		{
			System.out.println(a);
		}	
	}




	private static void gestionFilms() {
		System.out.println("\nGestion des Films");
		System.out.println("1 - Afficher tous les films");
		System.out.println("2 - Ajouter un film");
		System.out.println("3 - Modifier un film");
		System.out.println("4 - supprimer un film");
		System.out.println("5 - retour");
		int choix = saisieInt("Choisir un menu :");

		switch(choix) 
		{
		case 1 : afficherFilms(); break;
		case 2 : ajouterFilm();break;
		case 3 : modifierFilm(); break;
		case 4 : supprimerFilm();break;
		case 5 : menuAdmin();break;
		}
		gestionFilms();
	}




	private static void supprimerFilm() {
		afficherFilms();
		//saisir id
		//delete(id)
		int id = saisieInt("Entrer l'id du film à supprimer");
		daoFilm.delete(id);
	}




	private static void modifierFilm() {
		afficherFilms();

		List <Categorie> listeCategorie =new ArrayList();
		Collections.addAll(listeCategorie, Categorie.values());
		int id = saisieInt("Entrer l'id du film à modifier");
		Film f = daoFilm.findById(id);

		String nom = saisieString("Entrer le nom du film");
		LocalDate sortie = LocalDate.parse(saisieString("Entrer la date de sortie du film"));
		LocalTime duree = LocalTime.parse(saisieString("Saisir la durée du film"));
		String rep;
		rep = saisieString("Le film est-il disponible oui/non ?");
		boolean disponible = true;
		if (rep.equals("oui")) {
			disponible = true;
		}
		else if (rep.equals("non")) {
			disponible = false; 
		}
		for (Categorie c:listeCategorie) 
		{
			System.out.println(c);
		}
		rep=saisieString("\nSaisir la categorie du film");

		Categorie categ= Categorie.valueOf(rep);

		f = new Film(id,nom, sortie, duree, disponible, categ);

		daoFilm.update(f);	

	}




	private static void ajouterFilm() {

		List <Categorie> listeCategorie =new ArrayList();
		Collections.addAll(listeCategorie, Categorie.values());
		String nom = saisieString("Entrer le nom du film");
		LocalDate sortie = LocalDate.parse(saisieString("Entrer la date de sortie du film"));
		LocalTime duree = LocalTime.parse(saisieString("Saisir la durée du film"));
		String rep;
		rep = saisieString("Le film est-il disponible oui/non ?");
		boolean disponible = true;
		if (rep.equals("oui")) {
			disponible = true;
		}
		else if (rep.equals("non")) {
			disponible = false; 
		}
		for (Categorie c:listeCategorie) 
		{
			System.out.println(c);
		}
		rep=saisieString("\nSaisir la categorie du film");
		Categorie categ= Categorie.valueOf(rep);

		Film f = new Film(nom, sortie, duree, disponible, categ);

		daoFilm.insert(f);

	}




	private static void afficherFilms() {
		List<Film> films = daoFilm.findAll();
		if(films.isEmpty()) 
		{
			System.out.println("Aucun film....");
		}
		for(Film f : films) 
		{
			System.out.println(f);
		}	
	}


	private static void gestionSalles() {
		System.out.println("\nGestion des salles");
		System.out.println("1 - Afficher toutes les salles");
		System.out.println("2 - Ajouter une salle");
		System.out.println("3 - Modifier une salle");
		System.out.println("4 - supprimer une salle");
		System.out.println("5 - retour");
		int choix = saisieInt("Choisir un menu :");

		switch(choix) 
		{
		case 1 : afficherSalles(); break;
		case 2 : ajouterSalle();break;
		case 3 : modifierSalle(); break;
		case 4 : supprimerSalle();break;
		case 5 : menuAdmin();break;
		}
		gestionSalles();
	}




	private static void supprimerSalle() {
		afficherSalles();
		int id=saisieInt("Saisir l'id de la salle");
		daoSalle.delete(id);
	}




	private static void modifierSalle() {
		afficherSalles();
		int id=saisieInt("Saisir l'id de la salle");
		Salle s = daoSalle.findById(id);
		String nom=saisieString("Saisir le nom de la salle");
		int places=saisieInt("Saisir le nombre de places de la salle");
		s=new Salle(id,nom, places);
		daoSalle.update(s);

	}




	private static void ajouterSalle() {
		String nom=saisieString("Saisir le nom de la salle");
		int places=saisieInt("Saisir le nombre de places de la salle");
		Salle s=new Salle(nom, places);
		daoSalle.insert(s);
	}




	private static void afficherSalles() {
		List<Salle> salles = daoSalle.findAll();
		if(salles.isEmpty()) 
		{
			System.out.println("Aucune salle....");
		}
		for(Salle a : salles) 
		{
			System.out.println(a);
		}	
	}

	////----------------------------GROUPE 2------------------------------------///







	private static void gestionEvaluations() {
		System.out.println("\nGestion des Evaluations");
		System.out.println("1 - Afficher toutes les evaluations");
		System.out.println("2 - Modifier une evaluation");
		System.out.println("3 - Supprimer une evaluation");
		System.out.println("4 - Retour");
		int choix = saisieInt("Choisir un menu :");

		switch(choix) 
		{
		case 1 : afficherEvaluations(); break;
		case 2 : modifierEvaluation(); break;
		case 3 : supprimerEvaluation();break;
		case 4 : menuAdmin();break;
		}
		gestionEvaluations();
	}

	public static void faireEvaluation() {
		afficherFilms();

		//saisir l'id du film
		Integer IdFilm = saisieInt("Veuillez saisir l'id du film à évaluer");

		//Film f = findById(id)
		Film f = daoFilm.findById(IdFilm);

		//Saisir une note
		int note = saisieInt("Veuillez saisir votre note");

		//Saisir un commentaire
		String commentaire = saisieString("Veuillez saisir votre commentaire");

		//Evaluation e = new Evaluation //Il faudra cast connected en Client
		Evaluation e = new Evaluation(note,commentaire,f,(Client) Singleton.getInstance().getConnected());

		daoEvaluation.insert(e);

	}


	private static void supprimerEvaluation() {
		afficherEvaluations();
		//Faire saisir l'id de l'evaluation à delete
		Integer IdEvaluation = saisieInt("Veuillez saisir l'id de l'évaluation à supprimer");

		//delete 
		daoEvaluation.delete(IdEvaluation);

	}



	private static void modifierEvaluation() {
		//Utilisé par l'admin

		afficherEvaluations();
		//faire saisir l'id
		Integer IdEvaluation = saisieInt("Veuillez saisir l'id de l'évaluation à modifier");

		//Evaluation e = findById(id);
		Evaluation e = daoEvaluation.findById(IdEvaluation);

		//Test
		//System.out.println(e);

		//Saisir client
		afficherClients();

		//faire saisir l'id du client
		Integer IdClient = saisieInt("Veuillez saisir le nouvel id du client");

		//Client c = findById(id);
		Client c = (Client) daoCompte.findById(IdClient);

		//Saisir film
		afficherFilms();

		//faire saisir l'id du film
		Integer IdFilm = saisieInt("Veuillez saisir le nouvel id du film");

		//Film f = findById(id);
		Film f = daoFilm.findById(IdFilm);

		//faire saisir le commentaire
		String nouveauCommentaire = saisieString("Veuillez saisir le nouveau commentaire.");

		//faire la note
		Integer nouvelleNote = saisieInt("Veuillez saisir la nouvelle note");

		//e.set tous les attributs
		e.setClient(c);
		e.setCommentaire(nouveauCommentaire);
		e.setFilm(f);
		e.setId(IdEvaluation);
		e.setNote(nouvelleNote);

		//updateEvaluation(e);
		daoEvaluation.update(e);

	}



	private static void afficherEvaluations() {
		List<Evaluation> evaluations = daoEvaluation.findAll();
		if(evaluations.isEmpty()) 
		{
			System.out.println("Aucune evaluation");
		}
		for(Evaluation e : evaluations) 
		{
			System.out.println(e);
		}

	}




	private static void gestionSpectateurs() {
		System.out.println("\nGestion des Spectateurs");
		System.out.println("1 - Afficher tous les spectateurs");
		System.out.println("2 - Modifier un spectateur");
		System.out.println("3 - Supprimer un spectateur");
		System.out.println("4 - retour");
		int choix = saisieInt("Choisir un menu :");

		switch(choix) 
		{
		case 1 : afficherSpectateurs(); break;
		case 2 : modifierSpectateur(); break;
		case 3 : supprimerSpectateur();break;
		case 4 : menuAdmin();break;
		}
		gestionSpectateurs();

	}

	private static void supprimerSpectateur() {
		afficherSpectateurs();

		Integer id= saisieInt("Saisir l'identifiant");
		daoSpectateur.delete(id);
	}

	private static void modifierSpectateur() {
		afficherSpectateurs();
		Integer id= saisieInt("Saisir l'identifiant");
		int age= saisieInt("Saisir l'âge");
		String statutS = saisieString("Saisir un statut : "+Arrays.toString(Statut.values()));
		Statut statut = Statut.valueOf(statutS);


		Spectateur spectateur=new Spectateur(id, age, statut);

		daoSpectateur.update(spectateur);

	}


	private static void afficherSpectateurs() {
		List<Spectateur> spectateurs = daoSpectateur.findAll();
		if(spectateurs.isEmpty()) 
		{
			System.out.println("Aucun spectateur...");
		}
		for(Spectateur s : spectateurs) 
		{
			System.out.println(s);
		}

	}


	private static void gestionReservations() {
		System.out.println("\nGestion des Reservations");
		System.out.println("1 - Afficher toutes les reservations");
		System.out.println("2 - Modifier une reservation");
		System.out.println("3 - Supprimer une reservation");
		System.out.println("4 - Retour");
		int choix = saisieInt("Choisir un menu :");

		switch(choix) 
		{
		case 1 : afficherReservations(); break;
		case 2 : modifierReservation(); break;
		case 3 : supprimerReservation();break;
		case 4 : menuAdmin();break;
		}
		gestionReservations();
	}


	private static void supprimerReservation() {
		afficherReservations(); 
		int id = saisieInt("Saisir id");
		daoReservation.delete( id);
	}





	private static void modifierReservation() {
		afficherReservations();
		int idr = saisieInt("Saisir id");
		afficherClients();
		int idc = saisieInt("Saisir id du client");
		Client client = (Client) daoCompte.findById(idc);
		afficherSeances();
		int ids = saisieInt("Saisir id de la seance");
		Seance s =daoSeance.findById(ids);
		String date = saisieString("Saisir date");
		double prix = saisieInt("Saisir prix");
		Reservation r = new Reservation(idr,prix,LocalDate.parse(date),client,s);
		daoReservation.update(r);
	}




	private static void afficherReservations() {
		List<Reservation> reservations = daoReservation.findAll();
		if(reservations.isEmpty()) 
		{
			System.out.println("Aucune reservation....");
		}
		for(Reservation r : reservations) 
		{
			System.out.println(r);
		}	
	}







	////----------------------------GROUPE 3------------------------------------///




	public static void inscription() {

		String login=saisieString("saisir login");
		String mdp=saisieString("saisir mot de passe");
		String nom=saisieString("saisir nom");
		String prenom=saisieString("saisir prenom");
		String telephone=saisieString("saisir num telephone ");
		String datenaissance=saisieString("saisir la date ");
		String numero=saisieString("saisir le numero");
		String voie=saisieString("saisir la voie ");
		String ville=saisieString("saisir la ville ");
		String cp=saisieString("saisir le cp  ");
		Adresse adresse=new Adresse(numero, voie, ville, cp);
		Client c = new Client(login, mdp, cp, nom, prenom, telephone, LocalDate.parse(datenaissance),adresse);
		daoCompte.insert(c);






		//Faire saisir toutes les infos client (login,password,nom,prenom,telephone,naissance,numero,voie,ville,cp
		//Client c = new Client();
		//insert(c)
	}





	private static void gestionComptes() {
		System.out.println("\nGestion des Comptes");
		System.out.println("1 - Afficher tous les comptes");
		System.out.println("2 - Ajouter un compte");
		System.out.println("3 - Modifier un compte");
		System.out.println("4 - supprimer un compte");
		System.out.println("5 - retour");
		int choix = saisieInt("Choisir un menu :");

		switch(choix) 
		{
		case 1 : afficherComptes(); break;
		case 2 : ajouterCompte();break;
		case 3 : modifierCompte(); break;
		case 4 : supprimerCompte();break;
		case 5 : menuAdmin();break;
		}
		gestionComptes();
	}




	private static void supprimerCompte() {
		afficherComptes();
		int id =saisieInt("saisir id ");
		daoCompte.delete(id);
		//saisir id
		//delete(id)

	}




	private static void modifierCompte() {
		afficherComptes();
		int id =saisieInt("saisir id ");
		Compte c =daoCompte.findById(id);
		String login =saisieString("saisir login ");
		String type =saisieString("saisir type de compte ");
		String psw =saisieString("saisir password ");
		String mail =saisieString("saisir mail ");

		if(type.equals("Client")){
			String nom=saisieString("saisir nom");
			String prenom=saisieString("saisir prenom");
			String telephone=saisieString("saisir num telephone ");
			String datenaissance=saisieString("saisir la date ");
			String numero=saisieString("saisir le numero");
			String voie=saisieString("saisir la voie ");
			String ville=saisieString("saisir la ville ");
			String cp=saisieString("saisir le cp  ");
			Adresse adresse=new Adresse(numero, voie, ville, cp);
			c = new Client(id,login, ville, cp, nom, prenom, telephone, LocalDate.parse(datenaissance),adresse);
		}
		else if(type.equals("Admin")) {
			c =new Admin(id, login, psw, mail);
		}


		daoCompte.update(c);

		//saisir id
		//Compte c = findById();
		//saisir type compte
		//saisir login, password,mail
		// Si client, faire saisir nom,prenom,telephone,naissance,numero,voie,ville,cp => c=new Client(id,...)
		// Si Admin => c = new Admin(id,...) 

		//update(c)
	}




	private static void ajouterCompte() {
		Compte c=null;
		String type =saisieString("saisir type de compte ");
		String login =saisieString("saisir login ");
		String psw =saisieString("saisir password ");
		String mail =saisieString("saisir mail ");
		if(type.equals("Client")){
			String nom=saisieString("saisir nom");
			String prenom=saisieString("saisir prenom");
			String telephone=saisieString("saisir num telephone ");
			String datenaissance=saisieString("saisir la date ");
			String numero=saisieString("saisir le numero");
			String voie=saisieString("saisir la voie ");
			String ville=saisieString("saisir la ville ");
			String cp=saisieString("saisir le cp  ");
			Adresse adresse=new Adresse(numero, voie, ville, cp);
			c = new Client(login, psw, mail, nom, prenom, telephone, LocalDate.parse(datenaissance),adresse);
		}
		else if(type.equals("Admin")) {
			c =new Admin(login, psw, mail);
		}
		daoCompte.insert(c);

		//saisir type compte
		//saisir login, password,mail
		// Si client, faire saisir nom,prenom,telephone,naissance,numero,voie,ville,cp => c=new Client()
		// Si Admin => c = new Admin() 

		//insert(c)

	}




	private static void afficherComptes() {
		List<Compte> comptes = daoCompte.findAll();
		if(comptes.isEmpty()) 
		{
			System.out.println("Aucun compte....");
		}
		for(Compte c : comptes) 
		{
			System.out.println(c);
		}	

	}


	private static void afficherClients() {
		List<Client> comptes = daoCompte.findAllClient();
		if(comptes.isEmpty()) 
		{
			System.out.println("Aucun compte....");
		}
		for(Compte c : comptes) 
		{
			System.out.println(c);
		}	

	}



	private static void gestionSeances() {
		System.out.println("\nGestion des Seances");
		System.out.println("1 - Afficher toutes les seances");
		System.out.println("2 - Afficher toutes les seances à une date precise");
		System.out.println("3 - Ajouter une seance");
		System.out.println("4 - Modifier une seance");
		System.out.println("5 - supprimer une seance");
		System.out.println("6 - retour");
		int choix = saisieInt("Choisir un menu :");

		switch(choix) 
		{
		case 1 : afficherSeances(); break;
		case 2 : afficherSeancesDate();break;
		case 3 : ajouterSeance();break;
		case 4 : modifierSeance(); break;
		case 5 : supprimerSeance();break;
		case 6 : menuAdmin();break;
		}
		gestionSeances();
	}




	private static void supprimerSeance() {
		afficherSeances();
		//saisir id
		int id = saisieInt("Saisir id à supprimer");
		//delete(id)
		daoSeance.delete(id);;

	}




	private static void modifierSeance() {
		afficherSeances();
		int idSeance= saisieInt("Saisir id à modifier");
		Seance s = daoSeance.findById(idSeance);

		afficherFilms();

		int idFilm = saisieInt("Saisir id à modifier");
		Film f = daoFilm.findById(idFilm);
		afficherSalles();

		System.out.println("Salle : "+s.getSalle().toString());
		int idSalle = saisieInt("Saisir id à modifier");

		Salle salle = daoSalle.findById(idSalle);

		System.out.println("Date : "+s.getDateSeance().toString());
		LocalDate date = LocalDate.parse(saisieString("Saisir date (yyyy-mm-dd)"));
		System.out.println("Horaire : "+s.getHoraire().toString());
		LocalTime horaire = LocalTime.parse(saisieString("Saisir horaire (hh:mm)"));
		System.out.println("Prix : "+s.getPrix());
		double prix = saisieDouble("Saisir prix");
		System.out.println("Langue : "+s.getLangue().toString());
		Langue langue = Langue.valueOf(saisieString("Saisir langue"));	
		Seance seance = new Seance(idSeance, date, horaire, prix, f, salle, langue);

		daoSeance.update(seance);
	}




	private static void ajouterSeance() {
		afficherFilms();
		//saisir id
		int id = saisieInt("Saisir id à ajouter");
		Film f = daoFilm.findById(id);
		afficherSalles();
		//saisir id
		id = saisieInt("Saisir id");
		Salle salle = daoSalle.findById(id);
		//saisir date + horaire+prix + langue
		LocalDate date = LocalDate.parse(saisieString("Saisir date (yyyy-mm-dd)"));
		LocalTime horaire = LocalTime.parse(saisieString("Saisir horaire (hh:mm)"));
		double prix = saisieDouble("Saisir prix");
		Langue langue = Langue.valueOf(saisieString("Saisir langue"));				
		Seance s = new Seance(date,horaire,prix,f,salle,langue);
		daoSeance.insert(s);

	}









	private static void afficherSeancesDate() {
		//faire saisir une date
		String date=saisieString("Saisir date (yyyy-mm-dd) :");		
		List<Seance> seances = daoSeance.findAllByDateSeance(date);
		if(seances.isEmpty()) 
		{
			System.out.println("Aucune seance...");
		}
		for(Seance s : seances) 
		{
			System.out.println(s);
		}


	}




	private static void afficherSeances() {
		List<Seance> seances = daoSeance.findAll();
		if(seances.isEmpty()) 
		{
			System.out.println("Aucune seance...");
		}
		for(Seance s : seances) 
		{
			System.out.println(s);
		}

	}


	public static void main(String[] args) {

		menuPrincipal();

	}

}
