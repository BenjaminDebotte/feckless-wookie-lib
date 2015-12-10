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
		
		ResultSet result = DbManagement.getInstance().query("SELECT * FROM tabOperation WHERE idNumCompte = " + id);
		List<Operation> operationList = new ArrayList<>();
		Operation operation;
		while(result.next()) {
			
			operation = new Operation(result.getInt("idNumOperation"), result.getString("idNumCarte"), result.getString("idNumCompte"), result.getString("numMontantOpe"), result.getString("datOpe"));
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
			
			String queryString = "SELECT ope.* "+
					  "FROM tabOperation ope "+
					  "INNER JOIN relClientCompte cc ON cc.idNumCompte = ope.idNumCompte "+
					  "INNER JOIN tabClient cl ON cl.idNumClient = cc.idNumClient "+
					  "WHERE cl.idNumClient = '"+id+"' UNION "+
					  "SELECT ope.* "+
					  "FROM tabOperation ope "+
					  "INNER JOIN tabCarte ca ON ca.idNumCarte = ope.idNumCarte "+
					  "INNER JOIN tabClient cl ON cl.idNumClient = ca.idNumClient "+
					  "WHERE cl.idNumClient = '"+id+"'";
			result = DbManagement.getInstance().query(queryString);
			while(result.next()) {
				
				operations.add(new Operation(result.getInt("idNumOperation"), result.getString("idNumCarte"), result.getString("idNumCompte"), result.getString("numMontantOpe"), result.getString("datOpe")));
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
				
				operations.add(new Operation(result.getInt("idNumOperation"), result.getString("idNumCarte"), result.getString("idNumCompte"), result.getString("numMontantOpe"), result.getString("datOpe")));
			}
		}
		
		resultat = new Resultat(clients, operations);
		
		return resultat;
	}

}
