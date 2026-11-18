package Tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class XMLSchemaValidator {

	@Test
	public void schemaVaidation() throws Exception {

		// Read XML Request
		File file = new File("./SoapRequest/Add.xml");

		if (!file.exists()) {
			throw new IOException("XML Request file not found!");
		}

		System.out.println("------->> File Exists");

		String requestBody;

		try (FileInputStream fileInputStream = new FileInputStream(file)) {
			requestBody = IOUtils.toString(fileInputStream, "UTF-8");
		}

		// Set Base URI
		baseURI = "http://www.dneonline.com";

		// Send Request and Extract Response
		String responseBody = given().contentType("text/xml").accept(ContentType.XML).body(requestBody).when()
				.post("/calculator.asmx").then().statusCode(200).log().all().body("//*:AddResult.text()", equalTo("5"))
				.extract().asString();

		// Load XSD Schema
		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

		Schema schema = factory.newSchema(getClass().getClassLoader().getResource("schema0.xsd"));

		// Validate SOAP Response
		schema.newValidator().validate(new StreamSource(new StringReader(responseBody)));

		System.out.println("XML Schema Validation Passed!");

	}
}