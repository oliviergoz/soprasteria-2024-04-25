package eshop.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import eshop.entities.Achat;
import eshop.entities.AchatKey;
import eshop.entities.Commande;

public interface AchatRepository extends JpaRepository<Achat, AchatKey>{
	@Transactional
	@Modifying
	public void deleteByIdCommande(Commande commande);
}
