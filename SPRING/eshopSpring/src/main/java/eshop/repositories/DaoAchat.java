package eshop.repositories;

import eshop.entities.Achat;
import eshop.entities.AchatKey;
import eshop.entities.Commande;

public interface DaoAchat extends DaoGeneric<Achat, AchatKey> {
	public void deleteByCommande(Commande commande);
}
