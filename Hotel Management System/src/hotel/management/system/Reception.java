package hotel.management.system;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Reception extends JFrame {
	
	JButton newCustomer,rooms,department,allEmployee,customers,manager,checkout,update,roomUpdate,pickup,searchRoom,logout;
	
	Reception(){
		
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		newCustomer=new JButton("New Customer form");
		newCustomer.setBounds(10,30,200,30);
		newCustomer.setBackground(Color.BLACK);
		newCustomer.setForeground(Color.WHITE);
		add(newCustomer);
		
		rooms=new JButton("Rooms");
		rooms.setBounds(10,70,200,30);
		rooms.setBackground(Color.BLACK);
		rooms.setForeground(Color.WHITE);
		add(rooms);
		
		department=new JButton("Department");
		department.setBounds(10,110,200,30);
		department.setBackground(Color.BLACK);
		department.setForeground(Color.WHITE);
		add(department);
		
		allEmployee=new JButton("All Employees");
		allEmployee.setBounds(10,150,200,30);
		allEmployee.setBackground(Color.BLACK);
		allEmployee.setForeground(Color.WHITE);
		add(allEmployee);
		
		customers=new JButton("Customer Info");
		customers.setBounds(10,190,200,30);
		customers.setBackground(Color.BLACK);
		customers.setForeground(Color.WHITE);
		add(customers);
		
		manager=new JButton("Manager Info");
		manager.setBounds(10,230,200,30);
		manager.setBackground(Color.BLACK);
		manager.setForeground(Color.WHITE);
		add(manager);
		
		checkout=new JButton("Checkout");
		checkout.setBounds(10,270,200,30);
		checkout.setBackground(Color.BLACK);
		checkout.setForeground(Color.WHITE);
		add(checkout);
		
		update=new JButton("Update Status");
		update.setBounds(10,310,200,30);
		update.setBackground(Color.BLACK);
		update.setForeground(Color.WHITE);
		add(update);	
		
		roomUpdate=new JButton("Update Room Status");
		roomUpdate.setBounds(10,350,200,30);
		roomUpdate.setBackground(Color.BLACK);
		roomUpdate.setForeground(Color.WHITE);
		add(roomUpdate);	
		
		pickup=new JButton("Pickup Services");
		pickup.setBounds(10,390,200,30);
		pickup.setBackground(Color.BLACK);
		pickup.setForeground(Color.WHITE);
		add(pickup);	
		
		searchRoom=new JButton("Search Room");
		searchRoom.setBounds(10,430,200,30);
		searchRoom.setBackground(Color.BLACK);
		searchRoom.setForeground(Color.WHITE);
		add(searchRoom);	
		
		logout=new JButton("Logout");
		logout.setBounds(10,470,200,30);
		logout.setBackground(Color.BLACK);
		logout.setForeground(Color.WHITE);
		add(logout);	
			
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Images/reception.jpg"));
		JLabel image = new JLabel(i1);
		image.setBounds(250,30,500,470);
		add(image);
		
		setBounds(310,170,800,570);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Reception();
	}

}
