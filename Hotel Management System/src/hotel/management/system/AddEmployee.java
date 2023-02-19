package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddEmployee extends JFrame implements ActionListener{
	
	JTextField tfName,tfAge,tfSalary,tfPhone,tfEmail,tfAadhar;
	JRadioButton buttonMale,buttonFemale;
	JComboBox boxJob;
	JButton submit;
	
	AddEmployee(){
		setLayout(null);
		
		JLabel labelName=new JLabel("Name");
		labelName.setBounds(60,30,120,30);
		labelName.setFont(new Font("Tahoma",Font.BOLD,17));
		add(labelName);
		
		tfName=new JTextField();
		tfName.setBounds(200, 30, 150, 30);
		add(tfName);
		
		JLabel labelAge=new JLabel("Age");
		labelAge.setBounds(60,80,120,30);
		labelAge.setFont(new Font("Tahoma",Font.BOLD,17));
		add(labelAge);
		
		tfAge=new JTextField();
		tfAge.setBounds(200, 80, 150, 30);
		add(tfAge);
		
		JLabel labelGender=new JLabel("Gender");
		labelGender.setBounds(60,130,120,30);
		labelGender.setFont(new Font("Tahoma",Font.BOLD,17));
		add(labelGender);
		
		buttonMale=new JRadioButton("Male");
		buttonMale.setBounds(200,130,70,30);
		buttonMale.setFont(new Font("Tahoma",Font.PLAIN,14));
		buttonMale.setBackground(Color.WHITE);
		add(buttonMale);
		
		buttonFemale=new JRadioButton("Female");
		buttonFemale.setBounds(280,130,70,30);
		buttonFemale.setFont(new Font("Tahoma",Font.PLAIN,14));
		buttonFemale.setBackground(Color.WHITE);
		add(buttonFemale);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(buttonFemale);
		bg.add(buttonMale);
		
		JLabel labelJob=new JLabel("Job");
		labelJob.setBounds(60,180,120,30);
		labelJob.setFont(new Font("Tahoma",Font.BOLD,17));
		add(labelJob);
		
		String str[]= {"Front Desk Clerks","Porters","House Kepping","Kitchen Staff","Room Service","Chefs","Waiter/Waitress","Manager","Accountant"};
		boxJob=new JComboBox(str);
		boxJob.setBounds(200,180,150,30);
		boxJob.setBackground(Color.WHITE);
		add(boxJob);
		
		JLabel labelSalary=new JLabel("Salary");
		labelSalary.setBounds(60,230,120,30);
		labelSalary.setFont(new Font("Tahoma",Font.BOLD,17));
		add(labelSalary);
		
		tfSalary=new JTextField();
		tfSalary.setBounds(200, 230, 150, 30);
		add(tfSalary);
		
		JLabel labelPhone=new JLabel("Phone");
		labelPhone.setBounds(60,280,120,30);
		labelPhone.setFont(new Font("Tahoma",Font.BOLD,17));
		add(labelPhone);
		
		tfPhone=new JTextField();
		tfPhone.setBounds(200, 280, 150, 30);
		add(tfPhone);
		
		JLabel labelEmail=new JLabel("Email");
		labelEmail.setBounds(60,330,120,30);
		labelEmail.setFont(new Font("Tahoma",Font.BOLD,17));
		add(labelEmail);
		
		tfEmail=new JTextField();
		tfEmail.setBounds(200, 330, 150, 30);
		add(tfEmail);
		
		JLabel labelAadhar=new JLabel("Aadhar No.");
		labelAadhar.setBounds(60,380,120,30);
		labelAadhar.setFont(new Font("Tahoma",Font.BOLD,17));
		add(labelAadhar);
		
		tfAadhar=new JTextField();
		tfAadhar.setBounds(200, 380, 150, 30);
		add(tfAadhar);
		
		submit=new JButton("SUBMIT");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setBounds(140,440,150,30);
		submit.setFont(new Font("Tahoma",Font.BOLD,20));
		submit.addActionListener(this);
		add(submit);
		
		ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Images/employee.jpg"));
		Image i1=icon.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
		ImageIcon i2=new ImageIcon(i1);
		JLabel image=new JLabel(i2);
		image.setBounds(400,40,420,420);
		add(image);
		
		getContentPane().setBackground(Color.WHITE);
		setBounds(290,180,850,540);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String name=tfName.getText();
		String age=tfAge.getText();
		String salary=tfSalary.getText();
		String phone =tfPhone.getText();
		String email=tfEmail.getText();
		String aadhar=tfAadhar.getText();
		
		String gender=null;
		if(buttonMale.isSelected()) {
			gender="Male";
		}else if(buttonFemale.isSelected()) {
			gender="Female";
		}
		
		String job=(String)boxJob.getSelectedItem();
		
		try {
			Conn conn=new Conn();
			String query="INSERT INTO employee values( '"+name+"', '"+age+"', '"+gender+"', '"+job+"','"+salary+"', '"+phone+"','"+email+"', '"+aadhar+"')";
			conn.statement.executeUpdate(query);
			
			JOptionPane.showMessageDialog(null, "Employee added successfully");
			setVisible(false);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) {
		new AddEmployee();
	}

}
