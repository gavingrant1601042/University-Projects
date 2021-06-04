
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.Connection;
import model.Complaint;
import model.Payment;
import model.User;
import net.proteanit.sql.DbUtils;
import services.Crypto;
import services.Validation;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Calendar;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Choice;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import javax.swing.border.LineBorder;

import java.awt.Cursor;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Button;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;


public class Main {

	private JFrame frmMscv;
	private DefaultTableModel dtm ;
	private JButton mainBtnDashboard;
	private JButton PaymentBtn;
	private JButton complainBtn;
	private JButton respondBtn;
	private JButton assignBtn;
	private JPanel assignPanel;
	private JPanel respondPanel;
	private JPanel complaintsPanel;
	private JPanel paymentPanel;
	private JPanel dashboardPanel;
	private JLabel mainLabel;
	private JTextField userID;
	private JTextField password;
	private JPanel loginPanel;
	private JPanel representativePanel;
	private JPanel customerPanel;
	private JPanel technicianPanel;
	private JPanel registerPanel;
	private JTextField regEmail;
	private JTextField regPassword;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_2_2;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_3_2;
	private JLabel lblNewLabel_3_1_2;
	private JLabel lblNewLabel_3_1_1_2;
	private JTextField regFirstName;
	private JTextField regLastName;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_3_3;
	private JLabel lblNewLabel_3_4;
	private JTextField regMobile;
	private JButton btnLogin;
	private JLabel timeAndDate;
	String pass;

	String[] users = { "Select User Type","Customer", "Representative", "Technician" };
	String[] cableComplaints = { "Select Complaint","Stations out of service", "Limit Reached", "No Signal" };
	String[] parishList = { "Select Parish","Kingston", "St. Andrew", "St. Catherine", "Clarendon", "Manchester", "St. Elizabeth", "Westmoreland", "Hanover",  "St. James", "Trelawny", "St. Ann", "St. Mary", "Portland", "St. Thomas"};
	private JComboBox loginType;
	Validation validate = new Validation();
	Connection connect = new Connection();
	Complaint complaint = new Complaint();
	User user = new User();
	private JComboBox regUserType;
	private JLabel userDisplayID;
	private JLabel userTypeLabel;
	private JSeparator separator;
	private JSeparator separator_1;
	private JTextField complaintCost;
	private JTextField complaintCustomerId;
	private JLabel lblNewLabel_3_1_3;
	private JLabel lblNewLabel_3_4_1;
	private JLabel lblNewLabel_3_5_1;
	private JButton btnLodgeComplaint;
	private JPanel addComplaintsPanel;
	private JPanel viewComplaintsPanel;
	private JLabel lblNewLabel_2_3;
	private JLabel lblNewLabel_3_1_4;
	private JTextField complaintCustomerName;
	private JLabel lblNewLabel_3_1_5;
	private JTextField complaintTechnicianId;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JLabel lblNewLabel_2_4;
	private JComboBox complaintType;
	private JLabel lblNewLabel_2_5;
	private JLabel lblNewLabel_3_1_6;
	private JTextField technicianName;
	private JTextArea complaintDescription;
	private JPanel addressPanel;
	private JTextField address1;
	private JTextField address2;
	private JComboBox parish;
	private JLabel lblNewLabel_3_1_7;
	private JLabel lblNewLabel_3_1_3_1_1;
	private JLabel lblNewLabel_3_1_3_1_2;
	private JLabel lblNewLabel_2_6;
	private JTable complaintTable;
	private JScrollPane scrollPane;
	private JPanel viewPaymentPanel;
	private JPanel makePaymentPanel;
	private JTextField paymentCustomerId;
	private JTextField paymentAmount;
	private JButton btnMakePayment;
	private JLabel lblNewLabel_3_1_3_3;
	private JTextField paymentComplaintId;
	private JTable customerPaymentTable;
	private JScrollPane scrollPane_1;
	private JTable paymentsTable;
	private JTable table;
	private JScrollPane scrollPane_3;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton PaymentBtn_1_1_2;
	private JButton PaymentBtn_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmMscv.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {

		initialize();
		displayDate(); 
		
		 
	}


	/**
	 * Initialize the contents of the frame.
	 */

	public void setPanel(int panelNum) {

		JButton[] mainButton= {mainBtnDashboard, PaymentBtn, complainBtn, respondBtn, assignBtn};
		JPanel[] mainPanel= {dashboardPanel, paymentPanel, complaintsPanel, respondPanel, assignPanel};

		for (int i=0; i<5; i++) {

			if(i==panelNum) {
				mainButton[panelNum].setForeground(new Color(0, 191, 255));
				mainPanel[panelNum].setVisible(true);
				if(panelNum==0) {
					mainLabel.setText("Dashboard");
				}else if(panelNum==1) {
					mainLabel.setText("Payments");
				}else if(panelNum==2) {
					mainLabel.setText("Complaints");
				}else if(panelNum==3) {
					mainLabel.setText("Responses");
				}else if(panelNum==4) {
					mainLabel.setText("Assign Technician");
				}
			}else {
				mainButton[i].setForeground(Color.darkGray);
				mainPanel[i].setVisible(false);
			}

		}

	}

	public void setComplaintPanel(int panelNum) {

		//		JButton[] mainButton= {mainBtnDashboard, PaymentBtn, complainBtn, respondBtn, assignBtn};
		JPanel[] mainPanel= {addComplaintsPanel, viewComplaintsPanel};

		for (int i=0; i<mainPanel.length; i++) {

			if(i==panelNum) {
				//				mainButton[panelNum].setForeground(new Color(0, 191, 255));
				mainPanel[panelNum].setVisible(true);
			}else {
				//				mainButton[i].setForeground(Color.darkGray);
				mainPanel[i].setVisible(false);
			}

		}

	}

	
	public void setPaymentPanel(int panelNum) {

		//		JButton[] mainButton= {mainBtnDashboard, PaymentBtn, complainBtn, respondBtn, assignBtn};
		JPanel[] mainPanel= {makePaymentPanel, viewPaymentPanel};

		for (int i=0; i<mainPanel.length; i++) {

			if(i==panelNum) {
				//				mainButton[panelNum].setForeground(new Color(0, 191, 255));
				mainPanel[panelNum].setVisible(true);
			}else {
				//				mainButton[i].setForeground(Color.darkGray);
				mainPanel[i].setVisible(false);
			}

		}

	}


	public void setMainPanel(int panelNum) {

		JPanel[] mainPanel= {loginPanel, representativePanel, customerPanel, technicianPanel, registerPanel};

		for (int i=0; i<5; i++) {

			if(i==panelNum) {
				//				mainButton[panelNum].setForeground(new Color(0, 191, 255));
				mainPanel[panelNum].setVisible(true);
			}else {
				//				mainButton[i].setForeground(Color.darkGray);
				mainPanel[i].setVisible(false);
			}

		}

	}

