package com.jiraApi;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Putcommand {
	
	@Test
	public void Putmethod(){
		RestAssured.baseURI="http://localhost:8090/rest/api/2/";
		Response response=RestAssured.given()
				   .auth()
				   .preemptive()
				   .basic("uttamkawade", "Testjira@1400")
				   .header("content-type", "application/json")
				   .body("{\r\n" + 
				   		"    \"body\": \"This comment is added from script today\",\r\n" + 
				   		"    \"visibility\": {\r\n" + 
				   		"        \"type\": \"role\",\r\n" + 
				   		"        \"value\": \"Administrators\"\r\n" + 
				   		"    }\r\n" + 
				   		"}")
				   .when()
				   .put("issue/RES-10/comment/10204");
		System.out.println("status code----->"+response.getStatusCode());
		System.out.println("body---->"+response.getBody().asPrettyString());
		
		JsonPath json = new JsonPath(response.getBody().asPrettyString());
		System.out.println("json comment body---->"+json.get("body"));
		Assert.assertEquals(json.get("body"), "This comment is added from script today");
	}

}
