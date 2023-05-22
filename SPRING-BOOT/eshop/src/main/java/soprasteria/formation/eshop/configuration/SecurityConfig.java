package soprasteria.formation.eshop.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
                .csrf(csrf->csrf.disable())
                .authorizeRequests(
                        requests ->
                                requests.antMatchers("/").permitAll()
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
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// @formatter:off
		auth.inMemoryAuthentication()
				.withUser("admin").password("{noop}admin").roles("ADMIN")
				.and()
				.withUser("client").password("{noop}client").roles("CLIENT");
				
		// @formatter:on

	}
}
