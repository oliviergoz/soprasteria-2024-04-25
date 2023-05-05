package eshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import eshop.entities.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {

}