	void initialize() {
		frmMscv = new JFrame();
		frmMscv.setBounds(100, 100, 1004, 656);
		frmMscv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMscv.getContentPane().setLayout(new CardLayout(0, 0));
		frmMscv.setLocationRelativeTo(null);
		frmMscv.setTitle("MSCV");
		frmMscv.setResizable(false); 

		JPanel mainPanel = new JPanel();
		frmMscv.getContentPane().add(mainPanel, "name_40632074234174");
		mainPanel.setVisible(true);
		mainPanel.setLayout(new CardLayout(0, 0));

		Object[] title = {"Complaints"};
		dtm = new DefaultTableModel(); 
		dtm.setColumnIdentifiers(title);

		JPanel panel = new JPanel();
		mainPanel.add(panel, "name_694152248491594");
		panel.setLayout(null);

		JPanel UserPanel = new JPanel();
		UserPanel.setBounds(0, 37, 1000, 550);
		panel.add(UserPanel);
		UserPanel.setLayout(new CardLayout(0, 0));

		loginPanel = new JPanel();
		loginPanel.setLayout(null);
		UserPanel.add(loginPanel, "name_100830795326703");

		userID = new JTextField();
		userID.setColumns(10);
		userID.setBounds(378, 321, 273, 28);
		loginPanel.add(userID);

		password = new JPasswordField(); 
		password.setColumns(10);
		password.setBounds(378, 382, 273, 28);
		loginPanel.add(password);

		JLabel lblNewLabel_2 = new JLabel("Micro Star Cable Vission");
		lblNewLabel_2.setForeground(SystemColor.desktop);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Segoe Print", Font.ITALIC, 37));
		lblNewLabel_2.setBounds(165, 32, 668, 80);
		loginPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Login");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Segoe Print", Font.ITALIC, 37));
		lblNewLabel_2_1.setBounds(378, 82, 197, 80);
		loginPanel.add(lblNewLabel_2_1);

		userTypeLabel = new JLabel("ID");
		userTypeLabel.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		userTypeLabel.setBounds(378, 291, 172, 22);
		loginPanel.add(userTypeLabel);

		JLabel lblNewLabel_3_1 = new JLabel("Password");
		lblNewLabel_3_1.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(378, 359, 93, 22);
		loginPanel.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_1_1 = new JLabel("Don't have an account?"); 
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1_1.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		lblNewLabel_3_1_1.setBounds(460, 420, 183, 22);
		loginPanel.add(lblNewLabel_3_1_1);

		JLabel lblNewLabel_3_1_1_1 = new JLabel("Click here");
		lblNewLabel_3_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setMainPanel(4);
			}
		}); 
		lblNewLabel_3_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1_1_1.setForeground(SystemColor.desktop);
		lblNewLabel_3_1_1_1.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		lblNewLabel_3_1_1_1.setBounds(592, 420, 68, 22);
		loginPanel.add(lblNewLabel_3_1_1_1);

		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

