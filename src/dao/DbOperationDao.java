package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import db.DbManagement;
import model.Client;
import model.Operation;
import model.Resultat;

public class DbOperationDao implements IOperationDao {

	public DbOperationDao() {
		
		
	}
	// idNumOperation, idNumCommercant, idNumGAB, idNumCarte, idNumCompte, idNumTypeOperation, datOpe, numMontantOpe
	
	// relClientCompte : idNumClient idNumCompte
	@Override
	public List<Operation> getById(int id) throws SQLException {
		
		ResultSet result = DbManagement.getInstance().query("SELECT * FROM tabOperation WHERE idNumOperation = " + id);
		List<Operation> operationList = new ArrayList<>();
		Operation operation;
		while(result.next()) {
			
			operation = new Operation(result.getInt("idNumOperation"), result.getString("idNumCarte"), result.getString("idNumCompte"), result.getString("numMontantOpe"), result.getString("dateope"));
			operationList.add(operation);
		}
		
		return operationList;
	}

	@Override
	public Resultat getByName(String familyName) throws SQLException {
		
		ResultSet result = null;
		Resultat resultat = null;
			
		List<Operation> operations = new ArrayList<>();
		List<Client> clients = ClientDao.getInstance().getByName(familyName);
		int id;
		Iterator<Client> clientIterator = clients.iterator();
		Client client;
		
		while(clientIterator.hasNext()) {
			
			client = clientIterator.next();
			id = client.getId();
			
			result = DbManagement.getInstance().query("SELECT * FROM tabOperation WHERE idNumClient = " + id);
			while(result.next()) {
				
				operations.add(new Operation(result.getInt("idNumOperation"), result.getString("idNumCarte"), result.getString("idNumCompte"), result.getString("numMontantOpe"), result.getString("dateOpe")));
			}
		}
		
		resultat = new Resultat(clients, operations);
		
		return resultat;
	}

	@Override
	public Resultat getByFullName(String familyName, String firstName) throws SQLException {
		
		ResultSet result = null;
		Resultat resultat = null;
			
		List<Operation> operations = new ArrayList<>();
		List<Client> clients = ClientDao.getInstance().getByFullname(familyName, firstName);
		int id;
		Iterator<Client> clientIterator = clients.iterator();
		Client client;
		
		while(clientIterator.hasNext()) {
			
			client = clientIterator.next();
			id = client.getId();
			
			result = DbManagement.getInstance().query("SELECT * FROM tabOperation WHERE idNumClient = " + id);
			while(result.next()) {
				
				operations.add(new Operation(result.getInt("idNumOperation"), result.getString("idNumCarte"), result.getString("idNumCompte"), result.getString("numMontantOpe"), result.getString("dateOpe")));
			}
		}
		
		resultat = new Resultat(clients, operations);
		
		return resultat;
	}

}
