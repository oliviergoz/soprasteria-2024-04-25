package springAOP.beans;

import org.springframework.stereotype.Component;

@Component
public class BeanPourAspect implements InterfacePourAspect {

	public String methode() {
		return "hello world";
		// throw new IllegalArgumentException();
	}
}