//				userID.setText("1500");
//				loginType.setSelectedIndex(2);
//				password.setText("admin");
				
				User user = new User();
				user.setId(userID.getText().toString());
				user.setType( loginType.getSelectedItem().toString());
				user.setPassword(password.getText().toString());

				

				
				if(validate.Login(user)) {

					if(loginType.getSelectedItem().toString().equals("Customer")) {
						setMainPanel(2); 
					}else if(loginType.getSelectedItem().toString().equals("Representative")) {
						setMainPanel(1); 
					}else if(loginType.getSelectedItem().toString().equals("Technician")) {
						setMainPanel(3); 
					}
					userDisplayID.setText("User ID: "+userID.getText().toString());
					resetLoginFeilds();

				}


				//				System.out.println(new String(Crypto.Encrypt("Alpha".getBytes())));
				//				System.out.println(new String(Crypto.Decrypt(new String(Crypto.Encrypt("Alpha".getBytes())).getBytes())));
			}
		});
		btnLogin.setForeground(Color.DARK_GRAY);
		btnLogin.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnLogin.setFocusable(false);
		btnLogin.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		btnLogin.setBackground(new Color(211, 211, 211));
		btnLogin.setBounds(530, 486, 117, 36);
		loginPanel.add(btnLogin);

		loginType = new JComboBox(users);
		loginType.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				if(loginType.getSelectedIndex()==1) {
					userTypeLabel.setText("Customer ID");
				}else if(loginType.getSelectedIndex()>1) {
					userTypeLabel.setText("Staff ID");
				}else{
					userTypeLabel.setText("ID");
				}


			}
		});
		loginType.setFocusable(false);
		loginType.setBackground(new Color(255, 255, 255));
		loginType.setBounds(379, 246, 273, 28); 

		loginPanel.add(loginType); 
		JLabel lblNewLabel_3_5 = new JLabel("Log In as");
		lblNewLabel_3_5.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		lblNewLabel_3_5.setBounds(379, 214, 92, 22);
		loginPanel.add(lblNewLabel_3_5);

		representativePanel = new JPanel();
		representativePanel.setLayout(null);
		representativePanel.setBackground(new Color(211, 211, 211));
		UserPanel.add(representativePanel, "name_695581416808347");	

		mainLabel = new JLabel("Dashboard");
		mainLabel.setForeground(Color.DARK_GRAY);
		mainLabel.setFont(new Font("Dialog", Font.PLAIN, 25));
		mainLabel.setBounds(169, 10, 370, 34);
		representativePanel.add(mainLabel);

		mainBtnDashboard = new JButton("Dashboard");
		mainBtnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(0);
			}
		});
		mainBtnDashboard.setHorizontalTextPosition(SwingConstants.RIGHT);
		mainBtnDashboard.setHorizontalAlignment(SwingConstants.LEFT);
		mainBtnDashboard.setForeground(new Color(0, 191, 255));
		mainBtnDashboard.setFont(new Font("Dialog", Font.PLAIN, 16));
		mainBtnDashboard.setFocusable(false);
		mainBtnDashboard.setBorder(null);
		mainBtnDashboard.setBackground(new Color(211, 211, 211));
		mainBtnDashboard.setBounds(10, 53, 138, 33);
		representativePanel.add(mainBtnDashboard);

		PaymentBtn = new JButton("Payment");
		PaymentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(1);
				//				mainLabel.
			}
		});
		PaymentBtn.setHorizontalTextPosition(SwingConstants.RIGHT);
		PaymentBtn.setHorizontalAlignment(SwingConstants.LEFT);
		PaymentBtn.setForeground(Color.DARK_GRAY);
		PaymentBtn.setFont(new Font("Dialog", Font.PLAIN, 16));
		PaymentBtn.setFocusable(false);
		PaymentBtn.setBorder(null);
		PaymentBtn.setBackground(new Color(211, 211, 211));
		PaymentBtn.setBounds(10, 88, 138, 33);
		representativePanel.add(PaymentBtn);

		complainBtn = new JButton("Complaints");
		complainBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(2);
			}
		});
		complainBtn.setHorizontalTextPosition(SwingConstants.RIGHT);
		complainBtn.setHorizontalAlignment(SwingConstants.LEFT);
		complainBtn.setForeground(Color.DARK_GRAY);
		complainBtn.setFont(new Font("Dialog", Font.PLAIN, 16));
		complainBtn.setFocusable(false);
		complainBtn.setBorder(null);
		complainBtn.setBackground(new Color(211, 211, 211));
		complainBtn.setBounds(10, 124, 138, 33);
		representativePanel.add(complainBtn);

		respondBtn = new JButton("Response");
		respondBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(3);
			}
		});
		respondBtn.setHorizontalTextPosition(SwingConstants.RIGHT);
		respondBtn.setHorizontalAlignment(SwingConstants.LEFT);
		respondBtn.setForeground(Color.DARK_GRAY);
		respondBtn.setFont(new Font("Dialog", Font.PLAIN, 16));
		respondBtn.setFocusable(false);
		respondBtn.setBorder(null);
		respondBtn.setBackground(new Color(211, 211, 211));
		respondBtn.setBounds(10, 161, 138, 33);
		representativePanel.add(respondBtn);

		assignBtn = new JButton("Assign Complaint");
		assignBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(4);
			}
		});
		assignBtn.setHorizontalTextPosition(SwingConstants.RIGHT);
		assignBtn.setHorizontalAlignment(SwingConstants.LEFT);
		assignBtn.setForeground(Color.DARK_GRAY);
		assignBtn.setFont(new Font("Dialog", Font.PLAIN, 16));
		assignBtn.setFocusable(false);
		assignBtn.setBorder(null);
		assignBtn.setBackground(new Color(211, 211, 211));
		assignBtn.setBounds(10, 198, 138, 33);
		representativePanel.add(assignBtn);

		JPanel selectPanel = new JPanel();
		selectPanel.setBounds(167, 53, 750, 443);
		representativePanel.add(selectPanel);
		selectPanel.setLayout(new CardLayout(0, 0));

		dashboardPanel = new JPanel();
		selectPanel.add(dashboardPanel, "name_7386572354584");
		dashboardPanel.setLayout(null);

		JButton btnAdd1 = new JButton("Payment");
		btnAdd1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(1);
			}
		});
		btnAdd1.setBounds(56, 397, 117, 36);
		btnAdd1.setForeground(Color.DARK_GRAY);
		btnAdd1.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnAdd1.setFocusable(false);
		btnAdd1.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		btnAdd1.setBackground(new Color(211, 211, 211));
		dashboardPanel.add(btnAdd1);

		JButton btnView1 = new JButton("Complaints");
		btnView1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(2);
			}
		});
		btnView1.setBounds(229, 397, 117, 36);
		btnView1.setForeground(Color.DARK_GRAY);
		btnView1.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnView1.setFocusable(false);
		btnView1.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		btnView1.setBackground(new Color(211, 211, 211));
		dashboardPanel.add(btnView1);

		JButton btnUpdateRecords = new JButton("Assign");
		btnUpdateRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(4);
			}
		});
		btnUpdateRecords.setBounds(575, 397, 117, 36);
		btnUpdateRecords.setForeground(Color.DARK_GRAY);
		btnUpdateRecords.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnUpdateRecords.setFocusable(false);
		btnUpdateRecords.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		btnUpdateRecords.setBackground(new Color(211, 211, 211));
		dashboardPanel.add(btnUpdateRecords);

		JButton btnDeleteRecords = new JButton("Respond");
		btnDeleteRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(3);
			}
		});
		btnDeleteRecords.setBounds(402, 397, 117, 36);
		btnDeleteRecords.setForeground(Color.DARK_GRAY);
		btnDeleteRecords.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnDeleteRecords.setFocusable(false);
		btnDeleteRecords.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		btnDeleteRecords.setBackground(new Color(211, 211, 211));
		dashboardPanel.add(btnDeleteRecords);

		paymentPanel = new JPanel();
		paymentPanel.setBackground(SystemColor.controlHighlight);
		selectPanel.add(paymentPanel, "name_7390094721899");
		paymentPanel.setLayout(null);
		
		JButton btnAdd1_1_1 = new JButton("View Payments");
		btnAdd1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPaymentPanel(1);
				
				ResultSet rs1= connect.GetAllPayments();

				if(rs1!=null)
					paymentsTable.setModel(DbUtils.resultSetToTableModel(rs1));
