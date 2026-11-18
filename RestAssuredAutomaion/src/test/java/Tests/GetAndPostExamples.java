package Tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetAndPostExamples {

	@Test
	public void getTest() {
		baseURI = "https://reqres.in/api/";
		given().get("users?page=2").then().statusCode(200).body("data[2].first_name", equalTo("Tobias"))
				.body("data.first_name", hasItems("Byron", "Rachel"));
	}

	@Test
	public void postTest() {

		Map<String, Object> map = new HashMap<String, Object>();

//		map.put("name", "Ahmed");
//		map.put("job", "teacher");
//		System.out.println(map);

		JSONObject request = new JSONObject(map);
		request.put("name", "Ahmed");
		request.put("job", "teacher");
		System.out.println(request.toJSONString());

		baseURI = "https://reqres.in/api";

		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().post("/users").then().statusCode(201).log().all();

	}

}
