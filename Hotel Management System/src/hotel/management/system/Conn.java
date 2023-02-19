package hotel.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {
	Connection connection;
	Statement statement;
	Conn()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem","root","tiger");
		    statement=connection.createStatement();		    
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