//				paymentsTable
			}
		});
		btnAdd1_1_1.setForeground(Color.DARK_GRAY);
		btnAdd1_1_1.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnAdd1_1_1.setFocusable(false);
		btnAdd1_1_1.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		btnAdd1_1_1.setBackground(new Color(211, 211, 211));
		btnAdd1_1_1.setBounds(423, 397, 154, 36);
		paymentPanel.add(btnAdd1_1_1);
		
		JButton btnView1_1_1 = new JButton("Make Payment");
		btnView1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPaymentPanel(0);
			}
		});
		btnView1_1_1.setForeground(Color.DARK_GRAY);
		btnView1_1_1.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnView1_1_1.setFocusable(false);
		btnView1_1_1.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		btnView1_1_1.setBackground(new Color(211, 211, 211));
		btnView1_1_1.setBounds(188, 397, 154, 36);
		paymentPanel.add(btnView1_1_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 750, 387);
		paymentPanel.add(panel_3);
		panel_3.setLayout(new CardLayout(0, 0));
		
		makePaymentPanel = new JPanel();
		panel_3.add(makePaymentPanel, "name_634333352789169");
		makePaymentPanel.setLayout(null);
		
		JLabel lblNewLabel_2_3_2 = new JLabel("Make Payment");
		lblNewLabel_2_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3_2.setFont(new Font("Segoe Print", Font.ITALIC, 25));
		lblNewLabel_2_3_2.setBounds(230, 10, 289, 46);
		makePaymentPanel.add(lblNewLabel_2_3_2);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(77, 54, 595, 2);
		makePaymentPanel.add(separator_1_2);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(77, 10, 595, 2);
		makePaymentPanel.add(separator_5);
		
		paymentCustomerId = new JTextField();
		paymentCustomerId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				
				if(paymentCustomerId.getText().length()>2) {
					//					System.out.println(complaintCustomerId.getText());
					 

						ResultSet rs1= connect.GetCustomerComplaints(paymentCustomerId.getText());
//						rs1.next();
						 
						
							if(rs1!=null) {
								customerPaymentTable.setVisible(true);
								customerPaymentTable.setModel(DbUtils.resultSetToTableModel(rs1));
 
							} 
							
								
//					if(user!=null && user.getType().equals("Customer")) {
//						complaintCustomerName.setText(user.getFirstName()+" "+user.getLastName());
//					}else {
//						complaintCustomerName.setText("Customer Not Found");
//					}
				}
				
			}
		});
		paymentCustomerId.setColumns(10);
		paymentCustomerId.setBounds(166, 289, 190, 28);
		makePaymentPanel.add(paymentCustomerId);
		
		JLabel lblNewLabel_3_1_3_2 = new JLabel("Customer ID");
		lblNewLabel_3_1_3_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_1_3_2.setBounds(63, 295, 93, 14);
		makePaymentPanel.add(lblNewLabel_3_1_3_2);
		
		JLabel lblNewLabel_3_1_3_2_1 = new JLabel("Amount");
		lblNewLabel_3_1_3_2_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_1_3_2_1.setBounds(403, 295, 93, 14);
		makePaymentPanel.add(lblNewLabel_3_1_3_2_1);
		
		paymentAmount = new JTextField();
		paymentAmount.setColumns(10);
		paymentAmount.setBounds(506, 289, 163, 28);
		makePaymentPanel.add(paymentAmount);
		
		btnMakePayment = new JButton("Make Payment");
		btnMakePayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		 
				Payment pay = new Payment();
				
				pay.setAmount(paymentAmount.getText());
				pay.setComplaint_id(paymentComplaintId.getText());
				pay.setCustomer_id(paymentCustomerId.getText());
				pay.setRepresentative_id(userDisplayID.getText().substring(9, userDisplayID.getText().length()));
				
				if(validate.Payment(pay)) {
					paymentAmount.setText("");
					paymentComplaintId.setText("");
					paymentCustomerId.setText("");
					
					customerPaymentTable.setVisible(false);
				}
			}
		});
		btnMakePayment.setIconTextGap(0);
		btnMakePayment.setForeground(Color.DARK_GRAY);
		btnMakePayment.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnMakePayment.setFocusable(false);
		btnMakePayment.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		btnMakePayment.setBackground(new Color(211, 211, 211));
		btnMakePayment.setBounds(506, 333, 166, 27);
		makePaymentPanel.add(btnMakePayment);
		
		lblNewLabel_3_1_3_3 = new JLabel("Complaint Id");
		lblNewLabel_3_1_3_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_1_3_3.setBounds(63, 333, 93, 14);
		makePaymentPanel.add(lblNewLabel_3_1_3_3);
		
		paymentComplaintId = new JTextField();
		paymentComplaintId.setColumns(10);
		paymentComplaintId.setBounds(166, 327, 190, 28);
		makePaymentPanel.add(paymentComplaintId);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(77, 66, 595, 196);
		makePaymentPanel.add(scrollPane_1);
		
		dtm = new DefaultTableModel();
		Object[] customerPaymentTitle = {"Receipt Number", "Customer Id", "Type",  "Cost"}; 
