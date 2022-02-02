package com.juaracoding.restassured;

import static org.testng.Assert.assertEquals;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test01_GET {

	/*
	 * https://www.youtube.com/watch?v=JJ7Tp7_fX4c&ab_channel=AutomationStepbyStep
	 */
	
	String endpoint = "https://reqres.in/api/user?page=1";
	
	@Test
	public void test_01() {
		
		Response response = RestAssured.get(endpoint);
//		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
		
		int statusCode = response.getStatusCode();
		
		assertEquals(statusCode, 200);
	}
	
	@Test
	public void test_02() {
		
		given()
		.get(endpoint)
		.then()
		.statusCode(200)
		.body("data.id[0]", equalTo(1));
	}
}
