package dao;

import java.util.List;

import model.Client;

public class ClientDao implements IClientDao {

	private static ClientDao instance;
	private IClientDao delegate;
	
	private ClientDao(){
		
	};
	
	public static ClientDao getInstance() {
		
		if(instance == null)
			instance = new ClientDao();
		
		return instance;
	}
	
	public void setDelegate(IClientDao delegate) {
		
		this.delegate = delegate;
	}
	
	public boolean isDelegated() {
		return !(delegate == null);
	}
	
	@Override
	public int countClient() {
		// TODO Auto-generated method stub
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
