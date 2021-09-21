package complexPojoJira;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Getmethod {

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
		
		RootPojo rootpojo=response.getBody().as(RootPojo.class);
		
		            System.out.println(rootpojo.getMaxResults());
		           
					List<Comment>comments=rootpojo.getComments();
					
					for (Comment comment : comments) {
						System.out.println(comment.getBody());
						System.out.println(comment.getAuthor().getEmailAddress());   //imp
						System.out.println(comment.getCreated());
						
					}
		
}
}
