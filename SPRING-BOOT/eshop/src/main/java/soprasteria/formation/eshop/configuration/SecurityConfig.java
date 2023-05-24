package soprasteria.formation.eshop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// @formatter:off
		http.antMatcher("/**")
				.csrf(csrf -> csrf.disable())
				.authorizeRequests(requests ->  requests.antMatchers("/").permitAll()
														.antMatchers("/commande/**").hasRole("CLIENT")
														.anyRequest().hasAnyRole("ADMIN"))
				.formLogin(withDefaults())
				.logout(logout -> logout.logoutSuccessUrl("/"));

//        http.antMatcher("/**")
//        		.csrf().disable()
//        		.authorizeRequests()
//        			.antMatchers("/").permitAll()
//        			.antMatchers("/commande/**").hasRole("CLIENT")
//        			.anyRequest().hasRole("ADMIN")
//        		.and()
//        		.formLogin()
//        		.and()
//        		.logout().logoutSuccessUrl("/");
		// @formatter:on
	}

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// @formatter:off
		auth.userDetailsService(userDetailsService);
		// @formatter:on
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
