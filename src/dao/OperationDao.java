package dao;

import java.sql.SQLException;
import java.util.List;

import model.Operation;
import model.Resultat;

public class OperationDao implements IOperationDao {

	private static OperationDao instance;
	private IOperationDao delegate;
	
	private OperationDao(){
		
	};
	
	public static OperationDao getInstance() {
		
		if(instance == null)
			instance = new OperationDao();
		
		return instance;
	}
	
	public void setDelegate(IOperationDao delegate) {
		
		this.delegate = delegate;
	}
	
	public boolean isDelegated() {
		
		return !(delegate == null);
	}
	
	@Override
	public List<Operation> getById(int id) throws SQLException {
		
		return delegate.getById(id);
	}

	@Override
	public Resultat getByName(String familyName) throws SQLException {
		
		return delegate.getByName(familyName);
	}

	@Override
	public Resultat getByFullName(String familyName, String firstName) throws SQLException {
		
		return delegate.getByFullName(familyName, firstName);
	}

}
