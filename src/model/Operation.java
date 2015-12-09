package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Operation {

	private int idOperation;
    private String idCard;
    private String idAccount;
    private String operationAmount;
    private String operationDate;

    public Operation(int idOperation, String idCard,  String idAccount, String operationAmount, String operationDate) {

        this.idOperation = idOperation;
        this.idCard = idCard;
        this.idAccount = idAccount;
        this.operationAmount = operationAmount;
        this.operationDate = operationDate;
    }
    
    public Operation() {

        this.idOperation = 1;
        this.idCard = "";
        this.idAccount = "";
        this.operationAmount = "";
        this.operationDate = "";
    }
    
    @XmlElement
    public int getIdOperation() {
		return idOperation;
	}


	public void setIdOperation(int idOperation) {
		this.idOperation = idOperation;
	}


	@XmlElement
	public String getIdCard() {
		return idCard;
	}


	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	@XmlElement
	public String getIdAccount() {
		return idAccount;
	}


	public void setIdAccount(String idAccount) {
		this.idAccount = idAccount;
	}

	@XmlElement
	public String getOperationAmount() {
		return operationAmount;
	}


	public void setOperationAmount(String operationAmount) {
		this.operationAmount = operationAmount;
	}

	@XmlElement
	public String getOperationDate() {
		return operationDate;
	}


	public void setOperationDate(String operationDate) {
		this.operationDate = operationDate;
	}


	@Override
    public String toString() {
        return "Opération n° " + idOperation +
                "\nCarte n° " + idCard +
                "\nCompte n° " + idAccount +
                " \nMontant : " + operationAmount +
                "€\nDate : " + operationDate;
    }
}
