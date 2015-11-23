package dao;

import java.util.List;

import model.Client;

public interface IClientDao {

	public int countClient();
	public List<Client> getClients();
	public List<Client> getByFullname(String nom, String prenom);
	public Client getById(int id);
}
