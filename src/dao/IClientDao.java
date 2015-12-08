package dao;

import java.sql.SQLException;
import java.util.List;

import model.Client;

public interface IClientDao {

	public int countClient() throws SQLException;
	public List<Client> getClients();
	public List<Client> getByName(String familyName);
	public List<Client> getByFullname(String nom, String prenom);
	public Client getById(int id);
}
