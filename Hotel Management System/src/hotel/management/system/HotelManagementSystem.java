package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HotelManagementSystem extends JFrame implements ActionListener
{
	
	private JFrame jFrame;
	private JLabel jLabel;
	
	HotelManagementSystem()
	{
		System.out.println("Hotel Management System");
		initialize();
		gUI();
	}
	public void initialize()
	{
		jFrame = new JFrame();
		this.jFrame.setTitle("Hotel Management System");
		this.jFrame.setBounds(150,100,1000, 500);
		this.jFrame.setLayout(null);
	}
	public void gUI()
	{
		ImageIcon jIcon = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Images/bg.jpg"));
		Image image= jIcon.getImage().getScaledInstance(1000, 500, Image.SCALE_DEFAULT);
		ImageIcon icon= new ImageIcon(image);
		jLabel =new JLabel(icon);
		jLabel.setBounds(0,0,1000, 500);
		jFrame.add(jLabel);
		                             // -------------------------------------------------------------//
		JLabel text= new JLabel("HOTEL MANAGEMENT SYSTEM");
		text.setBounds(15, 380, 800, 70);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("serif", Font.BOLD, 45));
		jLabel.add(text);
		                            //---------------------------------------------------------------//
		JButton next= new JButton("Next");
		next.setBounds(800, 390, 140, 50);
		next.setBackground(Color.WHITE);
		next.setForeground(Color.DARK_GRAY);
		next.setFont(new Font("serif", Font.PLAIN, 30));
		next.addActionListener(this);
		jLabel.add(next);
		this.jFrame.setVisible(true);
		while(true)
		{
			text.setVisible(false);
			try {
				Thread.sleep(500);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			text.setVisible(true);
			try {
				Thread.sleep(500);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	 public void actionPerformed(ActionEvent e)
	 {
		jFrame.setVisible(false);
		new Login();
	 }
}
