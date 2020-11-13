package API;

import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import static org.hamcrest.Matchers.*;

public class UpdateUserPatch {
  @Test
  public void canUpdateUserName() {
	  JsonObject jsonObject = new JsonObject();
	  jsonObject.addProperty("name", "morpheus2");
	  
	  RestAssured.baseURI = "https://reqres.in";
	  
	  //sends patch request to return the current timestamp
	  String oldTimeStamp = RestAssured.given()
              .header("Content-Type","application/json")
              .body("")
              .patch("/api/users/2")
              .then()
              .extract()
              .path("updatedAt");
	  
	  //sends another patch that does update the name and checks if timestamp changed
	  RestAssured.given()
	  .header("Content-Type","application/json")
	  .body(jsonObject)
	  .patch("/api/users/2")
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
