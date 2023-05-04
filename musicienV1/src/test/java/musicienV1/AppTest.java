package musicienV1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import musicien.beans.Musicien;

public class AppTest {
public static void main(String[] args) {
	ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:application-context.xml");
	ctx.getBean("saxophoniste",Musicien.class).performer();
	ctx.close();
}
}
