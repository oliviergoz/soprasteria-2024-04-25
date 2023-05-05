package eshop.repositories;

import eshop.entities.Client;
import eshop.entities.Commande;

public interface DaoCommande extends DaoGeneric<Commande, Long> {
	public void setClientToNullByClient(Client client);

	public void deleteByClient(Client client);
}
