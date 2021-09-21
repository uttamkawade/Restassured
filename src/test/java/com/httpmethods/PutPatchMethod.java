package com.httpmethods;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PutPatchMethod {
	
	@Test
	public void putMethod(){
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
		Response response =RestAssured.given()
				           .header("Content-type","application/json; charset=UTF-8")
				           .body("{\r\n" + 
				           		"    \"id\": \"1\",\r\n" + 
				           		"    \"title\": \"foo\",\r\n" + 
				           		"    \"body\": \"bar\",\r\n" + 
				           		"    \"userId\": \"1\"\r\n" + 
				           		"}")
				           .when()
				           .put("posts/1");
		
		System.out.println("Status code----->"+response.getStatusCode());
		System.out.println("body----->"+response.getBody().asPrettyString());
		System.out.println("headers----->"+response.header("Date"));
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	
	
	
	
	@Test(priority=2)
	public void patchMethod(){
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
		Response response =RestAssured.given()
				           .header("Content-type","application/json; charset=UTF-8")
				           .body("{\r\n" + 
				           		"     \"title\": \"foo\"\r\n" + 
				           		"}")
				           .when()
				           .patch("posts/1");
		System.out.println("Status code----->"+response.getStatusCode());
		System.out.println("body----->"+response.getBody().asPrettyString());
		System.out.println("heders----->"+response.header("Date"));
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}

}
