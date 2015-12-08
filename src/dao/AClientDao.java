package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Client;

public abstract class AClientDao implements IClientDao {

	protected Map<Integer, Client> clientList;
	
	public AClientDao() {
		
		clientList = new HashMap<>();
	}
	
	@Override
	public int countClient() throws SQLException {
		
		return clientList.size();
	}

	@Override
	public List<Client> getClients() {
		
		ArrayList<Client> clients = new ArrayList<Client>();
		
		for(Client client : clientList.values()) 
			clients.add(client);
		
		return clients;
	}

	@Override
	public List<Client> getByFullname(String familyName, String firstName) {
		
		ArrayList<Client> clients = new ArrayList<Client>();
		
		for(Client client : clientList.values()) {
			
			if(client.getFamilyName().equals(familyName) && client.getFirstName().equals(firstName))
				clients.add(client);				
		}
			
		return clients;
	}

	@Override
	public Client getById(int id) {
		
		return clientList.get(new Integer(id));
	}
	
	@Override
	public List<Client> getByName(String familyName) {
		
ArrayList<Client> clients = new ArrayList<Client>();
		
		for(Client client : clientList.values()) {
			
			if(client.getFamilyName().equals(familyName))
				clients.add(client);				
		}
		
		return clients;
		
	}
}
