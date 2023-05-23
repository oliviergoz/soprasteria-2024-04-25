package soprasteria.formation.springBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private CompteService compteSrv;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// a partir du username=>remonter soit 1 admin, soit 1 client
		return compteSrv.getByLogin(username);
		// si on trouve pas throw new UsernameNotFoundException
	}

}