//		 
		dtm.setColumnIdentifiers(customerPaymentTitle);
		customerPaymentTable = new JTable(dtm);
		scrollPane_1.setViewportView(customerPaymentTable);
		

		
		
		viewPaymentPanel = new JPanel();
		panel_3.add(viewPaymentPanel, "name_634311450121066");
		viewPaymentPanel.setLayout(null);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("View Payments");
		lblNewLabel_2_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3_1.setFont(new Font("Segoe Print", Font.ITALIC, 25));
		lblNewLabel_2_3_1.setBounds(230, 10, 289, 46);
		viewPaymentPanel.add(lblNewLabel_2_3_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(77, 54, 595, 2);
		viewPaymentPanel.add(separator_1_1);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(77, 10, 595, 2);
		viewPaymentPanel.add(separator_4);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(77, 86, 595, 250);
		viewPaymentPanel.add(scrollPane_2);
		
	
		dtm = new DefaultTableModel(); 
		Object[] allPaymentTitle = {"Receipt Number", "Customer Id", "Representative Id","Complaint Id", "Amount"}; 
		
		dtm.setColumnIdentifiers(allPaymentTitle);
		paymentsTable = new JTable(dtm);
		scrollPane_2.setViewportView(paymentsTable);

		complaintsPanel = new JPanel();
		complaintsPanel.setBackground(SystemColor.controlHighlight);
		selectPanel.add(complaintsPanel, "name_7392668747440");
		complaintsPanel.setLayout(null);

		JButton btnAdd1_1 = new JButton("View Complaints");
		btnAdd1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setComplaintPanel(1); 

				ResultSet rs1= connect.GetAllComplaints(); 

				if(rs1!=null)
					complaintTable.setModel(DbUtils.resultSetToTableModel(rs1));
			}
		});
		btnAdd1_1.setForeground(Color.DARK_GRAY);
		btnAdd1_1.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnAdd1_1.setFocusable(false);
		btnAdd1_1.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		btnAdd1_1.setBackground(new Color(211, 211, 211));
		btnAdd1_1.setBounds(418, 397, 154, 36);
		complaintsPanel.add(btnAdd1_1);

		JButton btnView1_1 = new JButton("Add Complaints");
		btnView1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setComplaintPanel(0);
			}
		});
		btnView1_1.setForeground(Color.DARK_GRAY);
		btnView1_1.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnView1_1.setFocusable(false);
		btnView1_1.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		btnView1_1.setBackground(new Color(211, 211, 211));
		btnView1_1.setBounds(183, 397, 154, 36);
		complaintsPanel.add(btnView1_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 750, 387);
		complaintsPanel.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));

		addComplaintsPanel = new JPanel();
		panel_1.add(addComplaintsPanel, "name_349923885404343");
		addComplaintsPanel.setLayout(null);

		separator = new JSeparator();
		separator.setBounds(77, 10, 595, 2);
		addComplaintsPanel.add(separator);

		separator_1 = new JSeparator();
		separator_1.setBounds(77, 54, 595, 2);
		addComplaintsPanel.add(separator_1);

		complaintCost = new JTextField();
		complaintCost.setColumns(10);
		complaintCost.setBounds(125, 227, 190, 28);
		addComplaintsPanel.add(complaintCost);

		complaintCustomerId = new JTextField();   
		complaintCustomerId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				//				
				if(complaintCustomerId.getText().length()>2) {
					//					System.out.println(complaintCustomerId.getText());
					user= connect.GetUserRecordWithId(complaintCustomerId.getText());


					if(user!=null && user.getType().equals("Customer")) {
						complaintCustomerName.setText(user.getFirstName()+" "+user.getLastName());
					}else {
						complaintCustomerName.setText("Customer Not Found");
					}
				}
			}
		});
		complaintCustomerId.setColumns(10);
		complaintCustomerId.setBounds(125, 81, 190, 28);
		addComplaintsPanel.add(complaintCustomerId);

		lblNewLabel_3_1_3 = new JLabel("Customer ID");
		lblNewLabel_3_1_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_1_3.setBounds(22, 87, 93, 14);
		addComplaintsPanel.add(lblNewLabel_3_1_3);

		lblNewLabel_3_4_1 = new JLabel("Description");
		lblNewLabel_3_4_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_4_1.setBounds(22, 286, 93, 14);
		addComplaintsPanel.add(lblNewLabel_3_4_1);

		lblNewLabel_3_5_1 = new JLabel("Cost");
		lblNewLabel_3_5_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_5_1.setBounds(22, 232, 93, 14);
		addComplaintsPanel.add(lblNewLabel_3_5_1);

		btnLodgeComplaint = new JButton("Lodge Complaint");
		btnLodgeComplaint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				complaint.setRepresentative_id(userDisplayID.getText().substring(9, userDisplayID.getText().length()));
				complaint.setCustomer_id(complaintCustomerId.getText());
				complaint.setType(complaintType.getSelectedItem().toString());
				complaint.setCost(complaintCost.getText());
				complaint.setDescription(complaintDescription.getText());

				complaint.getResponse().setTechnician_id(complaintTechnicianId.getText());
				//				complaint.getResponse().setAddress1(address1.getText());
				//				complaint.getResponse().setAddress2(address2.getText());
				//				complaint.getResponse().setParish(parish.getSelectedItem().toString());

				//				complaint.set


				//				complaint.set

				if(validate.Complaint(complaint, complaintCustomerName.getText(), technicianName.getText() )) {
					resetComplaint();
				}

				//				complaintCustomerId.getTe

				//				complaintTechnicianId
			}
		});
		btnLodgeComplaint.setIconTextGap(0);
		btnLodgeComplaint.setForeground(Color.DARK_GRAY);
		btnLodgeComplaint.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnLodgeComplaint.setFocusable(false);
		btnLodgeComplaint.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		btnLodgeComplaint.setBackground(new Color(211, 211, 211));
		btnLodgeComplaint.setBounds(548, 350, 166, 27);
		addComplaintsPanel.add(btnLodgeComplaint);

		lblNewLabel_2_3 = new JLabel("Add Complaints");
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3.setFont(new Font("Segoe Print", Font.ITALIC, 25));
		lblNewLabel_2_3.setBounds(230, 10, 289, 46);
		addComplaintsPanel.add(lblNewLabel_2_3);

		lblNewLabel_3_1_4 = new JLabel("Customer Name");
		lblNewLabel_3_1_4.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_1_4.setBounds(22, 135, 93, 14);
		addComplaintsPanel.add(lblNewLabel_3_1_4);

		complaintCustomerName = new JTextField();
		complaintCustomerName.setEditable(false);
		complaintCustomerName.setColumns(10);
		complaintCustomerName.setBounds(125, 129, 190, 28);
		addComplaintsPanel.add(complaintCustomerName);

		lblNewLabel_3_1_5 = new JLabel("Select Complaint");
		lblNewLabel_3_1_5.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_1_5.setBounds(10, 190, 105, 14);
		addComplaintsPanel.add(lblNewLabel_3_1_5);

		complaintType = new JComboBox(cableComplaints);
		complaintType.setFocusable(false);
		complaintType.setBackground(Color.WHITE);
		complaintType.setBounds(125, 182, 190, 28);
		addComplaintsPanel.add(complaintType);

		JLabel lblNewLabel_3_1_3_1 = new JLabel("Technician ID");
		lblNewLabel_3_1_3_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_1_3_1.setBounds(390, 121, 93, 14);
		addComplaintsPanel.add(lblNewLabel_3_1_3_1);

		complaintTechnicianId = new JTextField();
		complaintTechnicianId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				if(complaintTechnicianId.getText().length()>2) {
					//					System.out.println(complaintCustomerId.getText());
					user= connect.GetUserRecordWithId(complaintTechnicianId.getText());
					//					 System.out.println(user.getType());
					if(user!=null && user.getType().equals("Technician")) {
						technicianName.setText(user.getFirstName()+" "+user.getLastName());
						//						addResposePanel.setVisible(true);
					}else {
						technicianName.setText("Technician Not Found");
						//						addResposePanel.setVisible(false);
					}
				}
			}
		});
		complaintTechnicianId.setColumns(10);
		complaintTechnicianId.setBounds(493, 115, 190, 28);
		addComplaintsPanel.add(complaintTechnicianId);

		complaintDescription = new JTextArea();
		complaintDescription.setBounds(125, 275, 190, 102);
		addComplaintsPanel.add(complaintDescription);

		lblNewLabel_2_5 = new JLabel("Assign Technician Now (Optional)");
		lblNewLabel_2_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_5.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		lblNewLabel_2_5.setBounds(390, 66, 350, 46);
		addComplaintsPanel.add(lblNewLabel_2_5);

		lblNewLabel_3_1_6 = new JLabel("Technician Name");
		lblNewLabel_3_1_6.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_1_6.setBounds(368, 169, 115, 14);
		addComplaintsPanel.add(lblNewLabel_3_1_6);

		technicianName = new JTextField();
		technicianName.setEditable(false);
		technicianName.setColumns(10);
		technicianName.setBounds(493, 163, 190, 28);
		addComplaintsPanel.add(technicianName);

		viewComplaintsPanel = new JPanel();
		panel_1.add(viewComplaintsPanel, "name_349935171629369");
		viewComplaintsPanel.setLayout(null);

		separator_2 = new JSeparator();
		separator_2.setBounds(77, 10, 595, 2);
		viewComplaintsPanel.add(separator_2);

		separator_3 = new JSeparator();
		separator_3.setBounds(77, 54, 595, 2);
		viewComplaintsPanel.add(separator_3);

		lblNewLabel_2_4 = new JLabel("View Complaints");
		lblNewLabel_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_4.setFont(new Font("Segoe Print", Font.ITALIC, 25));
		lblNewLabel_2_4.setBounds(230, 10, 289, 46);
		viewComplaintsPanel.add(lblNewLabel_2_4);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(77, 81, 595, 269);
		viewComplaintsPanel.add(scrollPane);
		
		Object[] complaintTableTitle = {"Complaint Id", "Customer Id", "Representative Id", "Type", "Description", "Cost"};
		
		dtm = new DefaultTableModel(); 
		dtm.setColumnIdentifiers(complaintTableTitle);
		complaintTable = new JTable(dtm);
		scrollPane.setViewportView(complaintTable);
		
		respondPanel = new JPanel();
		selectPanel.add(respondPanel, "name_7395395437632");
		respondPanel.setLayout(null);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(45, 82, 660, 300);
		respondPanel.add(scrollPane_3);
		
		table = new JTable();
		scrollPane_3.setViewportView(table);
		
		JLabel lblNewLabel_2_3_3 = new JLabel("View Responses");
		lblNewLabel_2_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3_3.setFont(new Font("Segoe Print", Font.ITALIC, 25));
		lblNewLabel_2_3_3.setBounds(230, 10, 289, 46);
		respondPanel.add(lblNewLabel_2_3_3);
		
		JSeparator separator_1_3 = new JSeparator();
		separator_1_3.setBounds(77, 54, 595, 2);
		respondPanel.add(separator_1_3);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(77, 10, 595, 2);
		respondPanel.add(separator_6);

		assignPanel = new JPanel();
		selectPanel.add(assignPanel, "name_7401454985022");
		assignPanel.setLayout(null);
		
		JLabel lblNewLabel_2_3_4 = new JLabel("Assign Responses");
		lblNewLabel_2_3_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3_4.setFont(new Font("Segoe Print", Font.ITALIC, 25));
		lblNewLabel_2_3_4.setBounds(219, 10, 289, 46);
		assignPanel.add(lblNewLabel_2_3_4);
		
		JSeparator separator_1_4 = new JSeparator();
		separator_1_4.setBounds(66, 54, 595, 2);
		assignPanel.add(separator_1_4);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(66, 10, 595, 2);
		assignPanel.add(separator_7);
		
		JButton btnAssign = new JButton("Assign");
		btnAssign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAssign.setIconTextGap(0);
		btnAssign.setForeground(Color.DARK_GRAY);
		btnAssign.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnAssign.setFocusable(false);
		btnAssign.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		btnAssign.setBackground(new Color(211, 211, 211));
		btnAssign.setBounds(502, 292, 166, 27);
		assignPanel.add(btnAssign);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(147, 211, 190, 28);
		assignPanel.add(textField);
		
		JLabel lblNewLabel_3_1_6_1 = new JLabel("Technician Name");
		lblNewLabel_3_1_6_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_1_6_1.setBounds(22, 217, 115, 14);
		assignPanel.add(lblNewLabel_3_1_6_1);
		
		JLabel lblNewLabel_3_1_3_1_3 = new JLabel("Technician ID");
		lblNewLabel_3_1_3_1_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_1_3_1_3.setBounds(44, 169, 93, 14);
		assignPanel.add(lblNewLabel_3_1_3_1_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(147, 163, 190, 28);
		assignPanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(478, 140, 190, 28);
		assignPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(478, 92, 190, 28);
		assignPanel.add(textField_3);
		
		JLabel lblNewLabel_3_1_3_4 = new JLabel("Customer ID");
		lblNewLabel_3_1_3_4.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_1_3_4.setBounds(375, 98, 93, 14);
		assignPanel.add(lblNewLabel_3_1_3_4);
		
		JLabel lblNewLabel_3_1_4_1 = new JLabel("Customer Name");
		lblNewLabel_3_1_4_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_1_4_1.setBounds(375, 146, 93, 14);
		assignPanel.add(lblNewLabel_3_1_4_1);
		
		JLabel lblNewLabel_3_1_3_1_3_1 = new JLabel("Complaint ID");
		lblNewLabel_3_1_3_1_3_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_1_3_1_3_1.setBounds(44, 115, 93, 14);
		assignPanel.add(lblNewLabel_3_1_3_1_3_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(147, 109, 190, 28);
		assignPanel.add(textField_4);

		JButton btnAdd1_2 = new JButton("Logout");
		btnAdd1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setMainPanel(0	);
			}
		});
		btnAdd1_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnAdd1_2.setForeground(new Color(0, 191, 255));
		btnAdd1_2.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnAdd1_2.setFocusable(false);
		btnAdd1_2.setBorder(null);
		btnAdd1_2.setBackground(new Color(211, 211, 211));
		btnAdd1_2.setBounds(10, 460, 117, 36);
		representativePanel.add(btnAdd1_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(169, 53, 750, 382);
		representativePanel.add(panel_2);

		customerPanel = new JPanel();
		customerPanel.setBackground(new Color(211, 211, 211));
		UserPanel.add(customerPanel, "name_695582208484637");
		customerPanel.setLayout(null);
		
		JButton mainBtnDashboard_1 = new JButton("Dashboard");
		mainBtnDashboard_1.setHorizontalTextPosition(SwingConstants.RIGHT);
		mainBtnDashboard_1.setHorizontalAlignment(SwingConstants.LEFT);
		mainBtnDashboard_1.setForeground(new Color(0, 191, 255));
		mainBtnDashboard_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		mainBtnDashboard_1.setFocusable(false);
		mainBtnDashboard_1.setBorder(null);
		mainBtnDashboard_1.setBackground(new Color(211, 211, 211));
		mainBtnDashboard_1.setBounds(28, 36, 138, 33);
		customerPanel.add(mainBtnDashboard_1);
		
		JPanel selectPanel_1 = new JPanel();
		selectPanel_1.setBounds(185, 36, 750, 443);
		customerPanel.add(selectPanel_1);
		selectPanel_1.setLayout(new CardLayout(0, 0));
		
		JButton PaymentBtn_1 = new JButton("View Payment");
		PaymentBtn_1.setHorizontalTextPosition(SwingConstants.RIGHT);
		PaymentBtn_1.setHorizontalAlignment(SwingConstants.LEFT);
		PaymentBtn_1.setForeground(Color.DARK_GRAY);
		PaymentBtn_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		PaymentBtn_1.setFocusable(false);
		PaymentBtn_1.setBorder(null);
		PaymentBtn_1.setBackground(new Color(211, 211, 211));
		PaymentBtn_1.setBounds(28, 79, 138, 33);
		customerPanel.add(PaymentBtn_1);
		
		PaymentBtn_1_1_2 = new JButton("Live Chat");
		PaymentBtn_1_1_2.setHorizontalTextPosition(SwingConstants.RIGHT);
		PaymentBtn_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		PaymentBtn_1_1_2.setForeground(Color.DARK_GRAY);
		PaymentBtn_1_1_2.setFont(new Font("Dialog", Font.PLAIN, 16));
		PaymentBtn_1_1_2.setFocusable(false);
		PaymentBtn_1_1_2.setBorder(null);
		PaymentBtn_1_1_2.setBackground(new Color(211, 211, 211));
		PaymentBtn_1_1_2.setBounds(28, 168, 138, 33);
		customerPanel.add(PaymentBtn_1_1_2);
		
		PaymentBtn_2 = new JButton("Query");
		PaymentBtn_2.setHorizontalTextPosition(SwingConstants.RIGHT);
		PaymentBtn_2.setHorizontalAlignment(SwingConstants.LEFT);
		PaymentBtn_2.setForeground(Color.DARK_GRAY);
		PaymentBtn_2.setFont(new Font("Dialog", Font.PLAIN, 16));
		PaymentBtn_2.setFocusable(false);
		PaymentBtn_2.setBorder(null);
		PaymentBtn_2.setBackground(new Color(211, 211, 211));
		PaymentBtn_2.setBounds(28, 125, 138, 33);
		customerPanel.add(PaymentBtn_2);

		technicianPanel = new JPanel();
		technicianPanel.setLayout(null);
		technicianPanel.setBackground(new Color(211, 211, 211));
		UserPanel.add(technicianPanel, "name_695582346701449");
		
		JButton PaymentBtn_1_1 = new JButton("Responses");
		PaymentBtn_1_1.setHorizontalTextPosition(SwingConstants.RIGHT);
		PaymentBtn_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		PaymentBtn_1_1.setForeground(Color.DARK_GRAY);
		PaymentBtn_1_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		PaymentBtn_1_1.setFocusable(false);
		PaymentBtn_1_1.setBorder(null);
		PaymentBtn_1_1.setBackground(new Color(211, 211, 211));
		PaymentBtn_1_1.setBounds(36, 72, 138, 33);
		technicianPanel.add(PaymentBtn_1_1);
		
		JButton mainBtnDashboard_1_1 = new JButton("Dashboard");
		mainBtnDashboard_1_1.setHorizontalTextPosition(SwingConstants.RIGHT);
		mainBtnDashboard_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		mainBtnDashboard_1_1.setForeground(new Color(0, 191, 255));
		mainBtnDashboard_1_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		mainBtnDashboard_1_1.setFocusable(false);
		mainBtnDashboard_1_1.setBorder(null);
		mainBtnDashboard_1_1.setBackground(new Color(211, 211, 211));
		mainBtnDashboard_1_1.setBounds(36, 29, 138, 33);
		technicianPanel.add(mainBtnDashboard_1_1);
		
		JPanel selectPanel_1_1 = new JPanel();
		selectPanel_1_1.setBounds(193, 29, 750, 443);
		technicianPanel.add(selectPanel_1_1);
		selectPanel_1_1.setLayout(new CardLayout(0, 0));
		
		JButton PaymentBtn_1_1_1 = new JButton("Live Chat");
		PaymentBtn_1_1_1.setHorizontalTextPosition(SwingConstants.RIGHT);
		PaymentBtn_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		PaymentBtn_1_1_1.setForeground(Color.DARK_GRAY);
		PaymentBtn_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		PaymentBtn_1_1_1.setFocusable(false);
		PaymentBtn_1_1_1.setBorder(null);
		PaymentBtn_1_1_1.setBackground(new Color(211, 211, 211));
		PaymentBtn_1_1_1.setBounds(36, 121, 138, 33);
		technicianPanel.add(PaymentBtn_1_1_1);

		registerPanel = new JPanel();
		UserPanel.add(registerPanel, "name_6944047469471");
		registerPanel.setLayout(null);

		regEmail = new JTextField();
		regEmail.setColumns(10);
		regEmail.setBounds(277, 377, 273, 28);
		registerPanel.add(regEmail);

		regPassword = new JPasswordField();
		regPassword.setColumns(10);
		regPassword.setBounds(277, 424, 273, 28);
		registerPanel.add(regPassword);

		lblNewLabel_4 = new JLabel("Micro Star Cable Vission");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(SystemColor.desktop);
		lblNewLabel_4.setFont(new Font("Segoe Print", Font.ITALIC, 35));
		lblNewLabel_4.setBounds(172, 0, 668, 80);
		registerPanel.add(lblNewLabel_4);

		lblNewLabel_2_2 = new JLabel("Register");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("Segoe Print", Font.ITALIC, 35));
		lblNewLabel_2_2.setBounds(386, 43, 226, 80);
		registerPanel.add(lblNewLabel_2_2);

		lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_5.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(188, 376, 80, 22);
		registerPanel.add(lblNewLabel_5);

		lblNewLabel_3_2 = new JLabel("Password");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_2.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		lblNewLabel_3_2.setBounds(175, 430, 93, 22);
		registerPanel.add(lblNewLabel_3_2);

		lblNewLabel_3_1_2 = new JLabel("Already Registererd?");
		lblNewLabel_3_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1_2.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		lblNewLabel_3_1_2.setBounds(370, 462, 174, 22);
		registerPanel.add(lblNewLabel_3_1_2);

		lblNewLabel_3_1_1_2 = new JLabel("Click here");
		lblNewLabel_3_1_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setMainPanel(0);
			}
		});
		lblNewLabel_3_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1_1_2.setForeground(SystemColor.desktop);
		lblNewLabel_3_1_1_2.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		lblNewLabel_3_1_1_2.setBounds(493, 462, 68, 22);
		registerPanel.add(lblNewLabel_3_1_1_2);

		regFirstName = new JTextField();
		regFirstName.setColumns(10);
		regFirstName.setBounds(277, 223, 273, 28);
		registerPanel.add(regFirstName);

		regLastName = new JTextField();
		regLastName.setColumns(10);
		regLastName.setBounds(277, 272, 273, 28);
		registerPanel.add(regLastName);

		lblNewLabel_6 = new JLabel("First Name");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_6.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(165, 222, 103, 22);
		registerPanel.add(lblNewLabel_6);

		lblNewLabel_3_3 = new JLabel("Last Name");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_3.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		lblNewLabel_3_3.setBounds(175, 278, 93, 22);
		registerPanel.add(lblNewLabel_3_3);

		lblNewLabel_3_4 = new JLabel("Mobile");
		lblNewLabel_3_4.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_4.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		lblNewLabel_3_4.setBounds(175, 329, 93, 22);
		registerPanel.add(lblNewLabel_3_4);

		regMobile = new JTextField();
		regMobile.setColumns(10);
		regMobile.setBounds(277, 323, 273, 28);
		registerPanel.add(regMobile);

		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = new User();
				user.setFirstName(regFirstName.getText().toString());
				user.setLastName(regLastName.getText().toString());
				user.setMobile(regMobile.getText().toString());
				user.setEmail(regEmail.getText().toString());
				user.setType(regUserType.getSelectedItem().toString());
				user.setPassword(regPassword.getText().toString());
				user.getAddress().setAddress1(address1.getText());	
				user.getAddress().setAddress2(address2.getText());	
				user.getAddress().setParish(parish.getSelectedItem().toString());	

				//				System.out.println(regUserType.getSelectedItem().toString());

				if(validate.UserRegistration(user)) {

					if(regUserType.getSelectedItem().toString().equals("Customer")) {
						setMainPanel(2); 
					}else if(regUserType.getSelectedItem().toString().equals("Representative")) {
						setMainPanel(1); 
					}else if(regUserType.getSelectedItem().toString().equals("Technician")) {
						setMainPanel(3); 
					} 
					userDisplayID.setText("User ID: "+connect.GetUserRecord(regEmail.getText()));
					resetRegistrationFeilds();

				}

			}


		});
		btnRegister.setForeground(Color.DARK_GRAY);
		btnRegister.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnRegister.setFocusable(false);
		btnRegister.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		btnRegister.setBackground(new Color(211, 211, 211));
		btnRegister.setBounds(433, 504, 117, 36);
		registerPanel.add(btnRegister);

		regUserType = new JComboBox(users);
		regUserType.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//				System.out.println();
				if(regUserType.getSelectedItem()=="Customer") {
					addressPanel.setVisible(true);
				}else {
					addressPanel.setVisible(false);
				}
			}
		});
		regUserType.setFocusable(false);
		regUserType.setBackground(Color.WHITE);
		regUserType.setBounds(277, 171, 273, 28);
		registerPanel.add(regUserType);

		JLabel lblNewLabel_6_1 = new JLabel("User Type");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_6_1.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		lblNewLabel_6_1.setBounds(165, 177, 103, 22);
		registerPanel.add(lblNewLabel_6_1);

		addressPanel = new JPanel();
		addressPanel.setVisible(false);
		addressPanel.setBounds(560, 152, 418, 196);
		registerPanel.add(addressPanel);
		addressPanel.setLayout(null);

		address1 = new JTextField();
		address1.setColumns(10);
		address1.setBounds(125, 56, 190, 28);
		addressPanel.add(address1);

		address2 = new JTextField();
		address2.setColumns(10);
		address2.setBounds(125, 97, 190, 28);
		addressPanel.add(address2);

		parish = new JComboBox(parishList);
		parish.setFocusable(false);
		parish.setBackground(Color.WHITE);
		parish.setBounds(125, 139, 190, 28);
		addressPanel.add(parish);

		lblNewLabel_3_1_7 = new JLabel("Parish");
		lblNewLabel_3_1_7.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		lblNewLabel_3_1_7.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_1_7.setBounds(10, 147, 105, 14);
		addressPanel.add(lblNewLabel_3_1_7);

		lblNewLabel_3_1_3_1_1 = new JLabel("Address 2");
		lblNewLabel_3_1_3_1_1.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		lblNewLabel_3_1_3_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_1_3_1_1.setBounds(22, 103, 93, 14);
		addressPanel.add(lblNewLabel_3_1_3_1_1);

		lblNewLabel_3_1_3_1_2 = new JLabel("Address 1");
		lblNewLabel_3_1_3_1_2.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		lblNewLabel_3_1_3_1_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_1_3_1_2.setBounds(22, 62, 93, 14);
		addressPanel.add(lblNewLabel_3_1_3_1_2);

		lblNewLabel_2_6 = new JLabel("Address");
		lblNewLabel_2_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_6.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		lblNewLabel_2_6.setBounds(105, -12, 226, 80);
		addressPanel.add(lblNewLabel_2_6);

		JLabel lblAllRights = new JLabel("Micro Star Cable Vission");
		lblAllRights.setBounds(10, 597, 180, 19);
		lblAllRights.setForeground(Color.DARK_GRAY);
		panel.add(lblAllRights);

		JLabel label = new JLabel("\u00AE");
		label.setBounds(152, 588, 54, 27);
		label.setForeground(SystemColor.controlShadow);
		panel.add(label);

		timeAndDate = new JLabel("Sunday March 21, 2021");
		timeAndDate.setBounds(743, 10, 257, 32);
		timeAndDate.setHorizontalTextPosition(SwingConstants.CENTER);
		timeAndDate.setHorizontalAlignment(SwingConstants.CENTER);
		timeAndDate.setForeground(Color.DARK_GRAY);
		timeAndDate.setFont(new Font("Dialog", Font.ITALIC, 15));
		panel.add(timeAndDate);

		userDisplayID = new JLabel("");
		userDisplayID.setHorizontalTextPosition(SwingConstants.LEADING);
		userDisplayID.setForeground(Color.DARK_GRAY);
		userDisplayID.setFont(new Font("Dialog", Font.ITALIC, 15));
		userDisplayID.setBounds(10, 10, 257, 32);
		panel.add(userDisplayID);
	}


	protected void resetComplaint() {
		complaintCustomerId.setText("");
		complaintType.setSelectedIndex(0);
		complaintCost.setText("");
		complaintDescription.setText("");
		complaintCustomerName.setText("");

		complaintTechnicianId.setText("");
		technicianName.setText("");
		parish.setSelectedIndex(0);


	}

	private void resetRegistrationFeilds() {
		regFirstName.setText("");
		regLastName.setText("");
		regMobile.setText("");
		regEmail.setText("");
		regUserType.setSelectedIndex(0);
		regPassword.setText("");

		address1.setText("");
		address2.setText("");	
		parish.setSelectedIndex(0);	

	}

	private void resetLoginFeilds() {
		userID.setText("");
		loginType.setSelectedIndex(0);
		password.setText(""); 

	}

	private void displayDate() {
		// TODO Auto-generated method stub
		String[] monthName = {"January", "February",
				"March", "April", "May", "June", "July",
				"August", "September", "October", "November",
		"December"};

		String[] weekName = {null,"Sunday", "Monday",
				"Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

		Calendar cal = Calendar.getInstance();

		timeAndDate.setText(weekName[cal.get(Calendar.DAY_OF_WEEK)]+" "+
				monthName[cal.get(Calendar.MONTH)]+" "+
				String.valueOf(cal.get(Calendar.DAY_OF_MONTH))+", "+
				String.valueOf(cal.get(Calendar.YEAR)));

	}
}
