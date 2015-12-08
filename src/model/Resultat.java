package model;

import java.util.List;

public class Resultat {

	private List<Client> clientList;
	private List<Operation> operationList;
	
	public Resultat(List<Client> clientList, List<Operation> operationList) {
		
		this.clientList = clientList;
		this.operationList = operationList;
	}

	public List<Client> getClientList() {
		return clientList;
	}

	public void setClientList(List<Client> clientList) {
		this.clientList = clientList;
	}

	public List<Operation> getOperationList() {
		return operationList;
	}

	public void setOperationList(List<Operation> operationList) {
		this.operationList = operationList;
	}
}
