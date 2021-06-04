package services;

import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;


import controller.Connection;
import model.Complaint;
import model.Payment;
import model.User;


public class Validation {
	Connection connect = new Connection();

	public boolean Login(User user) {
		//		String userEmail, String password, String userType




		//		 System.out.println(userType);
		//		 System.out.println(userEmail);
		if(user.getType().isEmpty() || user.getType().length()==0 || user.getType().equals("Select User Type") ){
			required("Login Type");
			return false;
		}


		if(user.getId().isEmpty() || user.getId().length()==0){
			required("User ID");
			return false;
		}else{ 
			try{				

				Integer.parseInt(user.getId());
			}catch(NumberFormatException e2){
				JOptionPane.showMessageDialog(null,"Invalid User ID!\n","Error Occured", JOptionPane.ERROR_MESSAGE);
				return false;
			} 
		}



		if(user.getPassword().isEmpty() || user.getPassword().length()==0  ){
			required("Password");
			return false;
		}








		return connect.LoginAuthentification(user);
	}



	public boolean UserRegistration(User user) {


		if(user.getType().equals("Select User Type")){
			required("User Type");
			return false;
		}

		if(user.getFirstName().isEmpty() || user.getFirstName().length()==0){
			required("First Name");
			return false;
		}

		if(user.getLastName().isEmpty() || user.getLastName().length()==0){
			required("Last Name");
			return false;
		}


		if(user.getMobile().isEmpty() || user.getMobile().length()==0){
			required("Mobile");
			return false;
		}else {

			//				 try{
			//					 Integer.parseInt(user.getMobile());
			//				}catch(NumberFormatException e2){
			//						JOptionPane.showMessageDialog(null,"Please use only digits for mobile!\n","Error Occured", JOptionPane.ERROR_MESSAGE);
			//						return false;
			//				}

			if(user.getMobile().length()<7 || user.getMobile().length()>10) {
				JOptionPane.showMessageDialog(null,"Invalid Mobile Number!\n","Error Occured", JOptionPane.ERROR_MESSAGE);
				return false;
			}
				
			try{
				Integer.parseInt(user.getMobile());
			}catch(NumberFormatException e2){
				invalidInput("Mobile"); 
				return false;
			}
				
				 
			
			
		}



		if(user.getEmail().isEmpty() || user.getEmail().length()==0){
			required("Email");
			return false;
		}else {


			Matcher matcher = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE).matcher(user.getEmail());
			if(!matcher.find()) {

				JOptionPane.showMessageDialog(null, "Incorrect Email Format\n","Error Occured", JOptionPane.ERROR_MESSAGE);

				return false;
			}


		}
		
		if(user.getType().equals("Customer")) {

			if(user.getAddress().getAddress1().isEmpty() || user.getAddress().getAddress1().length()==0 ){
				required("Address 1"); 
				return false;
			}
			
			if(user.getAddress().getAddress2().isEmpty() || user.getAddress().getAddress2().length()==0 ){
				required("Address 2"); 
				return false;
			}
			
			if(user.getAddress().getParish().equals("Select Parish")){
				required("Parish"); 
				return false;
			}
		}


		return connect.AddUser(user);

		//		return true;
	}

	public boolean Complaint(Complaint complaint, String cusomerName, String tecnicianName) {

		
		if(complaint.getCustomer_id().isEmpty() || complaint.getCustomer_id().length()==0   ){
			required("Customer Id"); 
			return false;
		}else {
			
			 try{
				 Integer.parseInt(complaint.getCustomer_id());
			}catch(NumberFormatException e2){
				invalidInput("Customer Id"); 
					return false;
			}
			
			 
		}

		if(cusomerName.isEmpty() || cusomerName.equals("Customer Not Found")   ){ 
			JOptionPane.showMessageDialog(null, "Customer record not found\n","Error Occured", JOptionPane.ERROR_MESSAGE);
			return false;
		}


		if(complaint.getType().equals("Select Complaint") ){
			required("Complaint type"); 
			return false;
		}

		if(complaint.getCost().isEmpty() || complaint.getCost().length()==0 ){
			required("Cost"); 
			return false;
		}else {
			
			 try{
				 Integer.parseInt(complaint.getCost());
			}catch(NumberFormatException e2){
				invalidInput("Cost"); 
					return false;
			}
			
			 
		}
		


		if(complaint.getDescription().isEmpty() || complaint.getDescription().length()==0 ){
			required("Description"); 
			return false;
		}

		
		if(tecnicianName.isEmpty() || tecnicianName.equals("Technician Not Found")   ){ 

			if (JOptionPane.showConfirmDialog(null, "Are you sure you want to log this complaint without an assigned technician?", "WARNING",
					JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
				return false;
			}
		} 
		
		return connect.AddComplaint(complaint);

	}

public boolean Payment(Payment pay) {
		
		if(pay.getCustomer_id().isEmpty() || pay.getCustomer_id().length()==0) {
			required("Customer Id");
			return false;
		}else {
			
			 try{
				 Integer.parseInt(pay.getCustomer_id());
			}catch(NumberFormatException e2){
				invalidInput("Customer Id"); 
					return false;
			}
			
			 
		}
		
		try {
			if(connect.GetCustomerComplaints( pay.getCustomer_id()).next()==false) {
				JOptionPane.showMessageDialog(null, "No outstanding balance for customer "+ pay.getCustomer_id(),"Error Occured", JOptionPane.ERROR_MESSAGE);
				
				return false;
			}
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(pay.getComplaint_id().isEmpty() || pay.getComplaint_id().length()==0) {
			required("Complaint Id");
		
			return false;
		}else {
			
			 try{
				 Integer.parseInt(pay.getComplaint_id());
			}catch(NumberFormatException e2){
				invalidInput("Complaint Id"); 
					return false;
			}
			
			 
		}
		
		if(!connect.GetComplaint(pay.getComplaint_id())) {
			JOptionPane.showMessageDialog(null, "No record of Complaint Id "+pay.getComplaint_id()+"\n","Error Occured", JOptionPane.ERROR_MESSAGE);
		
			return false;
		}
		
		
		
		if(pay.getAmount().isEmpty() || pay.getAmount().length()==0 ) {
			required("Amount");
			return false;
		}else {
			
			 try{
				 Integer.parseInt(pay.getAmount());
			}catch(NumberFormatException e2){
				invalidInput("Amount"); 
					return false;
			}
			 
			 if( Integer.parseInt(pay.getAmount())<1) {
				 JOptionPane.showMessageDialog(null, "Amount must be greater than 0\n","Error Occured", JOptionPane.ERROR_MESSAGE);

				 return false;
			 }
			
			 
		}
		
		
		
		
	 
		
		return connect.MakePayment(pay);
	}


	public void invalidInput(String input) {
		JOptionPane.showMessageDialog(null, "Invalid "+input+"\n","Error Occured", JOptionPane.ERROR_MESSAGE);
	
	}
	private void required(String input) {
		JOptionPane.showMessageDialog(null, input+" is Required\n","Error Occured", JOptionPane.ERROR_MESSAGE);

	}



	




}
