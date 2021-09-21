package com.jiraApi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeleteMethod {
	
	@Test 
	public void deleteCommand(){
		RestAssured.baseURI="http://localhost:8090/rest/api/2/";
		Response response = RestAssured.given()
				                       .auth()
				                       .preemptive()
				                       .basic("uttamkawade", "Testjira@1400")
				                       .when()
				                       .delete("issue/RES-10/comment/10204");
		
		System.out.println("status code----->"+response.statusCode());
		System.out.println("cookies-------->"+response.getCookies());
		System.out.println("body----->"+response.getBody().asPrettyString());
		
		JsonPath json = new JsonPath(response.getBody().asPrettyString());
		System.out.println("json comment body---->"+json.get("body"));
		//Assert.assertEquals(response.statusCode(), 204);
	}

}
