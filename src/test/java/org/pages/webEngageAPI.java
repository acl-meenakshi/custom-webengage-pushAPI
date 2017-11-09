package org.pages;

import static io.restassured.RestAssured.given;
import org.apache.http.HttpStatus;
import org.utility.RestAssuredMainClass;

import io.restassured.response.Response;

public class webEngageAPI  extends RestAssuredMainClass{
	public static void postRequestToWebEngage() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.given()
				.when().post(property.getProperty("listner")).then()
				.statusCode(HttpStatus.SC_CREATED).extract().response();
		String statusLine= response.getStatusLine();
		System.out.print("response line is " + statusLine );
		int statusCode = response.getStatusCode();
		System.out.println(" reponse code is " + statusCode );
	}

}
