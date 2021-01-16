package com.restapi.junit;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class RestAPIAssignment3 {
	@BeforeClass
	public static void init(){
		RestAssured.baseURI = "https://reqres.in/api/users";
	}
	
	@Test
	public void userEnrollment(){
		JSONObject request = new JSONObject();
		request.put("name", "Test");
		request.put("job", "Software Enginner");
		
		Response resp = RestAssured.given()
				.body(request.toString())
				.when()
				.post("/users");

		System.out.println("Response: "+resp.asString());
		System.out.println("Status Code: "+resp.getStatusCode());
		Assert.assertEquals(201, resp.getStatusCode());
	}
}
