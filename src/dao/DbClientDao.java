package dao;

import java.util.List;

import db.DbManagement;
import model.Client;

public class DbClientDao extends AClientDao {

	public DbClientDao() {
		
		DbManagement dbManagement;
	}
	
	@Override
	public int countClient() {
		
		
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
