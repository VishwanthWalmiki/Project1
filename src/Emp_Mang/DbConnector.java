package Emp_Mang;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnector {
	static Connection con;
	
	public static Connection CreateDbConnection() {
		try {
			//to load driver 
			Class.forName("com.mysql.cj.jdbc.Driver");
			//to get connection
			String url="jdbc:mysql://localhost:3306/employee_management?useSSL=false";
			String username="root";
			String password="Vishwa@123";
			con=DriverManager.getConnection(url,username,password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
		
	}

}
