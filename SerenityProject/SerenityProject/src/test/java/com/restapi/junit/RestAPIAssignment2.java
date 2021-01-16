package com.restapi.junit;

import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;

import net.thucydides.core.annotations.Title;



import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.restapi.testbase.AssignmentTestBase;

import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
public class RestAPIAssignment2 extends AssignmentTestBase {
		
	@Title("This test will check the capital of Norwa")
	@Test
	public void checkcapital(){
		RestAssured.given()
		.when()
		.get("/norwa")
		.then()
		.assertThat()
		.statusCode(200)
		.body("capital",hasItem("Oslo"));
		
		Response resp= RestAssured.given()
				.when()
				.get("/norwa");
		System.out.println("Status Code: "+resp.getStatusCode());
		System.out.println("Response: "+resp.asString());
	
	}
}
