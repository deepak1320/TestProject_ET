package RestAssured_API;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class API_Test1 {
	
	
	@Test
	public void getData() {		
		
		given()
		.contentType("application/json")
		
		.when()
			.get("http://www.postalpincode.in/api/pincode/560099")
		.then()
			.statusCode(200);	
	}

	

}
