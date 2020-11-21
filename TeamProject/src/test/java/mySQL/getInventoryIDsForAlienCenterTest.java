package mySQL;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;

import org.testng.annotations.AfterTest;

public class getInventoryIDsForAlienCenterTest extends MySQLTestBase {
	@Test
	public void canGetInventoryIDsForFilmAlienCenterFromStore2() {
		try {
					
			int filmId = 0;
			String getFilmIdQuery = "SELECT f.film_id FROM film AS f WHERE f.title = 'Alien Center'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(getFilmIdQuery);
			if(rs.next()) {
				filmId = rs.getInt(1);
			}
			
			String getFilmCountQuery = "{? = CALL sakila.film_in_stock(?, ?)}";
			CallableStatement cstmt = con.prepareCall(getFilmCountQuery);
			cstmt.registerOutParameter(1, Types.INTEGER);
			cstmt.setInt(2, filmId);
			cstmt.setInt(3, 2);
			ResultSet queryExecution = cstmt.executeQuery(getFilmCountQuery);
			int filmCount = cstmt.getInt(3);
			System.out.println(filmCount);
			while(queryExecution.next())  
				System.out.println(queryExecution.getInt(1));  
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
