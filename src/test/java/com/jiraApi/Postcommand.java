package com.jiraApi;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Postcommand {
	
	@Test
	public void postMethod(){
		RestAssured.baseURI="http://localhost:8090/rest/api/2/";
		Response response=RestAssured.given()
					.auth()
					.preemptive()
					.basic("uttamkawade", "Testjira@1400")
					.headers("Content-Type", "application/json")
					.body("{\r\n" + 
							"    \"body\": \"This comment added from script\",\r\n" + 
							"    \"visibility\": {\r\n" + 
							"        \"type\": \"role\",\r\n" + 
							"        \"value\": \"Administrators\"\r\n" + 
							"    }\r\n" + 
							"}")
					.when()
					.post("issue/RES-10/comment");
		
		System.out.println("status code----->"+response.getStatusCode());
		System.out.println("body---->"+response.getBody().asPrettyString());
		
		JsonPath json = new JsonPath(response.getBody().asPrettyString());
		System.out.println("json comment body---->"+json.get("body"));
		Assert.assertEquals(json.get("body"), "This comment added from script");
	}

}
