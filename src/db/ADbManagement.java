package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.MissingResourceException;

public abstract class ADbManagement implements IDbManagement {

	private Connection conn = null;
	
	private static void initDBDrivers() throws MissingResourceException {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e){
			System.err.println("Impossible de charger le driver " + e.getMessage ());
			throw new MissingResourceException("Impossible de charger le driver", "com.mysql.jdbc.Driver", null);
		}
	}
	
	@Override
	public void connexion(String bdd_path) throws SQLException, MissingResourceException {
		
		initDBDrivers();
		
		//final String NomBase = "jdbc:mysql://localhost/si";
		//final String User = "si";
		//final String Password = "Password1234";
		
		conn = DriverManager.getConnection(bdd_path);
	}

	@Override
	public void deconnexion() {  
		if(conn == null)
			return;
		
		try {
			conn.rollback();
			conn.close();

		} catch (SQLException e) {}
	}

	@Override
	public ResultSet query(String query) throws SQLException {
		if(conn == null)
			throw new SQLException("Connection not established.");
		if(conn.isClosed())
			throw new SQLException("Connection not established.");
		
		Statement stmt = (Statement) conn.createStatement();
		
		return stmt.executeQuery(query);
	}

}
