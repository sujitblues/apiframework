package api.endPoints;

import static io.restassured.RestAssured.given;


import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {
	
	public static Response createUser(User payload)
	{
		Response response=given()
			.header("Content-Type","application/json")
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.createUser_url);
		
		return response;
	}
	public static Response updateUser(User payload,String username)
	{
		Response response=given()
			.header("Content-Type","application/json")
			.accept(ContentType.JSON)
			.body(payload)
			.pathParam("username", username)
		.when()
			.put(Routes.updateUser_url);
		
		return response;
	}
	public static Response getUser(String username)
	{
		Response response=given()
			.header("Content-Type","application/json")
			.accept(ContentType.JSON)
			.pathParam("username", username)
		.when()
			.get(Routes.getUser_url);
		
		return response;
	}
	public static Response deleteUser(String username)
	{
		Response response=given()
			.header("Content-Type","application/json")
			.accept(ContentType.JSON)
			.pathParam("username", username)
		.when()
			.delete(Routes.deleteUser_url);
		
		return response;
	}
}
