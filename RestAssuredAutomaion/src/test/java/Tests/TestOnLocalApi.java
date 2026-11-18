package Tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestOnLocalApi {

	// @Test
	public void getTest() {
		baseURI = "http://localhost:3000";

		given().get("/users").then().statusCode(200).log().all();

	}

	// @Test
	public void postTest() {

		JSONObject request = new JSONObject();

		request.put("firstName", "Wessam");
		request.put("lastName", "Adam");
		request.put("subjectId", 4);

		baseURI = "http://localhost:3000";

		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).when()
				.post("/users").then().statusCode(201).log().all();
	}

	// @Test
	public void putTest() {

		JSONObject request = new JSONObject();

		request.put("firstName", "Eleen");
		request.put("lastName", "Ali");
		request.put("subjectId", 5);

		baseURI = "http://localhost:3000";

		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).when()
				.put("/users/PsMFLqI42t0").then().statusCode(200).log().all();
	}

	// @Test
	public void patchTest() {

		JSONObject request = new JSONObject();
		request.put("subjectId", 6);

		baseURI = "http://localhost:3000";

		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).when()
				.patch("/users/PsMFLqI42t0").then().statusCode(200).log().all();
	}

	@Test
	public void deleteTest() {

		baseURI = "http://localhost:3000";

		when().delete("/subjects/2").then().statusCode(200).log().all();
	}
}
