package mySQL;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLTestBase {
	Connection con;
	
	public void beforeTest() {
		connect();
	}
		
	
	public void afterTest() {
		try {
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void connect() {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			this.con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/sakila","","");    
		}
		catch(Exception e) { 
			System.out.println(e);
		}  
	}
}
