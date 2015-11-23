package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManagement {

	public static void initDBDrivers(){
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e){
				System.err.println("Impossible de charger le driver " + e.getMessage ());
				System.exit (-1) ; // ou throw new RuntimeException("Impossible de charger le driver"); dans le cas d’un développement web
		}
	}
	
	public static void main(String[] args) {
		
		
		initDBDrivers();
		
		final String NomBase = "jdbc:mysql://localhost/si";
		final String User = "si";
		final String Password = "Password1234";
		Connection conn;
		try {
			conn = DriverManager.getConnection(NomBase, User, Password);
			if (conn == null) {
				System.out.println("Could not connect !!");
				return;
			}
			
			System.out.println("Connection : Success.");
			
		} catch (SQLException e) {
			System.err.println("Erreur de connexion " + e.getMessage ()) ;
		}
		
	}
	
	

}