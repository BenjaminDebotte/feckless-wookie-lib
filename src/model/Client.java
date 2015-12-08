package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Client {

	private int id;
    private String familyName;
    private String firstName;

    public Client(int id, String familyName, String firstName) {

        this.id = id;
        this.familyName = familyName;
        this.firstName = firstName;
    }

    public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFamilyName() {
		return familyName;
	}



	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	@Override
    public String toString() {
        return familyName + " " + firstName +
                ", client n° : " + id ;
    }
}
