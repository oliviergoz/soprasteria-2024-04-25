package formationSpring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {
	public static void main(String[] args) {
		//lancement de spring
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:application-context.xml");
		System.out.println(ctx);
		
		
		//arret de spring
		ctx.close();
	}
}
