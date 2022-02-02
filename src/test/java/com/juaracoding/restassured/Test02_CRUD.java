package com.juaracoding.restassured;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test02_CRUD {

	/*
	 * https://reqres.in/
	 * https://www.youtube.com/watch?v=mkIliGAePBM&ab_channel=AutomationStepbyStep
	 */
	
	@Test
	public void test01_post() {
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Budi");
		request.put("job", "SQA Engineer");
		
//		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given()
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.post("https://reqres.in/api/users") //POST
		.then()
		.statusCode(201)
		.log().all();
	}
	
	@Test
	public void test02_put() {
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Chika");
		request.put("job", "SQA Engineer");
		
//		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given()
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.put("https://reqres.in/api/users/2") //PUT
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test
	public void test03_patch() {
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Chika");
		request.put("job", "SQA Engineer");
		
//		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given()
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.patch("https://reqres.in/api/users/2") //PATCH
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test
	public void test04_delete() {
		
		when()
		.delete("https://reqres.in/api/users/2") //DELETE
		.then()
		.statusCode(204)
		.log().all();
	}
}
