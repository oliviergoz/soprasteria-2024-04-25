package musicienV1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import musicien.AppSpring;
import musicien.beans.Musicien;
import musicien.configurations.AppConfig;

public class AppTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		ctx.getBeanFactory().createBean(AppSpring.class).run(args);
		ctx.close();
	}
}
