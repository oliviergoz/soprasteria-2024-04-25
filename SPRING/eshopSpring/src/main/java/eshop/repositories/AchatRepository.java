package eshop.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eshop.entities.Achat;
import eshop.entities.AchatKey;
import eshop.entities.Commande;
import eshop.entities.Produit;

public interface AchatRepository extends JpaRepository<Achat, AchatKey> {
	@Transactional
	@Modifying
	public void deleteByIdCommande(Commande commande);

	@Query("update Achat a set a.id.produit=null where a.id.produit=:produit")
	@Transactional
	@Modifying
	public void setProduitToNull(@Param("produit") Produit produit);
}
