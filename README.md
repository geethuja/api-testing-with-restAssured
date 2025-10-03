# api-testing-with-restAssured
🌐 API Testing with RestAssured

This project demonstrates how to write API automation tests using Java + RestAssured.
It includes examples of GET, POST, PUT, DELETE requests, assertions on response codes, headers, and payloads.

📂 Project Structure
api-testing-with-restAssured/
 ├── src
 │   ├── main
 │   │   └── java
 │   └── test
 │       └── java
 │           └── api
 │               └── ApiTests.java
 ├── pom.xml
 └── README.md

⚙️ Requirements

Java 8+

Maven or Gradle

TestNG / JUnit (for running tests)

📦 Dependencies (Maven)

rest-assured
json
testng
▶️ Running Tests
Using Maven
mvn clean test

Using IntelliJ / Eclipse

Right-click on ApiTests.java → Run with TestNG.

📊 Reports

Default TestNG report will be available at:

test-output/index.html
