REST Assured API Automation Testing

Project Overview

This project is an API Automation Testing project built using Java, REST Assured, Maven, and TestNG.

It demonstrates different API testing techniques, including REST API testing, JSON Schema Validation, SOAP Web Services testing, and XML Schema Validation.

Technologies & Tools

- Java
- REST Assured
- Maven
- TestNG
- JSON
- XML
- SOAP Web Services
- XML Schema (XSD)
- Eclipse IDE

Project Features

1. REST API Testing

- GET Requests
- POST Requests
- PUT Requests
- PATCH Requests
- DELETE Requests
- HTTP Status Code Validation
- Response Body Assertions

2. JSON Testing

- JSON Request and Response Handling
- JSON Schema Validation
- Response Data Validation

3. SOAP Web Services Testing

- Sending SOAP XML Requests
- Receiving SOAP XML Responses
- XML Response Validation
- XML Schema (XSD) Validation
- Multiple XSD Schema Integration using xs:import

4. Local API Testing

- Testing Local APIs
- Request and Response Validation

Project Structure

RestAssuredAutomation
│
├── src/main/resources
│   ├── schema0.xsd
│   └── schema1.xsd
│
├── src/test/java
│   └── Tests
│       ├── GetAndPostExamples.java
│       ├── JsonSchemaValidator.java
│       ├── PutPatchDeleteExamples.java
│       ├── RestAssuredExample1.java
│       ├── SoapXmlRequest.java
│       ├── TestOnLocalApi.java
│       └── XMLSchemaValidator.java
│
├── SoapRequest
│   └── Add.xml
│
└── pom.xml

How to Run

1. Clone the repository.
2. Import the project into Eclipse as an existing Maven project.
3. Allow Maven to download the required dependencies.
4. Run the required test classes using TestNG.

Key Learning Outcomes

- REST API Automation using REST Assured.
- Handling different HTTP methods.
- JSON Schema Validation.
- SOAP Web Services Testing.
- XML and XSD Validation.
- Maven Project Management.
- TestNG Test Execution.

Author

QA Automation Testing Project.
