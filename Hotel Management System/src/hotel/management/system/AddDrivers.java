package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class AddDrivers extends JFrame implements ActionListener{
	
	JButton add,cancel;
	JTextField tfName,tfAge,tfCompany,tfType,tfLocation;
	JComboBox genderCombo,typeCombo,availableCombo;
	
	AddDrivers(){
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading=new JLabel("Add Drivers");
		heading.setFont(new Font("Tahoma",Font.BOLD,18));
		heading.setBounds(150,10,200,20);
		add(heading);
		
		JLabel name=new JLabel("Name");
		name.setFont(new Font("Tahoma",Font.PLAIN,18));
		name.setBounds(60,60,120,30);
		add(name);
		
		tfName=new JTextField();
		tfName.setBounds(200,60,150,30);
		add(tfName);
		
		JLabel age=new JLabel("Age");
		age.setFont(new Font("Tahoma",Font.PLAIN,18));
		age.setBounds(60,100,120,30);
		add(age);
		
		tfAge=new JTextField();
		tfAge.setBounds(200,100,150,30);
		add(tfAge);
		
		JLabel labelGender=new JLabel("Gender");
		labelGender.setFont(new Font("Tahoma",Font.PLAIN,18));
		labelGender.setBounds(60,140,120,30);
		add(labelGender);
		
		String genderOptions[]= {"Male","Female"};
		genderCombo=new JComboBox(genderOptions);
		genderCombo.setBounds(200,140,150,30);
		genderCombo.setBackground(Color.white);
		add(genderCombo);
		
		JLabel company=new JLabel("Car Company");
		company.setFont(new Font("Tahoma",Font.PLAIN,18));
		company.setBounds(60,180,120,30);
		add(company);
		
		tfCompany=new JTextField();
		tfCompany.setBounds(200,180,150,30);
		add(tfCompany);
		
		JLabel labelType=new JLabel("Car Model");
		labelType.setFont(new Font("Tahoma",Font.PLAIN,18));
		labelType.setBounds(60,220,120,30);
		add(labelType);
		
		tfType=new JTextField();
		tfType.setBounds(200,220,150,30);
		add(tfType);
		

		JLabel labelAvailable=new JLabel("Available");
		labelAvailable.setFont(new Font("Tahoma",Font.PLAIN,18));
		labelAvailable.setBounds(60,260,120,30);
		add(labelAvailable);
		

		String availableOptions[]= {"Available","Busy"};
		availableCombo=new JComboBox(availableOptions);
		availableCombo.setBounds(200,260,150,30);
		availableCombo.setBackground(Color.white);
		add(availableCombo);
		
		JLabel location=new JLabel("Location");
		location.setFont(new Font("Tahoma",Font.PLAIN,18));
		location.setBounds(60,300,120,30);
		add(location);
		
		tfLocation=new JTextField();
		tfLocation.setBounds(200,300,150,30);
		add(tfLocation);
		
		
		add=new JButton("Add Room");
		add.setForeground(Color.WHITE);
		add.setBackground(Color.black);
		add.setBounds(50,360,130,30);
		add.addActionListener(this);
		add(add);
		

		cancel=new JButton("Cancel");
		cancel.setForeground(Color.WHITE);
		cancel.setBackground(Color.black);
		cancel.setBounds(220,360,130,30);
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Images/driver.jpg"));
		Image i1=icon.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
		ImageIcon i2=new ImageIcon(i1);
		JLabel image=new JLabel(i2);
		image.setBounds(400,20,520,370);
		add(image);
				
		setBounds(200,180,990,470);
		setVisible(true);
	}

	public static void main(String[] args) {
		new AddDrivers();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==add) {
			
			String name=tfName.getText();
			String age=tfAge.getText();
			String gender=(String) genderCombo.getSelectedItem();
			String company=tfCompany.getText();
			String type=tfType.getText();
			String available=(String)availableCombo.getSelectedItem();
			String location=tfLocation.getText();
			try {
				Conn conn=new Conn();
				String query="INSERT INTO driver values( '"+name+"', '"+age+"', '"+gender+"', '"+company+"', '"+type+"','"+available+"','"+location+"')";
				conn.statement.execute(query);
				JOptionPane.showMessageDialog(null, "New Driver Added Successfully");
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else {
			setVisible(false);
		}
	}

}
