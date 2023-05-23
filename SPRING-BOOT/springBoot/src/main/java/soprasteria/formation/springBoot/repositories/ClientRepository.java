package soprasteria.formation.springBoot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import soprasteria.formation.springBoot.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
	Optional<Client> findByLogin(String login);
}
