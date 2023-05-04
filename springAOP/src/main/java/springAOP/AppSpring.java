package springAOP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import springAOP.beans.InterfacePourAspect;

public class AppSpring {
	@Autowired
	@Qualifier("autreBean")
	private InterfacePourAspect bean;

	@Autowired
	@Qualifier("beanPourAspect")
	private InterfacePourAspect bean2;

	public void run(String... args) {
		System.out.println(bean.methode());
		System.out.println(bean2.methode());
	}
}
