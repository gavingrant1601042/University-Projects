package controller;

//import java.sql.Connection;
//import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JOptionPane;

import model.Complaint;
import model.Payment;
import model.User;
import services.Crypto;



public class Connection {

	ResultSet rs;
	Connection conn;
	Statement st;
	String sql;

	public java.sql.Connection getConnection() throws Exception{
		try{
			String driver = "com.mysql.cj.jdbc.Driver"; 
			String url = "jdbc:mysql://localhost/micro_star";
			String username = "root";
			String password = "";
			Class.forName(driver);


			java.sql.Connection conn = DriverManager.getConnection(url, username, password); 
			return conn;
		} catch(Exception e){

			//				  System.out.println(e);
			JOptionPane.showMessageDialog(null,"Server Connection Failed","Message", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();

		}

		return null;
	}
	
	
	
	public ResultSet GetAllComplaints() {
		ResultSet rs=null;
		try {
			
			java.sql.Connection con = getConnection();
			String query = "select complaint_id, customer_id, representative_id, type, description, cost, due_date FROM complaints";
			PreparedStatement pst = con.prepareStatement(query);
			rs =pst.executeQuery();
			
 
				return rs; 
			
			
		}catch(Exception e4) {
			e4.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet GetCustomerComplaints(String id) {
		ResultSet rs=null;
		try {
			
			java.sql.Connection con = getConnection();
			String query = "select complaint_id, customer_id, type, cost FROM complaints "
					+ "WHERE customer_id =?"
					+ "AND status = false";
			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, id); 
			rs =pst.executeQuery();
			
//			pst.getFetchSize();
//			System.out.println(rs.getFetchSize()=);
			
//			if(rs.next() == false) {
//				return null;
//				
//			}else {
				return rs;
//			}
			
			
		}catch(Exception e4) {
			e4.printStackTrace();
		}
		
		return rs;
	}


	public boolean LoginAuthentification(User user) {

		boolean passwordMatch=false;
		boolean IDMatch=false; 


		try {
			java.sql.Connection con=   getConnection();
			Statement st = con.createStatement(); 
			String sql=("SELECT * FROM users WHERE id = ?;");

			PreparedStatement pst =con.prepareStatement(sql);
			pst.setString(1, user.getId());

			rs=  pst.executeQuery();
			while (rs.next()) {

				if (user.getId().equals(rs.getString("id"))) {
					IDMatch=true;

					if(user.getPassword().equals(new String(Crypto.Decrypt(rs.getString("password").getBytes())))) {
						passwordMatch=true;


						if(!user.getType().equals(rs.getString("user_type"))) {
							JOptionPane.showMessageDialog(null,"User type does not match!!\nCannot login as a "+user.getType(),"Error Occured", JOptionPane.ERROR_MESSAGE);

							return false;
						}else {
//							JOptionPane.showMessageDialog(null, "Login Successful");
							break;	
						}

					}
				} 

			}

			if(!IDMatch && !passwordMatch) {
				JOptionPane.showMessageDialog(null, "Incorrect User ID and Password!", "Error", JOptionPane.ERROR_MESSAGE);
			}else {

				if(!IDMatch)
				{
					JOptionPane.showMessageDialog(null, "Incorrect User ID!", "Error", JOptionPane.ERROR_MESSAGE);
				}

				if(!passwordMatch)
				{
					JOptionPane.showMessageDialog(null, "Incorrect Password!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}



		} catch(Exception e){
			System.out.println(e);

		}

		return passwordMatch;

	}

	public boolean AddUser(User user )  {


		try{

			java.sql.Connection con=   getConnection();
			//			Statement st = con.createStatement(); 
			PreparedStatement pst = null;
			String sql="";
			//			ResultSet rs = null;

			sql = "INSERT INTO users"
					+"(first_name,last_name,email,contact_number,user_type,password)"
					+"VALUES (?,?,?,?,?,?)";
			con = DriverManager.getConnection("jdbc:mysql://localhost/micro_star","root","");
			pst = con.prepareStatement(sql);
			pst.setString(1,user.getFirstName());
			pst.setString(2,user.getLastName());
			pst.setString(3,user.getEmail());
			pst.setString(4,user.getMobile());
			pst.setString(5,user.getType());
			pst.setString(6,new String(Crypto.Encrypt(user.getPassword().getBytes()))); 
			pst.executeUpdate();

			//					User user1=this.);

			if(user.getType()=="Customer") {
				sql = "INSERT INTO addresses"
						+"(customer_id, address1, address2,	parish)"
						+"VALUES (?,?,?,?)"; 
				pst = con.prepareStatement(sql);
				pst.setString(1,GetUserRecord(user.getEmail()));
				pst.setString(2,user.getAddress().getAddress1());
				pst.setString(3,user.getAddress().getAddress2());
				pst.setString(4,user.getAddress().getParish());  
				pst.executeUpdate();
			}

			con.close();

			JOptionPane.showMessageDialog(null, "Registration Successful");

			return true;
		} catch(Exception e){

			JOptionPane.showMessageDialog(null," Connection Failed","Message", JOptionPane.ERROR_MESSAGE);
			System.out.println(e);

		}

		return false;
	}


	public String GetUserRecord(String email) {

		User user = new User();


		try {
			java.sql.Connection con=   getConnection();
			Statement st = con.createStatement(); 
			String sql=("SELECT * FROM users WHERE email = ?;");

			PreparedStatement pst =con.prepareStatement(sql);
			pst.setString(1,email);

			rs=  pst.executeQuery();
			while (rs.next()) {

				if (email.equals(rs.getString("email"))) {

					//					user.setEmail(email);
					//					user.setId(); 



					return rs.getString("id");


				} 

			}
		} catch(Exception e){

			JOptionPane.showMessageDialog(null," Connection Failed","Message", JOptionPane.ERROR_MESSAGE);
			System.out.println(e);

		}




		return null;


	}


	public User GetUserRecordWithId(String Id) {

		User user = new User();


		try {
			java.sql.Connection con=   getConnection();
			Statement st = con.createStatement(); 
			String sql=("SELECT * FROM users WHERE id = ?;");

			PreparedStatement pst =con.prepareStatement(sql);
			pst.setString(1,Id);

			rs=  pst.executeQuery();
			while (rs.next()) {

				if (Id.equals(rs.getString("id"))) {

					user.setEmail(rs.getString("email"));
					user.setId(rs.getString("id")); 
					user.setFirstName(rs.getString("first_name")); 
					user.setLastName(rs.getString("last_name")); 
					user.setType(rs.getString("user_type")); 


					return user;


				} 

			}
		} catch(Exception e){

			JOptionPane.showMessageDialog(null," Connection Failed","Message", JOptionPane.ERROR_MESSAGE);
			System.out.println(e);

		}




		return null;


	}

	
	public boolean GetComplaint(String Id) {

//		User user = new User();


		try {
			java.sql.Connection con=   getConnection();
			Statement st = con.createStatement(); 
			String sql=("SELECT * FROM complaints WHERE complaint_id = ?;");

			PreparedStatement pst =con.prepareStatement(sql);
			pst.setString(1,Id);

			rs=  pst.executeQuery();
			while (rs.next()) {

//				if (Id.equals(rs.getString("id"))) {
//
//					user.setEmail(rs.getString("email"));
//					user.setId(rs.getString("id")); 
//					user.setFirstName(rs.getString("first_name")); 
//					user.setLastName(rs.getString("last_name")); 
//					user.setType(rs.getString("user_type")); 


					return true;


//				} 

			}
		} catch(Exception e){

			JOptionPane.showMessageDialog(null," Connection Failed","Message", JOptionPane.ERROR_MESSAGE);
			System.out.println(e);

		}




		return false;


	}

	
	public boolean MakePayment(Payment pay) {

//		User user = new User();


		try {
			java.sql.Connection con= getConnection();
			//		Statement st = con.createStatement(); 
			PreparedStatement pst = null;
			String sql="";
			//		ResultSet rs = null;


		
			
//			sql = "UPDATE complaints SET status = true WHERE complaint_id= ?";
			con = DriverManager.getConnection("jdbc:mysql://localhost/micro_star","root","");
//			pst = con.prepareStatement(sql);
//			pst.setInt(1, Integer.valueOf(pay.getAmount()));
//			pst.setString(1, pay.getComplaint_id());  
//			pst.executeUpdate();
			 
			Statement st = con.createStatement(); 
			 sql=("SELECT * FROM complaints WHERE complaint_id = "+pay.getComplaint_id());
 
			
			rs=  st.executeQuery(sql);

			if(rs != null) 
				while (rs.next()) {
  
					if(Float.parseFloat(pay.getAmount())>=rs.getFloat("cost")) {
						sql = "UPDATE complaints SET status = true WHERE complaint_id= ?";
						con = DriverManager.getConnection("jdbc:mysql://localhost/micro_star","root","");
						pst = con.prepareStatement(sql);
//						pst.setInt(1, Integer.valueOf(pay.getAmount()));
						pst.setString(1, pay.getComplaint_id());  
						pst.executeUpdate();
						 
					} 
				}
			
//			sql = "UPDATE complaints SET cost = 0 WHERE cost < 0"; 
//			pst = con.prepareStatement(sql); 
//			pst.executeUpdate();
			
			
//			representative_id 
//			complaint_id
//			customer_id
			
			sql = "INSERT INTO payments " 
					+"(representative_id, complaint_id,customer_id, amount) "
					+"VALUES (?,?,?,?)";
			con = DriverManager.getConnection("jdbc:mysql://localhost/micro_star","root","");
			pst = con.prepareStatement(sql);
			pst.setString(1, pay.getRepresentative_id());
			pst.setString(2, pay.getComplaint_id()); 
			pst.setString(3, pay.getCustomer_id()); 
			pst.setString(4, pay.getAmount()); 
			pst.executeUpdate();
			

			JOptionPane.showMessageDialog(null, "Payment was made Successfully \n");
			
			return true;
		} catch(Exception e){

			JOptionPane.showMessageDialog(null," Connection Failed","Message", JOptionPane.ERROR_MESSAGE);
			System.out.println(e);

		}




		return false;


	}

	
	public String GetLastComplaint() {

		User user = new User();


		try {
			java.sql.Connection con=   getConnection();
			Statement st = con.createStatement(); 
			String sql=("SELECT * FROM complaints" 
					+ "   ORDER BY complaint_id DESC"
					+ "   LIMIT 1; ");
 
			

			rs=  st.executeQuery(sql);

			if(rs != null) 
				while (rs.next()) {
 
					return rs.getString("complaint_id");


				}
		} catch(Exception e){

			JOptionPane.showMessageDialog(null,"Connection Failed","Message", JOptionPane.ERROR_MESSAGE);
			System.out.println(e);

		}




		return null;


	}


	public  boolean AddComplaint(Complaint complaint) { 


		try{

			java.sql.Connection con=   getConnection();
			//		Statement st = con.createStatement(); 
			PreparedStatement pst = null;
			String sql="";
			//		ResultSet rs = null;

			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance(); 
			cal.add(Calendar.MONTH, 1);  

			sql = "INSERT INTO complaints " 
					+"(customer_id,	representative_id, type, description, cost, due_date)"
					+" VALUES (?,?,?,?,?,?)";
			con = DriverManager.getConnection("jdbc:mysql://localhost/micro_star","root","");
			pst = con.prepareStatement(sql);
			pst.setString(1, complaint.getCustomer_id());
			pst.setString(2, complaint.getRepresentative_id()); 
			pst.setString(3, complaint.getType());
			pst.setString(4, complaint.getDescription());
			pst.setString(5, complaint.getCost()); 
			pst.setString(6, dateFormat.format(cal.getTime()).toString()); 
			
//			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//			Calendar cal = Calendar.getInstance();
//			System.out.println(dateFormat.format(cal.getTime()));
			pst.executeUpdate();
			
			

			if(!complaint.getResponse().getTechnician_id().isEmpty() || complaint.getResponse().getTechnician_id().length()!=0) {
				sql = "INSERT INTO responses "
						+"(technician_id, customer_id, complaint_id)"
						+"VALUES (?,?, ?)";
				con = DriverManager.getConnection("jdbc:mysql://localhost/micro_star","root","");
				pst = con.prepareStatement(sql);
				pst.setString(1, complaint.getResponse().getTechnician_id());
				pst.setString(2, complaint.getCustomer_id()); 
				pst.setString(3, GetLastComplaint());
				pst.executeUpdate();

			}





			con.close();

			JOptionPane.showMessageDialog(null, "Complaint was Logged Successfully");

			return true;
		} catch(Exception e){

			JOptionPane.showMessageDialog(null," Connection Failed","Message", JOptionPane.ERROR_MESSAGE);
			System.out.println(e);

		}

		return false;
	}



	public ResultSet GetAllPayments() {
		ResultSet rs=null;
		try {
			
			
			
			java.sql.Connection con = getConnection();
			String query = "select payment_id, customer_id, representative_id, complaint_id, amount FROM payments";
			PreparedStatement pst = con.prepareStatement(query);
			rs =pst.executeQuery();
			
 
				return rs; 
			
			
		}catch(Exception e4) {
			e4.printStackTrace();
		}
		
		return rs;
	}


}
