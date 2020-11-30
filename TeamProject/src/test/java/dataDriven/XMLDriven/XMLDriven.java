package dataDriven.XMLDriven;

import org.testng.annotations.Test;

import dataDriven.FormPage;
import dataDriven.UserData;
import framework.TestBase;

import org.testng.annotations.BeforeTest;

import java.util.List;

import org.testng.annotations.AfterTest;

public class XMLDriven extends TestBase {
  @Test
  public void canRegisterStudentFromXml() throws Exception {
			List<UserData> studentsToRegister = new XmlDataObjectGenerator("src/test/resources/Students.xml")
					.makeDataObjectsFromXml()
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

