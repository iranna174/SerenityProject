package com.restapi.junit;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import net.serenitybdd.junit.runners.SerenityRunner;


import org.assertj.core.api.Assert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import io.restassured.matcher.RestAssuredMatchers.*;

import com.restapi.testbase.AssignmentTestBase;

@RunWith(SerenityRunner.class)
public class RestAPIAssignment1 extends AssignmentTestBase{
	
	@Test
	public void getRepublicOfIndiaText(){
		RestAssured.given()
		.when()
		.get("/INDIA")
		.then()
		.assertThat()
		.body(Matchers.containsString("Republic of India"));
		
		
		System.out.println("Response: "+RestAssured.given().get("/INDIA").asString());
	
//		.body("", anything("Republic of India"));
//		.statusLine("Republic of India");
		/*Response response = SerenityRest.given()
				.when()
				.get("/INDIA");
			*/
//		HashMap<String,Object> value=(HashMap<String, Object>) RestAssured.given().when().get("/INDIA").then().log().all().extract();
//		assertThat(value,hasValue("Republic of India"));
////		Assert.assertEquals(response.contains("Republic of India"),true,"Response body");
//		Assert.assertTrue(response.contains("Republic of India"), true);
				//.body("[0]",hasValue("Republic of India"));
		
//				.body("$",hasValue("Republic of India"));
//		assertThat(response.then().body(containsString("Republic of India")),is(true));
//		.body("RestResponse.result",is("Republic of India"));
		/*SerenityRest.given()
		.when()
		.get("/INDIA")
		.then()
		.log()
		.all();*/
	}
	@Test
	public void getResponseForInvalidCountry(){
		RestAssured.given()
		.when()
		.get("/xyz")
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(404)
		.body("message",equalTo("Not Found"));
	}
}
