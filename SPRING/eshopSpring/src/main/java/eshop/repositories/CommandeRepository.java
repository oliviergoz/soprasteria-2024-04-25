package eshop.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eshop.entities.Client;
import eshop.entities.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
	@Query("update Commande c set c.client=null where c.client=:client")
	@Transactional
	@Modifying
	void setClientToNullByClient(@Param("client") Client client);

	@Transactional
	@Modifying
	void deleteByClient(Client client);
}
