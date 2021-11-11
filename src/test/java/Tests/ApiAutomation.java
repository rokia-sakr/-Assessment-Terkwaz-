package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiAutomation 
{
@Test
public void testapicat() 
{
	//Using RestAssured with Java
	Response res=RestAssured.get("https://cat-fact.herokuapp.com/facts/random");
	int code=res.getStatusCode();
	//System.out.println("Status code " +code+  "  ");       //print status code
	String text=res.getBody().path("text");
	//System.out.println("text value is "  +text);                 //print name in response body
	Assert.assertNotNull(text);                           //to assert text has value and  not null 
}
}
