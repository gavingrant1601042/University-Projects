package model;

public class Complaint { 
	String customer_id;
	String representative_id; 
	String description;
	String cost;
	String type;
	Response response;
	
	
	
	public Complaint( ) {
		super(); 
		this.customer_id = "";
		this.type = "";
		this.representative_id = ""; 
		this.description = "";
		this.cost = "";
		this.response = new Response();
	}
	
	public Complaint(String complaint_id, String customer_id, String representative_id, String response_id,
			String description, String cost, String type, Response response) {
		super(); 
		this.customer_id = customer_id;
		this.representative_id = representative_id; 
		this.description = description;
		this.cost = cost;
		this.type = type;
		this.response=response;
	}

	 

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getRepresentative_id() {
		return representative_id;
	}

	public void setRepresentative_id(String representative_id) {
		this.representative_id = representative_id;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}
	
	

}
