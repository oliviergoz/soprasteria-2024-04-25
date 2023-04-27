package formationJpa.repositories;

import java.util.List;

import formationJpa.entities.Client;
import formationJpa.entities.Fournisseur;
import formationJpa.entities.Personne;

public interface DaoPersonne extends DaoGeneric<Personne, Long> {
	public List<Client> findAllClient();
	public List<Fournisseur> findAllFournisseur();
}
