package springAOP.beans;

import org.springframework.stereotype.Component;

@Component
public class AutreBean implements InterfacePourAspect {

	@Override
	public String methode() {
		return "bonjour le monde";

	}

}
