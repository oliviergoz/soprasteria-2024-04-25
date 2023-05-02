package formationJpa.repositories;

import formationJpa.entities.Client;
import formationJpa.entities.Commande;

public interface DaoCommande extends DaoGeneric<Commande, Long> {
	public void setClientToNullByClient(Client client);

	public void deleteByClient(Client client);
}
