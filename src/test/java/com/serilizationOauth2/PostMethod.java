package com.serilizationOauth2;

import org.testng.Assert;
import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostMethod {

	public String accessTokan(){
		RestAssured.baseURI="http://coop.apps.symfonycasts.com/";
		Response response=RestAssured.given()
		           .formParam("client_id", "Apisession")
		           .formParam("client_secret", "4a6c2734eb8072f089370494ed4e7ed8")
		           .formParam("grant_type", "client_credentials")
		           .when()
		           .post("token");
		System.out.println("body---->"+response.getBody().asPrettyString());
		
		AccessTokanPojo accesstokan=response.getBody().as(AccessTokanPojo.class);
		System.out.println(accesstokan.getAccess_token());
		System.out.println(accesstokan.getExpires_in());
		System.out.println(accesstokan.getToken_type());
		System.out.println(accesstokan.getScope());
		 return accesstokan.getAccess_token();

		}
	
	@Test
	public void oAuth2(){
		RequestBodyPojo pojo = new RequestBodyPojo();
		pojo.setAction("The action (e.g. \\\"barn-unlock\\\")");
		pojo.setSuccess("true");
		pojo.setMessage("Some summary message");
		pojo.setData("A raw, related piece of data if applicable");
		
		RestAssured.baseURI="http://coop.apps.symfonycasts.com/api/";
		Response response=RestAssured.given()
				                     .auth()
				                     .oauth2(accessTokan())
				                     .body(pojo)
				                     .when()
				                     .post("1968/chickens-feed");
		System.out.println("body------->"+response.getBody().asPrettyString());
		System.out.println("status code---->"+response.statusCode());
		
		ResponsePojo responsePojo=	response.as(ResponsePojo.class);
		
		System.out.println(responsePojo.getData());
		System.out.println(responsePojo.getAction());
		System.out.println(responsePojo.getMessage());
		System.out.println(responsePojo.getSuccess());
		
		Assert.assertEquals(responsePojo.getMessage(), "Your chickens are now full and happy");
		
}

}
