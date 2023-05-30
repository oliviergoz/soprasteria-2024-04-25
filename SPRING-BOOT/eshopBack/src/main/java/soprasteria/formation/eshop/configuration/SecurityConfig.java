package soprasteria.formation.eshop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		// @formatter:off
//		return http.antMatcher("/api/**")
//				.csrf(csrf -> csrf.disable())
//				.authorizeRequests(requests ->  requests
//														.antMatchers("/api/commande/**").hasRole("CLIENT")
//														.anyRequest().hasAnyRole("ADMIN"))
//				.httpBasic(withDefaults())
//				.build();

		return http.antMatcher("/api/**")
						.csrf().disable()
						.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
						.and()
						.authorizeRequests()
							.antMatchers(HttpMethod.OPTIONS).permitAll()
							.antMatchers(HttpMethod.POST,"/api/client/inscription").anonymous()
							.antMatchers(HttpMethod.GET,"/api/auth").authenticated()
							.antMatchers("/api/commande").hasRole("CLIENT")
							.anyRequest().hasAnyRole("ADMIN")					
						.and()
						.httpBasic()
						.and()
						.build();

		// @formatter:on
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
