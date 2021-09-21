package jiraComplexSeriliztion;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostMethod {
	@Test
	public void postMethod(){
		
		Visibility vis = new Visibility();
		vis.setType("role");
		vis.setValue("Administrators");
		
		RootPojo pojo = new RootPojo();
		pojo.setBody("This comment added from script-pojo");
		pojo.setVisibility(vis);
		
		
		RestAssured.baseURI="http://localhost:8090/rest/api/2/";
		Response response=RestAssured.given()
					.auth()
					.preemptive()
					.basic("uttamkawade", "Testjira@1400")
					.headers("Content-Type", "application/json")
					.body(pojo)
					.when()
					.post("issue/RES-10/comment");
		
		System.out.println("status code----->"+response.getStatusCode());
		//System.out.println("body---->"+response.getBody().asPrettyString());
		
		
		//same here use deserilization to retive perticular feild
		
		RootPojoDeseri rootpojo=response.getBody().as(RootPojoDeseri.class);
		
		System.out.println("body--->"+rootpojo.getBody());
		System.out.println("name--->"+rootpojo.getUpdateAuthor().getDisplayName());
		System.out.println("Email--->"+rootpojo.getUpdateAuthor().getEmailAddress());
		System.out.println("Date---->"+rootpojo.getCreated());
		
	}
}
