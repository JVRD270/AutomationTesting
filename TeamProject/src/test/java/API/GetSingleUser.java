package API;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class GetSingleUser{
  @Test
  public void canGetSingleUser() {
	  String expectedEmail = "janet.weaver@reqres.in";
	  RestAssured.get("https://reqres.in/api/users/2")
			  .then()
			  .assertThat()
			  .body("data.email", equalTo(expectedEmail));
	  
  
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
