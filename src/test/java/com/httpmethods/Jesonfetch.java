package com.httpmethods;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Jesonfetch {
	
	
	//one json title and body fetch
	
	@Test(priority=1)
	public void queryParams(){
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
		Response response=RestAssured.given()
		           .queryParams("userId","2")
		           .queryParams("id","12")
		           .when()
		           .get("posts");
		
		JsonPath jsn= new JsonPath(response.getBody().asPrettyString());
		System.out.println("title--->"+jsn.get("title"));
		System.out.println("title size---->"+jsn.get("title.size()"));
		System.out.println("body----->"+jsn.get("body"));
		Assert.assertEquals(jsn.get("title").toString(), "[in quibusdam tempore odit est dolorem]"); 
		
	}
	
	
	//fetches title and size
	@Test(priority=2)
	public void queryParams_1(){
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
		Response response=RestAssured.given()
		           .queryParams("userId","1")
		          
		           .when()
		           .get("posts");
		
		JsonPath jsn= new JsonPath(response.getBody().asPrettyString());
		System.out.println("title--->"+jsn.get("title"));
		System.out.println("title size--->"+jsn.get("title.size()"));
		System.out.println("3rd index of title---->"+jsn.get("title[2]"));
		int sizeoftitle=jsn.get("title.size()");
		for(int i=0;i<sizeoftitle;i++){
			System.out.println( "title---->"+jsn.get("title["+i+"]"));
		}
	}
	
	//assert title by using Arraylist 
	
	@Test(priority=3)
	public void queryParams_2(){
		ArrayList< String> actual = new ArrayList<String>();
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
		Response response=RestAssured.given()
		           .queryParams("userId","1")
		          
		           .when()
		           .get("posts");
		
		JsonPath jsn= new JsonPath(response.getBody().asPrettyString());
		System.out.println("title--->"+jsn.get("title"));
		System.out.println("title size--->"+jsn.get("title.size()"));
		System.out.println("3rd index of title---->"+jsn.get("title[2]"));
		int sizeoftitle=jsn.get("title.size()");
		for(int i=0;i<sizeoftitle;i++){
			String aa=jsn.get("title["+i+"]");
			System.out.println( "title---->"+aa);
			actual.add(aa);
			
		}
		ArrayList< String> expected = new ArrayList<String>();
		expected.add("sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
		expected.add("qui est esse");
		expected.add("ea molestias quasi exercitationem repellat qui ipsa sit aut");
		expected.add("eum et est occaecati");
		expected.add("nesciunt quas odio");
		expected.add("dolorem eum magni eos aperiam quia");
		expected.add("magnam facilis autem");
		expected.add("dolorem dolore est ipsam");
		expected.add("nesciunt iure omnis dolorem tempora et accusantium");
		expected.add("optio molestias id quia eum");
		Assert.assertEquals(actual, expected);
	}	
}