import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Saloon00 {

	private JFrame frame;
	private JTextField en;
	private JTextField ec;
	private JTable table;
	String hl=null;
	Connection conn = null;
	private JTextField date;
	private JTable table_1;
	private JTextField income;
	private JTable table_2;
	private JTextField itemname;
	private JTextField brand;
	private JTextField quantity;
	private JTextField price;
	private JTextField distributer;
	private JTextField d;
	private JTable table_3;
	private JTextField n;
	private JTextField sp;
	private JTable table_4;
	JTabbedPane tabbedPane ;
	int h=0;
	Double s=0.0,q=0.0,w1,w2,w3;
	String c,f,m,a,b;
	JComboBox comboBox_2;
	JComboBox comboBox ;
	JComboBox comboBox_1;
	JPanel panel_4;
	private JTextField tax;
	private JTextField discount;
	private JTextField payment;
	private JTextField paymenttype;
	private JTextField service;
	private JTextField customercontact;
	private JTextField customername;
	private JTextField employeeaddress;
	private JTextField employeesalary;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try 
				{
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
				} catch (Exception e) {	}
				try {
					Saloon00 window = new Saloon00();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void show(String s1,String s2,String s3)
	{
		if(h==1)
		{
			JPanel panel_5 = new JPanel();
			tabbedPane.addTab("Details", null, panel_5, null);
			panel_5.setLayout(null);
			
			JScrollPane scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(25, 73, 441, 209);
			panel_5.add(scrollPane_2);
			
			table_2 = new JTable();
			scrollPane_2.setViewportView(table_2);
			
			JLabel lblNewLabel_3 = new JLabel("Individual Employee Details");
			lblNewLabel_3.setBounds(180, 23, 145, 14);
			panel_5.add(lblNewLabel_3);
			
			
			
			tabbedPane.setEnabledAt(0,false);
			tabbedPane.setEnabledAt(1,false);
			tabbedPane.setEnabledAt(2,false);
			tabbedPane.setEnabledAt(3,false);
			
			tabbedPane.setSelectedIndex(4);	
			try
			{
				String query ="select * from '"+s3+"'";
				PreparedStatement pst = conn.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				table_2.setModel(DbUtils.resultSetToTableModel(rs));
				
				pst.close();
				rs.close();
				
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,e);
			}
			
		
			JButton btnNewButton_3 = new JButton("BACK");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					tabbedPane.setEnabledAt(0,true);
					tabbedPane.setEnabledAt(1,true);
					tabbedPane.setEnabledAt(2,true);
					tabbedPane.setEnabledAt(3,true);
					tabbedPane.setSelectedIndex(0);
					tabbedPane.remove(tabbedPane.getTabCount()-1);
				}
			});
			btnNewButton_3.setBounds(377, 318, 89, 23);
			panel_5.add(btnNewButton_3);
		}
	}
	
	
	/**
	 * Create the application.
	 */
	public Saloon00() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		conn = JdbcDemo1.dbConnector();
		frame = new JFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    frame.setBounds(0, 0, screenSize.width, screenSize.height);  
		frame.setMinimumSize(new Dimension(700, 700));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Employee", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblEmployeeName = new JLabel("Employee Name");
		lblEmployeeName.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeName.setOpaque(true);
		lblEmployeeName.setForeground(new Color(0, 100, 0));
		lblEmployeeName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmployeeName.setBounds(31, 104, 156, 42);
		panel.add(lblEmployeeName);
		
		en = new JTextField();
		en.setBounds(217, 104, 285, 42);
		panel.add(en);
		en.setColumns(10);
		
		JLabel lblEmployeeConatct = new JLabel("Employee Contact");
		lblEmployeeConatct.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeConatct.setOpaque(true);
		lblEmployeeConatct.setForeground(new Color(0, 128, 0));
		lblEmployeeConatct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmployeeConatct.setBounds(31, 167, 156, 43);
		panel.add(lblEmployeeConatct);
		
		ec = new JTextField();
		ec.setBounds(217, 169, 285, 42);
		panel.add(ec);
		ec.setColumns(10);
		
		en.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ec.requestFocusInWindow();
			}
		});
		
		ec.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				en.requestFocusInWindow();
			}
		});
		
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBackground(new Color(0, 100, 0));
		btnNewButton.setForeground(new Color(240, 248, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				try
				{
					String query ="insert into employees(name,contact,address,salary)values(?,?,?,?)";
					PreparedStatement pst = conn.prepareStatement(query);
					
					pst.setString(1, en.getText());
					pst.setString(2, ec.getText());
					pst.setString(3, employeeaddress.getText());
					pst.setString(4, employeesalary.getText());
					
					pst.execute();
					pst.close();
					JOptionPane.showMessageDialog(null, "Data saved!");
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				
				try
				{
					String query = "Select * from employees";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					pst.close();
					rs.close();
					
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e);
				}
				try
				{
					String n = en.getText();
					String c = ec.getText();
					String tb = n+c;
				
					String query ="CREATE  TABLE  IF NOT EXISTS '"+tb+"'(id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , cname TEXT, ccontact TEXT, service TEXT, payment DOUBLE, paymenttype TEXT, discount DOUBLE, date DATETIME)";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null,"Individual employee table created");
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e);
				}
				
			}
		});
		btnNewButton.setBounds(86, 431, 122, 42);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CANCEL");
		btnNewButton_1.setBackground(new Color(0, 100, 0));
		btnNewButton_1.setForeground(new Color(240, 248, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				en.setText(null);
				ec.setText(null);
			}
		});
		btnNewButton_1.setBounds(294, 430, 114, 42);
		panel.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Sitka Small", Font.PLAIN, 16));
		scrollPane.setOpaque(false);
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(564, 102, 723, 371);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		
		JPopupMenu pop=new JPopupMenu();
		
		JMenuItem item1=new JMenuItem("Details");
		item1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel dtm = (DefaultTableModel)table.getModel();
				int r = table.getSelectedRow();
				String s1 = dtm.getValueAt(r, 1).toString();
				String s2 = dtm.getValueAt(r, 2).toString();
				String s3 = s1+s2;
				h=1;
				show(s1,s2,s3);
			}
		});
		
		JMenuItem item=new JMenuItem("Delete");
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel dtm=(DefaultTableModel) table.getModel();
				int r=table.getSelectedRow();
				String id=table.getValueAt(r, 0).toString();
				String name=table.getValueAt(r, 1).toString();
				String contact=table.getValueAt(r, 2).toString();
				
				try{
					String query="delete from employees where id = '"+id+"' ";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.execute();
					pst.close();
				}
				catch(Exception ew)
				{
					JOptionPane.showMessageDialog(null, ew);
				}
				
				try
				{
					String query = "Select * from employees";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					
					pst.close();
					rs.close();
					
				}
				catch(Exception el)
				{
					JOptionPane.showMessageDialog(null,el);
				}
			}
		});
		pop.add(item1);
		pop.add(item);
		table.setComponentPopupMenu(pop);
		
		try
		{
			String query = "Select * from employees";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
			
			pst.close();
			rs.close();
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e);
		}
		
		JLabel lblEmployeeDetails = new JLabel("Employee Details");
		lblEmployeeDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeDetails.setOpaque(true);
		lblEmployeeDetails.setForeground(new Color(0, 100, 0));
		lblEmployeeDetails.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmployeeDetails.setBounds(819, 48, 174, 42);
		panel.add(lblEmployeeDetails);
		
		JLabel lblEmployeeAddress = new JLabel("Employee  Address");
		lblEmployeeAddress.setOpaque(true);
		lblEmployeeAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeAddress.setForeground(new Color(0, 128, 0));
		lblEmployeeAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmployeeAddress.setBounds(31, 234, 156, 43);
		panel.add(lblEmployeeAddress);
		
		JLabel lblEmployeeSalary = new JLabel("Employee Salary");
		lblEmployeeSalary.setOpaque(true);
		lblEmployeeSalary.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeSalary.setForeground(new Color(0, 128, 0));
		lblEmployeeSalary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmployeeSalary.setBounds(31, 302, 156, 43);
		panel.add(lblEmployeeSalary);
		
		employeeaddress = new JTextField();
		employeeaddress.setColumns(10);
		employeeaddress.setBounds(217, 235, 285, 42);
		panel.add(employeeaddress);
		
		employeesalary = new JTextField();
		employeesalary.setColumns(10);
		employeesalary.setBounds(217, 302, 285, 42);
		panel.add(employeesalary);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Customer", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblEnterYourData = new JLabel("Enter your data");
		lblEnterYourData.setBackground(new Color(253, 245, 230));
		lblEnterYourData.setForeground(new Color(0, 128, 0));
		lblEnterYourData.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterYourData.setOpaque(true);
		lblEnterYourData.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnterYourData.setBounds(194, 11, 221, 50);
		panel_1.add(lblEnterYourData);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setForeground(new Color(0, 100, 0));
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustomerName.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerName.setOpaque(true);
		lblCustomerName.setBounds(125, 72, 132, 42);
		panel_1.add(lblCustomerName);
		
		JLabel lblCustomerContact = new JLabel("Customer contact");
		lblCustomerContact.setForeground(new Color(0, 100, 0));
		lblCustomerContact.setOpaque(true);
		lblCustomerContact.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerContact.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustomerContact.setBounds(125, 125, 132, 42);
		panel_1.add(lblCustomerContact);
		
		JLabel lblNewLabel = new JLabel("Employee Name");
		lblNewLabel.setForeground(new Color(0, 100, 0));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(125, 178, 132, 42);
		panel_1.add(lblNewLabel);
		
		JLabel lblService = new JLabel("Service");
		lblService.setForeground(new Color(0, 100, 0));
		lblService.setOpaque(true);
		lblService.setHorizontalAlignment(SwingConstants.CENTER);
		lblService.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblService.setBounds(125, 231, 132, 42);
		panel_1.add(lblService);
		
		JLabel lblNewLabel_1 = new JLabel("Payment");
		lblNewLabel_1.setForeground(new Color(0, 100, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(125, 284, 132, 42);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Payment Type");
		lblNewLabel_2.setForeground(new Color(0, 100, 0));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(125, 337, 132, 42);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblDiscount = new JLabel("Discount");
		lblDiscount.setOpaque(true);
		lblDiscount.setForeground(new Color(0, 100, 0));
		lblDiscount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDiscount.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiscount.setBackground(UIManager.getColor("CheckBox.background"));
		lblDiscount.setBounds(125, 390, 132, 42);
		panel_1.add(lblDiscount);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setOpaque(true);
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setForeground(new Color(0, 100, 0));
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDate.setBounds(125, 496, 132, 42);
		panel_1.add(lblDate);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane_1.setBounds(505, 72, 813, 466);
		panel_1.add(scrollPane_1);
		
		income = new JTextField();
		income.setBounds(1149, 573, 169, 42);
		panel_1.add(income);
		income.setColumns(10);
		
		table_1 = new JTable();
		table_1.setRowHeight(25);
		scrollPane_1.setViewportView(table_1);
		
		
		String h[]=new String[5000];
		
		try
		{
			String query = "Select name,contact from employees ";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			int i=0;
			while(rs.next())
			{
				h[i]=rs.getString("name")+"_"+rs.getString("contact");
				i++;
			}
			pst.close();
			rs.close();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		
		comboBox_2 = new JComboBox(h);
		comboBox_2.setBounds(278, 178, 203, 42);
		panel_1.add(comboBox_2);
		
		
		
		JButton btnOk = new JButton("OK");
		btnOk.setBackground(new Color(0, 128, 0));
		btnOk.setForeground(new Color(240, 248, 255));
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				double u = Double.parseDouble(payment.getText().toString());
				double v = Double.parseDouble(discount.getText().toString());
				double x = Double.parseDouble(tax.getText().toString());
				double y = (u-(u*v)/100);
				double z = (y + (y*x)/100);
				
				String emp=comboBox_2 .getSelectedItem().toString();
				int index=emp.indexOf("_");
				String empname=emp.substring(0,index);
				String empContact=emp.substring(index+1,emp.length());
				
				try
				{
					String query ="insert into table001 (Customername,Customercontact,Employeename,Employeecontact,Service,Payment,Paymenttype,Discount,Tax,Date,Total) values(?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst = conn.prepareStatement(query);
					
					pst.setString(1, customername.getText());
					pst.setString(2, customercontact.getText());
					pst.setString(3, empname);
					pst.setString(4, empContact);
					pst.setString(5, service.getText());
					pst.setString(6, payment.getText());
					pst.setString(7, paymenttype.getText());
					pst.setString(8, discount.getText());
					pst.setString(9, tax.getText());
					pst.setString(10, date.getText());
					pst.setDouble(11, z);
					
					pst.execute();
					pst.close();
					JOptionPane.showMessageDialog(null,"Data Saved!");
					//JOptionPane.showMessageDialog(null,c);
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e);
				}
				try
				{
					String query ="Select * from table001";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
					
					pst.close();
					rs.close();
					
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e);
				}
				
				
				 
				String tbb = empname+empContact;
				try
				{
					String query = "insert into '"+tbb+"' (cname,ccontact,service,payment,paymenttype,discount,date) values(?,?,?,?,?,?,?)";
					PreparedStatement pst = conn.prepareStatement(query);
					
					pst.setString(1, customername.getText());
					pst.setString(2, customercontact.getText());
					pst.setString(3, service.getText());
					pst.setString(4, payment.getText());
					pst.setString(5, paymenttype.getText());
					pst.setString(6, discount.getText());
					pst.setString(7, date.getText());
					
					pst.execute();
					pst.close();
					JOptionPane.showMessageDialog(null,"data saved in individual employee table");
					
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e);
				}
				
				try
				{
					String query ="Select Total from table001";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					while(rs.next())
					{
						String t = rs.getString("Total");
						double o = Double.parseDouble(t);
						 q= q+o;
						
					}
					
					pst.close();
					rs.close();
					
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e);
				}
				 income.setText(q.toString());
				
			}
		});
		btnOk.setBounds(156, 573, 132, 42);
		panel_1.add(btnOk);
		
		JButton btnNewButton_2 = new JButton("CANCEL");
		btnNewButton_2.setBackground(new Color(0, 128, 0));
		btnNewButton_2.setForeground(new Color(240, 248, 255));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				customername.setText(null);
				customercontact.setText(null);
				//employeename.setText(null);
				//employeecontact.setText(null);
				service.setText(null);
				payment.setText(null);
				paymenttype.setText(null);
				discount.setText(null);
				tax.setText(null);
				date.setText(null);
			
			}
		});
		btnNewButton_2.setBounds(316, 573, 132, 42);
		panel_1.add(btnNewButton_2);
		
		date = new JTextField();
		date.setBounds(278, 498, 203, 42);
		panel_1.add(date);
		date.setColumns(10);
		
		date.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				customername.requestFocusInWindow();
			}
		});
		

		
		try
		{
			String query ="Select * from table001";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs));
			
			pst.close();
			rs.close();
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e);
		}
		
		try
		{
			String query ="Select Total from table001";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				String t = rs.getString("Total");
				double o = Double.parseDouble(t);
				 q= q+o;
				
			}
			
			pst.close();
			rs.close();
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e);
		}
		 income.setText(q.toString());
		 
		JLabel lblIncome = new JLabel("Income");
		lblIncome.setOpaque(true);
		lblIncome.setHorizontalAlignment(SwingConstants.CENTER);
		lblIncome.setForeground(new Color(0, 128, 0));
		lblIncome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIncome.setBounds(990, 573, 149, 42);
		panel_1.add(lblIncome);
		
		tax = new JTextField();
		tax.setColumns(10);
		tax.setBounds(278, 443, 203, 42);
		panel_1.add(tax);
		
		discount = new JTextField();
		discount.setColumns(10);
		discount.setBounds(278, 390, 203, 42);
		panel_1.add(discount);
		
		payment = new JTextField();
		payment.setColumns(10);
		payment.setBounds(278, 284, 203, 42);
		panel_1.add(payment);
		
		paymenttype = new JTextField();
		paymenttype.setColumns(10);
		paymenttype.setBounds(278, 337, 203, 42);
		panel_1.add(paymenttype);
		
		service = new JTextField();
		service.setColumns(10);
		service.setBounds(278, 231, 203, 42);
		panel_1.add(service);
		
		customercontact = new JTextField();
		customercontact.setColumns(10);
		customercontact.setBounds(278, 125, 203, 42);
		panel_1.add(customercontact);
		
		customername = new JTextField();
		customername.setColumns(10);
		customername.setBounds(278, 72, 203, 42);
		panel_1.add(customername);
		
		JLabel label1= new JLabel("Tax");
		label1.setOpaque(true);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setForeground(new Color(0, 100, 0));
		label1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label1.setBounds(125, 443, 132, 42);
		panel_1.add(label1);
		
		JLabel lblCustomerDetails_1 = new JLabel("Customer Details");
		lblCustomerDetails_1.setOpaque(true);
		lblCustomerDetails_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerDetails_1.setForeground(new Color(0, 128, 0));
		lblCustomerDetails_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCustomerDetails_1.setBackground(new Color(253, 245, 230));
		lblCustomerDetails_1.setBounds(758, 11, 263, 49);
		panel_1.add(lblCustomerDetails_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Stock", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblItemName = new JLabel("Item name");
		lblItemName.setForeground(new Color(0, 128, 0));
		lblItemName.setOpaque(true);
		lblItemName.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblItemName.setBounds(26, 25, 110, 36);
		panel_3.add(lblItemName);
		
		JLabel lblBrand = new JLabel("Brand");
		lblBrand.setForeground(new Color(0, 128, 0));
		lblBrand.setOpaque(true);
		lblBrand.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrand.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBrand.setBounds(26, 72, 110, 34);
		panel_3.add(lblBrand);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setForeground(new Color(0, 128, 0));
		lblQuantity.setOpaque(true);
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuantity.setBounds(26, 122, 110, 34);
		panel_3.add(lblQuantity);
		
		JLabel lblCpOfEach = new JLabel("CP of each item");
		lblCpOfEach.setForeground(new Color(0, 128, 0));
		lblCpOfEach.setOpaque(true);
		lblCpOfEach.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpOfEach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCpOfEach.setBounds(26, 170, 110, 34);
		panel_3.add(lblCpOfEach);
		
		JLabel lblNewLabel_4 = new JLabel("Distributer");
		lblNewLabel_4.setForeground(new Color(0, 128, 0));
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(26, 221, 110, 36);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblDate_1 = new JLabel("Date");
		lblDate_1.setForeground(new Color(0, 100, 0));
		lblDate_1.setOpaque(true);
		lblDate_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDate_1.setBounds(26, 268, 110, 36);
		panel_3.add(lblDate_1);
		
		itemname = new JTextField();
		itemname.setBounds(146, 25, 195, 36);
		panel_3.add(itemname);
		itemname.setColumns(10);
		
		brand = new JTextField();
		brand.setBounds(146, 72, 195, 36);
		panel_3.add(brand);
		brand.setColumns(10);
		
		quantity = new JTextField();
		quantity.setBounds(146, 120, 195, 36);
		panel_3.add(quantity);
		quantity.setColumns(10);
		
		price = new JTextField();
		price.setBounds(146, 170, 195, 36);
		panel_3.add(price);
		price.setColumns(10);
		
		distributer = new JTextField();
		distributer.setBounds(146, 221, 195, 36);
		panel_3.add(distributer);
		distributer.setColumns(10);
		
		d = new JTextField();
		d.setBounds(146, 268, 195, 36);
		panel_3.add(d);
		d.setColumns(10);
		
		itemname.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				brand.requestFocusInWindow();
			}
		});
		
		brand.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				quantity.requestFocusInWindow();
			}
		});
		
		quantity.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				price.requestFocusInWindow();
			}
		});

		price.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				distributer.requestFocusInWindow();
			}
		});
		
		distributer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				d.requestFocusInWindow();
			}
		});
		
		d.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				itemname.requestFocusInWindow();
			}
		});
		
		
		JButton btnOk_1 = new JButton("OK");
		btnOk_1.setBackground(new Color(0, 128, 0));
		btnOk_1.setForeground(new Color(240, 248, 255));
		btnOk_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnOk_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				a = itemname.getText();
				b = brand.getText();
				
				double i = Double.parseDouble(quantity.getText().toString());
				double j = Double.parseDouble(price.getText().toString());
				double k = i*j;
				try
				{
					String query ="insert into stock(Itemname,Brand,Quantity,Price,Distributer,Date,TOTAL) values(?,?,?,?,?,?,?)";
					PreparedStatement pst = conn.prepareStatement(query);
					
					pst.setString(1, itemname.getText());
					pst.setString(2, brand.getText());
					pst.setString(3, quantity.getText());
					pst.setString(4, price.getText());
					pst.setString(5, distributer.getText());
					pst.setString(6, d.getText());
					pst.setDouble(7, k);
					
					pst.execute();
					pst.close();
					JOptionPane.showMessageDialog(null,"Data saved in stock table");
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e);
				}
				try
				{
					String query ="Select * from stock";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table_3.setModel(DbUtils.resultSetToTableModel(rs));
					
					pst.close();
					rs.close();
					
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e);
				}
				w1 = Double.parseDouble(quantity.getText().toString());
			}
		});
		btnOk_1.setBounds(36, 365, 122, 49);
		panel_3.add(btnOk_1);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setBackground(new Color(0, 128, 0));
		btnCancel.setForeground(new Color(240, 248, 255));
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				itemname.setText(null);
				brand.setText(null);
				quantity.setText(null);
				price.setText(null);
				distributer.setText(null);
				d.setText(null);
			}
		});
		btnCancel.setBounds(194, 365, 110, 49);
		panel_3.add(btnCancel);
		
		
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		scrollPane_3.setBounds(408, 11, 914, 416);
		panel_3.add(scrollPane_3);
		
		table_3 = new JTable();
		table_3.setRowHeight(25);
		scrollPane_3.setViewportView(table_3);
		
		try
		{
			String query ="Select * from stock";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			table_3.setModel(DbUtils.resultSetToTableModel(rs));
			
			pst.close();
			rs.close();
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e);
		}
		
		
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Sale", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblItem = new JLabel("Item");
		lblItem.setForeground(new Color(0, 128, 0));
		lblItem.setOpaque(true);
		lblItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblItem.setHorizontalTextPosition(SwingConstants.CENTER);
		lblItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblItem.setBounds(40, 94, 163, 35);
		panel_4.add(lblItem);
		
		JLabel lblBrandName = new JLabel("Brand name");
		lblBrandName.setForeground(new Color(0, 128, 0));
		lblBrandName.setOpaque(true);
		lblBrandName.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrandName.setHorizontalTextPosition(SwingConstants.CENTER);
		lblBrandName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBrandName.setBounds(40, 140, 163, 38);
		panel_4.add(lblBrandName);
		
		JLabel lblNoOfItems = new JLabel("No. of items sold");
		lblNoOfItems.setForeground(new Color(0, 128, 0));
		lblNoOfItems.setOpaque(true);
		lblNoOfItems.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoOfItems.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNoOfItems.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNoOfItems.setBounds(40, 189, 163, 38);
		panel_4.add(lblNoOfItems);
		
		JLabel lblSpOfEach = new JLabel("SP of each item");
		lblSpOfEach.setForeground(new Color(0, 128, 0));
		lblSpOfEach.setOpaque(true);
		lblSpOfEach.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpOfEach.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSpOfEach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSpOfEach.setBounds(40, 238, 163, 38);
		panel_4.add(lblSpOfEach);
		
		n = new JTextField();
		n.setBounds(213, 189, 208, 38);
		panel_4.add(n);
		n.setColumns(10);
		
		sp = new JTextField();
		sp.setBounds(213, 238, 208, 38);
		panel_4.add(sp);
		sp.setColumns(10);
		
		n.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sp.requestFocusInWindow();
			}
		});
		
		sp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				n.requestFocusInWindow();
			}
		});
		
		String d[]=new String[5000];
		try
		{
			String query = "Select Itemname from stock";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			int i=0;
			while(rs.next())
			{
				d[i]=rs.getString("Itemname");
				i++;
			}
			pst.close();
			rs.close();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		
		
		
		String k[]=new String[5000];
		try
		{
			String query = "Select Brand from stock";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			int i=0;
			while(rs.next())
			{
				k[i]=rs.getString("Brand");
				i++;
			}
			pst.close();
			rs.close();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		
		comboBox = new JComboBox(d);
		comboBox.setBounds(213, 91, 208, 38);
		panel_4.add(comboBox);
		comboBox_1 = new JComboBox(k);
		comboBox_1.setBounds(213, 140, 208, 38);
		panel_4.add(comboBox_1);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(479, 78, 844, 447);
		panel_4.add(scrollPane_4);
		
		table_4 = new JTable();
		scrollPane_4.setViewportView(table_4);
		
		JButton btnOk_2 = new JButton("OK");
		btnOk_2.setBackground(new Color(0, 128, 0));
		btnOk_2.setForeground(new Color(240, 248, 255));
		btnOk_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnOk_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double l = Double.parseDouble(n.getText().toString());
				double m = Double.parseDouble(sp.getText().toString());
				double o = l*m;
				
				String p = comboBox_1.getSelectedItem().toString();
				String q = comboBox.getSelectedItem().toString();
				try
				{
					String query ="insert into sale(itemname,brand,quantity,sp,total) values(?,?,?,?,?)";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1,comboBox.getSelectedItem().toString());
					pst.setString(2,comboBox_1.getSelectedItem().toString());
					pst.setString(3, n.getText());
					pst.setString(4, sp.getText());
					pst.setDouble(5, o);
					
					pst.execute();
					pst.close();
					JOptionPane.showMessageDialog(null,"Data saved in sales table");
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e);
				}
				try
				{
					String query ="Select * from sale";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table_4.setModel(DbUtils.resultSetToTableModel(rs));
					
					pst.close();
					rs.close();
					
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e);
				}
				w2 = Double.parseDouble(n.getText().toString());
				System.out.println(w1);
				System.out.println(w2);
				w3 = w1-w2;
				String s3 = String.valueOf(w3);
				try
				{
					String query = "Update table_3 set Quantity = '"+s3+"' where itemname ='"+p+"' and brand = '"+q+"' ";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"data updated!");
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e);
				}
				
			}
		});
		btnOk_2.setBounds(82, 319, 135, 48);
		panel_4.add(btnOk_2);
		
		JButton btnCancel_1 = new JButton("CANCEL");
		btnCancel_1.setBackground(new Color(0, 128, 0));
		btnCancel_1.setForeground(new Color(240, 248, 255));
		btnCancel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCancel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				n.setText(null);
				sp.setText(null);
			}
		});
		btnCancel_1.setBounds(228, 319, 135, 48);
		panel_4.add(btnCancel_1);
		
		
		
		
		try
		{
			String query ="Select * from sale";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			table_4.setModel(DbUtils.resultSetToTableModel(rs));
			
			pst.close();
			rs.close();
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e);
		}
	
		
	
	}
}
