package soprasteria.formation.springBoot.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// configuration du filtre
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//@formatter:off
		http.antMatcher("/**")
				.csrf().disable()  //a mettre sans reflechir pas pour les webservices
				.authorizeRequests()
					.antMatchers("/home").permitAll()
					.antMatchers("/admin/**").hasAnyRole("ADMIN")
					.antMatchers("/client/**").hasAnyRole("CLIENT")
					.anyRequest().authenticated() //a mettre en dernier
												   //toutes les requetes non traitées au dessus passent là
				.and()
				.formLogin();	 //formulaire html pour authentification
		//@formatter:on
	}
	
	@Override
	//definition des utilisateurs
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//utilisateur en memoire
		// @formatter:off
		auth.inMemoryAuthentication()
				.withUser("admin").password("{noop}admin").roles("ADMIN")
				.and()
				.withUser("client1").password("{noop}client1").roles("CLIENT")
				.and()
				.withUser("superuser").password("{noop}superuser").roles("CLIENT","ADMIN");
		
		// @formatter:on

	}
}
