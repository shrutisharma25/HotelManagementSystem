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

public class AddRooms extends JFrame implements ActionListener{
	
	JButton add,cancel;
	JTextField tfRoom,tfPrice;
	JComboBox availableCombo,cleanCombo,typeCombo;
	
	AddRooms(){
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading=new JLabel("Add Rooms");
		heading.setFont(new Font("Tahoma",Font.BOLD,18));
		heading.setBounds(150,20,200,20);
		add(heading);
		
		JLabel room=new JLabel("Room Number");
		room.setFont(new Font("Tahoma",Font.PLAIN,18));
		room.setBounds(60,80,120,30);
		add(room);
		
		tfRoom=new JTextField();
		tfRoom.setBounds(200,80,150,30);
		add(tfRoom);
		
		JLabel labelAvailable=new JLabel("Available");
		labelAvailable.setFont(new Font("Tahoma",Font.PLAIN,18));
		labelAvailable.setBounds(60,130,120,30);
		add(labelAvailable);
		
		String availableOptions[]= {"Available","Occupied"};
		availableCombo=new JComboBox(availableOptions);
		availableCombo.setBounds(200,130,150,30);
		availableCombo.setBackground(Color.white);
		add(availableCombo);
		
		JLabel labelClean=new JLabel("Cleaning Status");
		labelClean.setFont(new Font("Tahoma",Font.PLAIN,18));
		labelClean.setBounds(60,180,120,30);
		add(labelClean);
		
		String cleanOptions[]= {"Cleaned","Dirty"};
		cleanCombo=new JComboBox(cleanOptions);
		cleanCombo.setBounds(200,180,150,30);
		cleanCombo.setBackground(Color.white);
		add(cleanCombo);
		
		JLabel price=new JLabel("Price");
		price.setFont(new Font("Tahoma",Font.PLAIN,18));
		price.setBounds(60,230,120,30);
		add(price);
		
		tfPrice=new JTextField();
		tfPrice.setBounds(200,230,150,30);
		add(tfPrice);
		
		JLabel labelType=new JLabel("Bed Type");
		labelType.setFont(new Font("Tahoma",Font.PLAIN,18));
		labelType.setBounds(60,280,120,30);
		add(labelType);
		
		String typeOptions[]= {"Single Bed","Double Bed"};
		typeCombo=new JComboBox(typeOptions);
		typeCombo.setBounds(200,280,150,30);
		typeCombo.setBackground(Color.white);
		add(typeCombo);
		
		add=new JButton("Add Room");
		add.setForeground(Color.WHITE);
		add.setBackground(Color.black);
		add.setBounds(60,350,130,30);
		add.addActionListener(this);
		add(add);
		

		cancel=new JButton("Cancel");
		cancel.setForeground(Color.WHITE);
		cancel.setBackground(Color.black);
		cancel.setBounds(220,350,130,30);
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Images/room.jpg"));
		Image i1=icon.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
		ImageIcon i2=new ImageIcon(i1);
		JLabel image=new JLabel(i2);
		image.setBounds(400,30,500,350);
		add(image);
				
		setBounds(230,180,940,470);
		setVisible(true);
	}

	public static void main(String[] args) {
		new AddRooms();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==add) {
			
			String roomNumber=tfRoom.getText();
			String availability=(String) availableCombo.getSelectedItem();
			String status=(String) cleanCombo.getSelectedItem();
			String price=tfPrice.getText();
			String type=(String)typeCombo.getSelectedItem();
			
			try {
				Conn conn=new Conn();
				String query="INSERT INTO room values( '"+roomNumber+"', '"+availability+"', '"+status+"', '"+price+"', '"+type+"')";
				conn.statement.execute(query);
				JOptionPane.showMessageDialog(null, "New Room Added Successfully");
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else {
			setVisible(false);
		}
	}

}
