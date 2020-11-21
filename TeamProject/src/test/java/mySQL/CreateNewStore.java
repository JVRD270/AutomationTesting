package mySQL;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.AfterTest;

public class CreateNewStore extends MySQLTestBase {
  @Test
  public void canCreateNewStore() {
	  try{
		   con.setAutoCommit(false);
		   Statement stmt = con.createStatement();
		   
		   String SQL = "INSERT INTO \n"
		   		+ "    staff(staff_id, first_name, last_name, address_id, store_id, username) \n"
		   		+ "    values(3, 'John', 'Doe', 10, 2, 'John');\n";
		   stmt.executeUpdate(SQL);  
		   String SQL2 = "INSERT INTO\n"
		   		+ "    store(store_id, manager_staff_id, address_id) \n"
		   		+ "    values(3, 3, 3);";
		   stmt.executeUpdate(SQL2);
		   String SQL3 = "UPDATE staff SET store_id = 3 WHERE staff_id=3;";
		   stmt.executeUpdate(SQL3);
		   con.rollback();
		}catch(SQLException se){
		   System.out.println(se);
		}
  }
  @BeforeTest
  public void beforeTest() {
	  super.beforeTest();
  }

  @AfterTest
  public void afterTest() {
	  super.afterTest();
  }

}
