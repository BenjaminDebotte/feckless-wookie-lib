package dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import model.Client;

public abstract class AClientDao implements IClientDao {

	protected HashMap<Integer, Client> clientList;
	
	public AClientDao() {
		
		clientList = new HashMap<>();
	}
	
	@Override
	public int countClient() throws SQLException {
		
		
		
		return 0;
	}

	@Override
	public List<Client> getClients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> getByFullname(String nom, String prenom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
