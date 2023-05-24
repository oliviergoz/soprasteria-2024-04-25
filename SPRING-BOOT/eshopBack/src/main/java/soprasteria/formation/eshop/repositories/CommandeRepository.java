package soprasteria.formation.eshop.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import soprasteria.formation.eshop.entities.Client;
import soprasteria.formation.eshop.entities.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
	@Query("update Commande c set c.client=null where c.client=:client")
	@Transactional
	@Modifying
	void setClientToNullByClient(@Param("client") Client client);

	@Transactional
	@Modifying
	void deleteByClient(Client client);

	@Query("select c from Commande c left join fetch c.achats where c.numero=:numero")
	Optional<Commande> findByIdFetchAchats(@Param("numero") Long numero);
}
