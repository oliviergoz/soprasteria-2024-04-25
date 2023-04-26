package formationJpa;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppTest {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eshop");
		System.out.println(emf);
		emf.close();
	}
}
