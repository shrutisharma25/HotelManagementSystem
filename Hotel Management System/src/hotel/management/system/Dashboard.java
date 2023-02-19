package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener {

	public Dashboard() {
		initialize();
		gUI();
	}
	public void initialize() {
		setLayout(null);
		setBounds(0,0,1360,774);
		setTitle("Dashboard");
	}
	public void gUI() {
		ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Images/back.jpg"));
		Image bg=image.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
		ImageIcon background=new ImageIcon(bg);
		JLabel jLabel=new JLabel(background);
		jLabel.setBounds(0,0,1550,1000);
		add(jLabel);

		JLabel text = new JLabel("THE TAJ GROUPS WELCOMES YOU");
		text.setBounds(270,80,1000,50);
		text.setFont(new Font("Tahoma", Font.BOLD, 50));
		text.setForeground(Color.WHITE);
		jLabel.add(text);

		JMenuBar mb= new JMenuBar();
		mb.setBackground(Color.BLACK);
		mb.setBounds(0,0,1550,35);
		jLabel.add(mb);

		JMenu hotel=new JMenu("HOTEL MANAGEMENT");
		hotel.setForeground(Color.WHITE);
		hotel.setFont(new Font("serif", Font.BOLD, 15));
		mb.add(hotel);

		JMenuItem reception=new JMenuItem("Reception");
		reception.addActionListener(this);
		hotel.add(reception);

		JMenu admin=new JMenu("ADMIN");
		admin.setForeground(Color.MAGENTA);
		admin.setFont(new Font("serif", Font.BOLD, 15));
		mb.add(admin);

		JMenuItem addEmp=new JMenuItem("ADD EMPLOYEE");
		addEmp.addActionListener(this);
		admin.add(addEmp);
		JMenuItem addRooms=new JMenuItem("ADD ROOMS");
		addRooms.addActionListener(this);
		admin.add(addRooms);
		JMenuItem addDrivers=new JMenuItem("ADD DRIVERS");
		addDrivers.addActionListener(this);
		admin.add(addDrivers);

		setVisible(true);
	}
	public static void main(String[] args) {
		new Dashboard();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("ADD EMPLOYEE")){//for Checking menu items:- It will return the text value from the menu
			new AddEmployee();
		}
		else if(ae.getActionCommand().equals("ADD ROOMS")) {
			new AddRooms();
		}
		else if(ae.getActionCommand().equals("ADD DRIVERS")) {
			new AddDrivers();
		}
		else if(ae.getActionCommand().equals("Reception")) {
			new Reception();
		}
	}
}

