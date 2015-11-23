package db;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDbManagement {
	public void connexion(String bdd_path) throws SQLException;
	public void deconnexion();
	public ResultSet query(String query) throws SQLException;
}
