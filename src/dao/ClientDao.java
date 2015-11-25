package dao;

import java.sql.SQLException;
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
	public int countClient() throws SQLException {
	
		return delegate.countClient();
	}

	@Override
	public List<Client> getClients() {
		
		return delegate.getClients();
	}

	@Override
	public List<Client> getByFullname(String familyName, String firstName) {
		
		return delegate.getByFullname(familyName, firstName);
	}

	@Override
	public Client getById(int id) {
		
		return delegate.getById(id);
	}

}
