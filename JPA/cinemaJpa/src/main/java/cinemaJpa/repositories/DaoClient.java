package cinemaJpa.repositories;

import java.util.List;

import cinemaJpa.entities.Client;

public interface DaoClient extends DaoGeneric<Client, Long> {
	public List<Client> findMajeur();

	public List<Client> findMineur();

	public List<Client> findSenior();

	public Client findByIdFetchReservations(Long id);

	public Client findByIdFetchEvaluations(Long id);

	public Client findByIdFetchReservationsAndEvaluations(Long id);

}
