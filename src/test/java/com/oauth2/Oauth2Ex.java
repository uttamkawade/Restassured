package com.oauth2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Oauth2Ex {
	
	
	public String accessTokan(){
		RestAssured.baseURI="http://coop.apps.symfonycasts.com/";
		Response response=RestAssured.given()
		           .formParam("client_id", "Apisession")
		           .formParam("client_secret", "4a6c2734eb8072f089370494ed4e7ed8")
		           .formParam("grant_type", "client_credentials")
		           .when()
		           .post("token");
		System.out.println("body---->"+response.getBody().asPrettyString());
		JsonPath json = new JsonPath(response.getBody().asPrettyString());
		String token = json.get("access_token");
		System.out.println("tokan----"+token);
		return token;

		}


	
	@Test
	public void oAuth2(){
		RestAssured.baseURI="http://coop.apps.symfonycasts.com/api/";
		Response response=RestAssured.given()
				                     .auth()
				                     .oauth2(accessTokan())
				                     .body("{\r\n" + 
				                     		"    \"action\": \"The action (e.g. \\\"barn-unlock\\\")\",\r\n" + 
				                     		"    \"success\": true,\r\n" + 
				                     		"    \"message\": \"Some summary message\",\r\n" + 
				                     		"    \"data\": \"A raw, related piece of data if applicable\"\r\n" + 
				                     		"}")
				                     .when()
				                     .post("1968/chickens-feed");
		System.out.println("body------->"+response.getBody().asPrettyString());
		System.out.println("status code---->"+response.statusCode());
		
		
	}
}
