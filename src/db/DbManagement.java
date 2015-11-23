package db;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DbManagement implements IDbManagement {

	private DbManagement instance = null;
	private IDbManagement delegate = null;
	
	
	public DbManagement getInstance() {
		if(instance == null)
			instance = new DbManagement();
		return instance;
	}
	
	public void setDelegate(IDbManagement delegate) {
		this.delegate = delegate;
	}

	@Override
	public void connexion(String bdd_path) throws SQLException {
		this.delegate.connexion(bdd_path);
	}

	@Override
	public void deconnexion() {
		this.delegate.deconnexion();
		
	}

	@Override
	public ResultSet query(String query) throws SQLException {
		return this.delegate.query(query);
	}

}