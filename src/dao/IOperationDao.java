package dao;

import java.sql.SQLException;
import java.util.List;

import model.Operation;
import model.Resultat;

public interface IOperationDao {

	public List<Operation> getById(int id) throws SQLException;
	public Resultat getByName(String familyName) throws SQLException;
	public Resultat getByFullName(String familyName, String firstName) throws SQLException;
}
