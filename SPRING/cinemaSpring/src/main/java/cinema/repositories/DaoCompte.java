package cinema.repositories;

import java.util.List;

import cinema.entities.Admin;
import cinema.entities.Client;
import cinema.entities.Compte;

public interface DaoCompte extends DaoGeneric<Compte, Long> {
	public List<Client> findAllClient();

	public List<Admin> findAllAdmin();
}
