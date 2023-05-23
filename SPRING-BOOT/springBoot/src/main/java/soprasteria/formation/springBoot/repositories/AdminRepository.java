package soprasteria.formation.springBoot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import soprasteria.formation.springBoot.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
	Optional<Admin> findByLogin(String login);
}
