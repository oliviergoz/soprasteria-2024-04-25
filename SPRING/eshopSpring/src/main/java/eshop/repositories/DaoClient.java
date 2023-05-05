package eshop.repositories;

import java.util.List;

import eshop.entities.Client;

public interface DaoClient extends DaoGeneric<Client, Long> {
	public List<Client> findByNom(String nom);

	public List<Client> findByNomContaining(String nom);

	public List<Client> findByPrenomAndNom(String prenom, String nom);

	public List<Client> findByPrenomContainingAndNomContaining(String prenom, String nom);

	public long count();

	public Client findByKeyFetchCommandes(Long key);

	public Client findByKeyAndYearFetchCommandes(Long key, int year);

}
