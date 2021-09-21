package com.httpmethods;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteMethod {

	@Test 
	public void deleteMethod(){
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
		Response response =RestAssured.when()
				.delete("posts/1");
		System.out.println("ststuscode ---->"+response.getStatusCode());
		System.out.println("body---->"+response.getBody().asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
