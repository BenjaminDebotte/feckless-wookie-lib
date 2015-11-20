package model;

import java.util.ArrayList;

public class Resultat {

	private ArrayList<Client> clientList;
	private ArrayList<Operation> operationList;
	
	public Resultat(ArrayList<Client> clientList, ArrayList<Operation> operationList) {
		
		this.clientList = clientList;
		this.operationList = operationList;
	}

	public ArrayList<Client> getClientList() {
		return clientList;
	}

	public void setClientList(ArrayList<Client> clientList) {
		this.clientList = clientList;
	}

	public ArrayList<Operation> getOperationList() {
		return operationList;
	}

	public void setOperationList(ArrayList<Operation> operationList) {
		this.operationList = operationList;
	}
}
