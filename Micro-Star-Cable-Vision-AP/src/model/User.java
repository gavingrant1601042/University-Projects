package model;

public class User {
   private String id;
   private String firstName;
   private String lastName;
   private String email;
   private String mobile;
   private String type;
   private String password;
   private Address address;

  public User() {
		super();
		this.id = "";
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.mobile = "";
		this.type = "";
		this.password = "";
		this.address= new Address();
	}   
   
public User(String id, String firstName, String lastName, String email, String mobile, String type,String password, Address address) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.mobile = mobile;
	this.type =  type;
	this.password = password;
	this.address = address;
}


public String getId() {
	return id;
}


public void setId(String id) {
	this.id = id;
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


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getMobile() {
	return mobile;
}


public void setMobile(String mobile) {
	this.mobile = mobile;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public Address getAddress() {
	return address;
}

public void setAddress(Address address) {
	this.address = address;
} 




   
   
   
   
}
