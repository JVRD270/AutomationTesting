package mySQL;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.AfterTest;

public class AirplaneTitleTest extends MySQLTestBase{
  @Test
  public void canGetAllFilmsThatTitleContainsAirplane() {
	  try {
	  Statement stmt = con.createStatement();
	  String query = "SELECT title FROM sakila.film WHERE title LIKE '%airplane%';";
	  ResultSet queryExecution = stmt.executeQuery(query);
	  while(queryExecution.next())  
		  System.out.println(queryExecution.getString(1));  
	  }
	  catch(Exception e) {
		  System.out.println(e);
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
