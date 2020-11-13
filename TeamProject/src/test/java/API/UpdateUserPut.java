package API;

import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;

import org.testng.annotations.BeforeTest;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import org.testng.annotations.AfterTest;

public class UpdateUserPut {
  @Test
  public void canUpdateUser() {
	  
	  JsonObject jsonObject = new JsonObject();
	  jsonObject.addProperty("name", "morpheus2");
	  
	  RestAssured.baseURI = "https://reqres.in";
	  
	  //sends put request to return the current timestamp
	  String oldTimeStamp = RestAssured.given()
              .header("Content-Type","application/json")
              .body("")
              .put("/api/users/2")
              .then()
              .extract()
              .path("updatedAt");
	  
	  //sends another put that does update the name and checks if timestamp changed
	  RestAssured.given()
	  .header("Content-Type","application/json")
	  .body(jsonObject)
	  .put("/api/users/2")
	  .then()
	  .assertThat()
	  .statusCode(200)
	  .body("name", equalTo("morpheus2"))
	  .body("updatedAt", not(oldTimeStamp));
	  
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
