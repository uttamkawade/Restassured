package com.httpmethods;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Getmethod {
	@BeforeMethod                                                                                                          
	public void setup() {
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
	}
	
	@Test
	public void getMethod() {
		Response response = RestAssured.given()
					.when()
					.get("posts/1");
		System.out.println("status code --->"+response.getStatusCode());
		System.out.println("body ---->"+response.getBody().asString());
		System.out.println("coockies---->"+response.getCookies());
		System.out.println("header--->"+response.getHeader("Content-Type"));
		Assert.assertEquals(response.getStatusCode(),200);
		Assert.assertEquals(response.getHeader("Content-Type"),"application/json; charset=utf-8");
	}
	@Test
	public void getMethod_2() {
		Response response = RestAssured.given()
					.when()
					.get("posts");
		System.out.println("status code --->"+response.getStatusCode());
		System.out.println("body ---->"+response.getBody().asString());
		System.out.println("coockies---->"+response.getCookies());
		System.out.println("header--->"+response.getHeader("Content-Type"));
		Assert.assertEquals(response.getStatusCode(),200);
		Assert.assertEquals(response.getHeader("Content-Type"),"application/json; charset=utf-8");
	}

}
