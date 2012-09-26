package net.roseindia.form;

public class Account {
	private String firstName;
	private String lastName;
	private int type;
	
	public Account () {
		firstName = "";
		lastName = "";
		type = 0;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}
