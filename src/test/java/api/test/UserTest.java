package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endPoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest {
	
	User payload;
	Faker faker;
	public static Logger logger;
	@BeforeClass
	public void dataCreation()
	{
		faker=new Faker();
		payload=new User();
		payload.setId(faker.hashCode());
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		payload.setUsername(faker.name().username());
		payload.setEmail(faker.internet().emailAddress());
		payload.setPassword(faker.internet().password());
		payload.setPhone(faker.phoneNumber().cellPhone());
		payload.setUserStatus(0);
		
		//logs
				logger=LogManager.getLogger("FrameWorkAPI");
		
	}
	
	@Test(priority=1 )
	public void creatUserTest()
	{
		logger.info("----Create user test Started----------------");
		Response response=UserEndPoints.createUser(payload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 201);
		Assert.assertEquals(response.statusLine(), "HTTP/1.1 200 OK");
		Assert.assertEquals(response.contentType(), "application/json");
		logger.info("----Create user test end----------------");
		
	}
	@Test(priority=2 ,enabled=false)
	public void updateUserTest()
	{
		logger.info("----update user test Started----------------");
		Response response=UserEndPoints.updateUser(payload,this.payload.getUsername());
		response.then().log().all();
		
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.statusLine(), "HTTP/1.1 200 OK");
		Assert.assertEquals(response.contentType(), "application/json");
		logger.info("----update user test ended----------------");
	}
	@Test(priority=3)
	public void getUserTest()
	{
		logger.info("----get user test Started----------------");
		Response response=UserEndPoints.getUser(this.payload.getUsername());
		response.then().log().all();
		
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.statusLine(), "HTTP/1.1 200 OK");
		Assert.assertEquals(response.contentType(), "application/json");
		logger.info("----get user test ended----------------");
	}
	@Test(priority=4)
	public void deleteUserTest()
	{
		logger.info("----delete user test Started----------------");
		Response response=UserEndPoints.deleteUser(this.payload.getUsername());
		response.then().log().all();
		
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("----delete user test ended----------------");
	}

}
