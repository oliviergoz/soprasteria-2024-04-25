package eshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import eshop.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
