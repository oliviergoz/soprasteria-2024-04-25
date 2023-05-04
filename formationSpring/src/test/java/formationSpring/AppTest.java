package formationSpring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import formationSpring.beans.Personne;
import formationSpring.beans.SePresenter;

public class AppTest {
	public static void main(String[] args) {
		// lancement de spring
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		System.out.println(ctx);
		SePresenter olivier = ctx.getBean("olivier", SePresenter.class);
		olivier.bonjour();
		System.out.println(((Personne)olivier).getAdresse());
		// System.out.println(olivier.getNom());
		// ctx.getBean(Personne.class);
		// arret de spring
		ctx.close();
	}
}
