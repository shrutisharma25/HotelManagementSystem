package hotel.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{
	
	JTextField user,pass;
	JButton login,cancel;

	public Login() {
	 initialize();
	 gUI();
	}
	public void initialize() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setTitle("Login");
		setBounds(350,200,600,300);
		
		JLabel username= new JLabel("Username:-");
		username.setBounds(40, 30, 100, 30);
		add(username);

		user= new JTextField();
		user.setBounds(150, 30, 150, 30);
		add(user);
		
		JLabel password= new JLabel("Password:-");
		password.setBounds(40, 80, 100, 30);
		add(password);
		
		pass= new JTextField();
		pass.setBounds(150, 80, 150, 30);
		add(pass);
		
		login=new JButton("Login");
		login.setBounds(40,160,120,30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
		
		cancel=new JButton("Cancel");
		cancel.setBounds(180,160,120,30);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon logo=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Images/logo.jpg"));
		Image size=logo.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
		ImageIcon changed=new ImageIcon(size);
		JLabel image=new JLabel(changed);
		image.setBounds(350,10,200,200);
		add(image);
	}
	public void gUI() {
		
		setVisible(true);
	}
	

	public static void main(String[] args) {
	   new Login();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==login) { //getSource is a function in ActionEvent class for checking the buttons
			String username = user.getText();
			String password = pass.getText();
			
			try {
				Conn connection= new Conn();
				String query="select * from login where username = '"+username+"' and password = '"+password+"'";
				ResultSet rs = connection.statement.executeQuery(query);
				
				if(rs.next()) {
					setVisible(false);
					new Dashboard();
				}else {
					JOptionPane.showMessageDialog(null,"Invalid username or password");
					setVisible(false);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==cancel) {	
			setVisible(false);
		}
	}

}
