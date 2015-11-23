package db;

import java.sql.SQLException;

public class TestDbManagement {

	public void testInstanceNull() {
		assert DbManagement.getInstance() != null;
	}
	
	public void testQueryNull() {
		try { 
			DbManagement.getInstance().connexion(null);
			assert false; 
		} catch(SQLException ex) {}
	}
	
}
