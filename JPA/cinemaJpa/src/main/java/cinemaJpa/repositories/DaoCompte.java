package cinemaJpa.repositories;

import java.util.List;

import cinemaJpa.entities.Admin;
import cinemaJpa.entities.Client;
import cinemaJpa.entities.Compte;

public interface DaoCompte extends DaoGeneric<Compte, Long> {
	public List<Client> findAllClient();

	public List<Admin> findAllAdmin();
}
