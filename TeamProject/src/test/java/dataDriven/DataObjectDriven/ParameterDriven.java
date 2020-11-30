package dataDriven.DataObjectDriven;

import org.testng.annotations.Test;

import dataDriven.FormPage;
import dataDriven.UserData;
import framework.TestBase;

import org.testng.annotations.BeforeTest;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.AfterTest;

import org.testng.annotations.DataProvider;


public class ParameterDriven extends TestBase {
	@DataProvider(name="Students")
	public Object[][] dataProviderMethod(){
		return new Object[][] {
			{
				"Doe, Joe", "jdoe@j.com", "M", "1234567890", "01/10/1982"
			},
			{
				"Doe, John", "jdoh@j.com", "M", "1234567891", "02/10/1991"
			},
			{
				"Doe, Jane", "mdoe@j.com", "F", "1234567892", "03/07/1971"
			}
		};
	}	
	
	
	@Test(dataProvider = "Students")
	public void canRegisterStudentFromParameters(String lastFirst, String email, String gender, String mobile, String bday) throws ParseException {
		HashMap<String, String> dataValues = new HashMap<String, String>();
		dataValues.put("lastFirst", lastFirst);
		dataValues.put("email", email);
		dataValues.put("gender", gender);
		dataValues.put("mobile", mobile);
		dataValues.put("dob", bday);
		
		UserData studentToRegister = new UserData(dataValues);
		List<String> registeredStudent = new FormPage(webDriver).navigate().submitData(studentToRegister).getRegisteredInfo();
		System.out.println(registeredStudent);
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
