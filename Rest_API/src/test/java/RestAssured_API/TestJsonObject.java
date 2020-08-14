package RestAssured_API;

import org.testng.annotations.Test;

import Base.JsonTestInputs;

import static io.restassured.RestAssured.*;



public class TestJsonObject extends JsonTestInputs  {
	
	@Test
	public void test_01() {
		
		given()
			.contentType("APPLICATION/JSON")
			.accept("application/json")
			.body(data1)
		.when()
			.post("https://postalpincode/api")
		.then()
			.statusCode(201)
			.log().all();
	}

}
