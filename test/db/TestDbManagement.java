package db;

import java.sql.SQLException;

public class TestDbManagement {

	static public void testInstanceNull() {
		assert DbManagement.getInstance() != null;
	}
	
	static public void testQueryNull() {
		try { 
			DbManagement.getInstance().connexion(null);
			assert false; 
		} catch(NullPointerException ex) {}
		catch(SQLException ex) {
			assert false;
		}
	}
	
	/* Need of having a class implementing IDbManagement to test. */
	/*static public void testConnectionFail() {
		try { 
			DbManagement.getInstance().connexion("jdbc://localhost/si/NOPENOPENOPE");
			assert false; 
		} catch(SQLException ex) {
		}
	}*/
	
	static public void testDisconnect() {
		try {
			DbManagement.getInstance().deconnexion();
		} catch(Exception ex) {
			assert false;
		}
		
	}
	
	
	static public void testAll() {
		testInstanceNull();
		testQueryNull();
		testDisconnect();
		
		System.out.println(TestDbManagement.class.getName() + " - test ok");
	}
	
	
}
