package dataDriven.DbDriven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dataDriven.UserData;

public class DbDataObjectGenerator {
	String connectionURL = "jdbc:mysql://localhost:3306/";
	String user;
	String PW;
	String DB;
	List<UserData> users = new ArrayList<UserData>();
	

	public DbDataObjectGenerator(String user, String PW, String DB) {
		this.user = user;
		this.PW = PW;
		this.DB = DB;
	}

	public DbDataObjectGenerator makeDataObjectsFromTable(String string) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB, user, PW); 
			Statement stmt=con.createStatement(); 
			ResultSet rs=stmt.executeQuery("SELECT first_name, last_name, isMale, birthdate, address, c.name, phone FROM students s\r\n"
					+ "LEFT JOIN city c ON s.city_id = c.ID"); 
			while(rs.next()) { 
				HashMap<String, String> userValues = new HashMap<String, String>();
				userValues.put("lastFirst", rs.getString(2) + "," + rs.getString(1));
				userValues.put("gender", rs.getInt(3) == 1 ? "M" : "F");
				userValues.put("dob", new SimpleDateFormat("MM/dd/yyyy").format(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString(4))));
				userValues.put("houseNumber", rs.getString(5).split(" ")[0]);
				userValues.put("street", rs.getString(5).substring(rs.getString(5).indexOf(" ")));
				userValues.put("city", rs.getString(6));
				userValues.put("mobile", rs.getString(7).replaceAll("-", ""));
				
				users.add(new UserData(userValues));
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return this;
	}
	
	public List<UserData> getUsers(){
		return users;
	}
	
}
