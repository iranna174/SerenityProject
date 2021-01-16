package com.restapi.testbase;

import io.restassured.RestAssured;

import org.junit.BeforeClass;

public class AssignmentTestBase {
	@BeforeClass
	public static void init(){
		RestAssured.baseURI = "http://restcountries.eu/rest/v1/name";
	}

}
