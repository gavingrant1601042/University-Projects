package model;

public class Payment {
	
String payment_id;
String customer_id;
String representative_id;
String complaint_id;
String amount;


public Payment() {
	super();
	this.payment_id = "";
	this.customer_id = "";
	this.representative_id = "";
	this.complaint_id = "";
	this.amount = "";
}


public Payment(String payment_id, String customer_id, String representative_id, String complaint_id, String amount) {
	super();
	this.payment_id = payment_id;
	this.customer_id = customer_id;
	this.representative_id = representative_id;
	this.complaint_id = complaint_id;
	this.amount = amount;
}


public String getPayment_id() {
	return payment_id;
}


public void setPayment_id(String payment_id) {
	this.payment_id = payment_id;
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


public String getComplaint_id() {
	return complaint_id;
}


public void setComplaint_id(String complaint_id) {
	this.complaint_id = complaint_id;
}


public String getAmount() {
	return amount;
}


public void setAmount(String amount) {
	this.amount = amount;
}





}
