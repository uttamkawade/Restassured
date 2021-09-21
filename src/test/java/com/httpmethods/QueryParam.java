package com.httpmethods;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class QueryParam {
	
	
	//Query parameters Filtering resources
	@Test(priority=1)
	public void queryParams(){
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
		Response response=RestAssured.given()
		           .queryParams("userId","2")
		           .queryParams("id","12")
		           .when()
		           .get("posts");
		System.out.println("Status code---->"+response.getStatusCode());
		System.out.println("body------>"+response.getBody().asPrettyString());
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}
	
	//listing nested Resources
	@Test(priority=2)
	public void nestedParams(){
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
		Response response=RestAssured.given()
		     
		           .when()
		           .get("posts/1/comments");
		System.out.println("Status code---->"+response.getStatusCode());
		System.out.println("body------>"+response.getBody().asPrettyString());
		
		Assert.assertEquals(response.getStatusCode(), 200);
}
}