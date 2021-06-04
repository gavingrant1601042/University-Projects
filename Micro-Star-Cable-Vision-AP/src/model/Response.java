package model;

public class Response {
	String technician_id;
	String address1;
	String address2;
	String parish;
	
	
	
	
	public Response() {
		super();
		this.technician_id = "";
		this.address1 = "";
		this.address2 = "";
		this.parish = "";
	}
	
	
	public Response(String technician_id, String address1, String address2, String parish) {
		super();
		this.technician_id = technician_id;
		this.address1 = address1;
		this.address2 = address2;
		this.parish = parish;
	}
	
	public String getTechnician_id() {
		return technician_id;
	}
	public void setTechnician_id(String technician_id) {
		this.technician_id = technician_id;
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
