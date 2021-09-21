package com.httpmethods;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Postmethod {
	
	
	@Test
	public void postMethod() {
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
		Response response=RestAssured.given()
		.header("Content-type","application/json; charset=UTF-8")
		.body("{\r\n"
		+"   \"title\": \"foo\",\r\n"
	    +"    \"body\": \"bar\",\r\n"
		+"    \"userId\": \"1\"\r\n"
		+"}")
		.when()
		.post("posts");
		System.out.println("response------>"+response);
		System.out.println("body--------->"+response.getBody().asPrettyString());
		System.out.println("Status---->"+response.getStatusCode());
		System.out.println("Time------>"+response.time());
		System.out.println("all headers---->"+response.headers());
		
		Assert.assertEquals(response.getStatusCode(), 201);
		
	}

}
