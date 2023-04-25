package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;

import cinema.model.Acteur;
import cinema.model.Admin;
import cinema.model.Adresse;
import cinema.model.Categorie;
import cinema.model.Client;
import cinema.model.Evaluation;
import cinema.model.Film;
import cinema.model.Langue;
import cinema.model.Reservation;
import cinema.model.Salle;
import cinema.model.Seance;
import cinema.model.Spectateur;
import cinema.model.Statut;

public class Test {

	public static void main(String[] args) {

		Adresse adresse1= new Adresse("12","rue de Paris","Paris","75013");
		Adresse adresse2= new Adresse("15","rue de Toulouse","Toulouse","31000");

		Client client1=new Client(2849, "Toto","client1","mail@mail.fr","Dupond","Toto","0678352639",LocalDate.parse("1990-01-01"),adresse1);
		Client client2=new Client(4593, "Titi","client2","mail@mail.com","Dupond","Titi","0612345673",LocalDate.parse("1990-12-31"),adresse2);
		Admin admin=new Admin(3217,"Pierre","Admin",null);


		//Acteurs
		Acteur acteur1= new Acteur(1,"B. Jordan","Michael","Americain");
		Acteur acteur2= new Acteur(2,"Worthington","Sam","Australien");
		Acteur acteur3= new Acteur(3,"Doe","Jane","Anglais");

		// Films
		Film film1= new Film(1,"Avatar 2",LocalDate.parse("2022-12-14"),LocalTime.parse("03:12"),true,Categorie.Animation);
		Film film2= new Film(2,"Creed III",LocalDate.parse("2023-03-01"),LocalTime.parse("01:57"),true,Categorie.Action);

		
		film1.getActeurs().add(acteur1);
		film1.getActeurs().add(acteur2);

		film2.getActeurs().add(acteur1);
		film2.getActeurs().add(acteur3);


		//evaluation1 => client1 / film1 , evaluation2 => client1 / film 2 , evaluation3=> client2 / film1
		//note entre 1 - 5
		Evaluation evaluation1=new Evaluation(1, 3, "bof", film1, client1);
		Evaluation evaluation2=new Evaluation(2, 5, "Wow", film2, client1);
		Evaluation evaluation3=new Evaluation(3, 4, "Cool", film1, client2);



		//Salles
		Salle salle1= new Salle(1,"1",120);
		Salle salle2= new Salle(2,"2",130);
		Salle salle3= new Salle(3,"3",150);

		//Seance 1 et 2 pour le film 1, seance 3 pour le film 2, salle au choix
		Seance seance1=new Seance(15, LocalDate.parse("2023-03-21"), LocalTime.parse("20:00"), 12.50, film1, salle1, Langue.VF);
		Seance seance2=new Seance(12, LocalDate.parse("2023-03-22"), LocalTime.parse("20:30"), 12.50, film1, salle3, Langue.VO);
		Seance seance3=new Seance(34, LocalDate.parse("2023-03-22"), LocalTime.parse("16:15"), 12.50, film2, salle2, Langue.VOSTFR);



		//reservation1 pour le film 1 /client1, reservation2 film2 / client1
		Reservation reservation1=new Reservation(1, 8.5, LocalDate.parse("2023-03-21"), client1, seance1);
		Reservation reservation2=new Reservation(2, 8.5, LocalDate.parse("2023-03-28"), client1, seance2);


		Spectateur spectateur1=new Spectateur(1, 26, Statut.PMR);
		Spectateur spectateur2=new Spectateur(2, 78, Statut.retraite);
		Spectateur spectateur3=new Spectateur(3, 14, Statut.enfant);


		reservation1.getSpectateurs().add(spectateur1);
		reservation1.getSpectateurs().add(spectateur2);
		reservation2.getSpectateurs().add(spectateur3);


		System.out.println(reservation1);

	}

}
