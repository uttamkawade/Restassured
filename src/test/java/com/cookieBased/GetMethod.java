package com.cookieBased;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetMethod {
	
	@Test
	public void cookieBased(){
		
		RestAssured.baseURI="http://localhost:8090/rest/auth/1/";
		
		Response response=RestAssured.given()
		           .header("Content-Type", "application/json")
		           .body("{\"username\":\"uttamkawade\",\"password\":\"Testjira@1400\"}")
		           .when()
		           .post("session");
		     System.out.println("status code------>"+response.statusCode());
		     System.out.println("body------>"+response.getBody().asPrettyString());
		     
		     JsonPath json = new JsonPath(response.getBody().asPrettyString());
		     String sessionId = "JSESSIONID"+"="+json.get("session.value");
		     
		RestAssured.baseURI="http://localhost:8090/rest/api/2/";
		Response respo = RestAssured.given()
				                    .header("cookie", sessionId)
				                    .when()
				                    .get("issue/RES-10/comment");
		System.out.println("status----->"+respo.statusCode());
		System.out.println("body----->"+respo.getBody().asPrettyString());
	}
}  
