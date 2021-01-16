package com.restapi.junit;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static org.hamcrest.Matchers.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SerenityRunner.class)
public class RestAPIAssignment4 {
	@BeforeClass
	public static void init(){
		RestAssured.baseURI = "http://postman-echo.com/basic-auth";
		
	}
	
	@Title("This method will validate the user login successfully")
	@Test
	public void TC001(){
		Response resp = RestAssured.given()
				.auth()
				.basic("postman", "password")
				.when()
				.get();
		
		System.out.println("Response: "+resp.asString());
		System.out.println("Status Code: "+resp.getStatusCode());
		Assert.assertEquals(200,resp.getStatusCode());
		System.out.println("------------------");
		
		
		
	}
	
	@Title("This method will validate the user login with invalid credentials")
	@Test
	public void TC002(){
		Response resp = RestAssured.given()
		.auth()
		.basic("postman1", "password")
		.when()
		.get();
		System.out.println("Response: "+resp.asString());
		System.out.println("Status Code: "+resp.getStatusCode());
		Assert.assertEquals(401,resp.getStatusCode());
		
	}
}
