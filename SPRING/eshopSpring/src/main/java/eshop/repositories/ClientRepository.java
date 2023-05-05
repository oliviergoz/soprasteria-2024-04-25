package eshop.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eshop.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

	List<Client> findByNom(String nom);

	List<Client> findByNomContaining(String nom);

	List<Client> findByPrenomAndNom(String prenom, String nom);

	List<Client> findByPrenomContainingAndNomContaining(String prenom, String nom);

	@Query("select c from Client as c left join fetch c.commandes as cmd where c.id=:key")
	Optional<Client> findByIdFetchCommandes(@Param("key") Long id);

	@Query("select c from Client as c left join fetch c.commandes as cmd where c.id=:key and year(cmd.date)=:year")
	Optional<Client> findByIdAndYearFetchCommandes(@Param("key") Long id, @Param("year") int year);
}
