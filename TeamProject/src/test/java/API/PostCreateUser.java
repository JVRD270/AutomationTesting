package API;

import org.testng.annotations.Test;


import com.google.gson.JsonObject;

import io.restassured.RestAssured;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;



public class PostCreateUser {
  @Test
  public void canCreateUser() {
	  String expectedToken = "QpwL5tke4Pnpja7X4";
	  
	  JsonObject jsonObject = new JsonObject();
	  jsonObject.addProperty("email", "eve.holt@reqres.in");
	  jsonObject.addProperty("password", "cityslicka");
	  
	  RestAssured.baseURI = "https://reqres.in";
	  
	  String token = RestAssured.given()
	  .header("Content-Type","application/json")
	  .body(jsonObject)
	  .post("/api/login")
	  .then()
	  .assertThat()
	  .statusCode(200)
	  .extract()
	  .path("token");
	  
	  Assert.assertEquals(token, expectedToken);
	
	  
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
