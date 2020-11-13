package API;

import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import API.DeserializeSingleUser.User;
import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;

import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterTest;

public class DeserializeMultipleUsers {
	public class User{
		String id;
		String email;
		String first_name;
		String last_name;
		String avatar;
	}


	@Test
	public void canDeserializeMultipleUsers() {
		int desiredPage = 2;
		RestAssured.baseURI = "https://reqres.in";
		ResponseBody responseBody = RestAssured.get("/api/users?page=" + desiredPage).getBody();
		JsonArray returnedUsers = new Gson().fromJson(responseBody.asString(), JsonObject.class).get("data").getAsJsonArray();
		List<User> myUsers = new ArrayList<User>();
		for(JsonElement userElement : returnedUsers) {
			JsonObject userObject = userElement.getAsJsonObject();
			User userAsClass = new Gson().fromJson(userObject, User.class);
			myUsers.add(userAsClass);
		}
		
		for(User user : myUsers) {
			System.out.println(user.id + ", Name: "+ user.first_name + " " + user.last_name);
		}

	}
	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

}
