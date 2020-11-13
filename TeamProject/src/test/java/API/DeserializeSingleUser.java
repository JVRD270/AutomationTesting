package API;

import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.AfterTest;

public class DeserializeSingleUser {

	public class User{
		JsonObject data;
		JsonObject support;
	}


	@Test
	public void deserializeSingleUser() {
		RestAssured.baseURI = "https://reqres.in";
		ResponseBody responseBody = RestAssured.get("/api/users/2").getBody();
		User myUser = new Gson().fromJson(responseBody.asString(), User.class);

		System.out.println(myUser.data.get("id"));


	}
	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

}
