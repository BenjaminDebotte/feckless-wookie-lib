package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import db.DbManagement;
import model.Client;

public class DbClientDao extends AClientDao {

	
	public DbClientDao() throws SQLException {
		refreshData();
	}
	
	public void refreshData() throws SQLException {
		// On récupère tous les clients, et on les stocke dans une hashmap
		
		ResultSet result = DbManagement.getInstance().query("SELECT * FROM tabClient");
		
		while(result.next()) {
			int id = result.getInt("idNumClient");
			Client client = new Client(id, result.getString("txtNomCli"), result.getString("txtPrenomCli"));
			clientList.put(id, client);
		}
	}

}
