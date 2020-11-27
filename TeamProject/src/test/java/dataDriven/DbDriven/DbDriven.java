package dataDriven.DbDriven;

import org.testng.annotations.Test;

import dataDriven.FormPage;
import dataDriven.UserData;
import framework.TestBase;

import org.testng.annotations.BeforeTest;

import java.util.List;

import org.testng.annotations.AfterTest;

public class DbDriven extends TestBase {
  @Test
  public void canRegisterUserFromDb() {
	  List<UserData> studentsToRegister = new DbDataObjectGenerator("", "", "world_x")
				.makeDataObjectsFromTable("students")
				.getUsers();
	  
	  for(UserData student : studentsToRegister) {
			List<String> registeredStudent = new FormPage(webDriver).navigate().submitData(student).getRegisteredInfo();
			System.out.println(registeredStudent);
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
