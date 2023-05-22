package soprasteria.formation.springBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
}
