package com.jiraApi;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Getcommond {

	@Test
	public void getmethod(){
		RestAssured.baseURI="http://localhost:8090/rest/api/2/";
		Response response=RestAssured.given()
		 		   .auth()
		 		   .preemptive()
		 		   .basic("uttamkawade", "Testjira@1400")
		 		   .when()
		 		   .get("issue/RES-10/comment");
		
		System.out.println("status code----->"+response.statusCode());
		System.out.println("cookies-------->"+response.getCookies());
		System.out.println("body----->"+response.getBody().asPrettyString());
		
		
		JsonPath json = new JsonPath(response.getBody().asPrettyString());
		System.out.println("jspath body------>"+json.get("comments[0].body")); 
		System.out.println("email----->"+json.get("comments[0].author.emailAddress"));
		
		Assert.assertEquals(json.get("comments[0].body"), "updated");
	}
}
