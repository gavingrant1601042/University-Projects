package model;

public class Address {
	String address1;
	String address2;
	String parish;
	
	
	public Address() {
		super(); 
		this.address1 = "";
		this.address2 = "";
		this.parish = "";
	}
	
	
	public Address(String address1, String address2, String parish) {
		super();
		this.address1 = address1;
		this.address2 = address2;
		this.parish = parish;
	}


	public String getAddress1() {
		return address1;
	}


	public void setAddress1(String address1) {
		this.address1 = address1;
	}


	public String getAddress2() {
		return address2;
	}


	public void setAddress2(String address2) {
		this.address2 = address2;
	}


	public String getParish() {
		return parish;
	}


	public void setParish(String parish) {
		this.parish = parish;
	}
	
	
	
	
	
	
}
