package formationJpa.repositories;

import formationJpa.entities.Achat;
import formationJpa.entities.AchatKey;
import formationJpa.entities.Commande;

public interface DaoAchat extends DaoGeneric<Achat, AchatKey> {
	public void deleteByCommande(Commande commande);
}
