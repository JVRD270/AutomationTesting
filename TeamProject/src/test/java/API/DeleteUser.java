package API;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class DeleteUser {
  @Test
  public void canDeleteUser() {
	  
	  //HTTP Status 204 (No Content)
	  //indicates that the server has successfully fulfilled the request and that there is no content to send in the response payload body. 
	  
	  RestAssured.baseURI = "https://reqres.in";
	  
	  RestAssured.given()
	  .delete("/api/users/2")
	  .then()
	  .assertThat()
	  .statusCode(204);
	  
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
