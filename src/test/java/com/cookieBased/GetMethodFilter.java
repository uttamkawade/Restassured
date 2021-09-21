 package com.cookieBased;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.response.Response;

public class GetMethodFilter {
	
	public SessionFilter getSessionId(){
		
		SessionFilter session = new SessionFilter();
		RestAssured.baseURI="http://localhost:8090/rest/auth/1/";
		
		RestAssured.given()
		           .header("Content-Type", "application/json")
		           .body("{\"username\":\"uttamkawade\",\"password\":\"Testjira@1400\"}")
		           .filter(session)
		           .when()
		           .post("session");
		return session;
		
	}
	
	@Test(priority=1)
	public void getMethod(){
		RestAssured.baseURI="http://localhost:8090/rest/api/2/";
		Response respo = RestAssured.given()
				                    .filter(getSessionId())
				                    .when()
				                    .get("issue/RES-10/comment");
		System.out.println("status----->"+respo.statusCode());
		System.out.println("body----->"+respo.getBody().asPrettyString());
	}
	

}
