package org.pages;

import static io.restassured.RestAssured.given;
import org.apache.http.HttpStatus;
import org.utility.RestAssuredMainClass;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

public class webEngageAPI extends RestAssuredMainClass {
	
	public static void postRequestToWebEngage() {
		Response response = given().urlEncodingEnabled(false)
				.log().all().given()
				.contentType(ContentType.JSON)
				//.conte("Authorization", "Base_64")
				.header("username", property.getProperty("uname"))
				.header("password", property.getProperty("pswd"))
				.header("appid",property.getProperty("appid"))
				.body(property.getProperty("version") + property.getProperty("ver_no") + "," +
				property.getProperty("smsData") +  "{" +property.getProperty("toNo") + property.getProperty("mobilenumber") + ","
				+ property.getProperty("fromNo") + property.getProperty("from") + ","
				+ property.getProperty("body") + property.getProperty("body_text") + "}," 
				+ property.getProperty("metadata") + "{"
				+ property.getProperty("campaignType") + property.getProperty("pro_campaign") + ","
				+ property.getProperty("timestamp") + property.getProperty("timestamp_value") + ","
				+ property.getProperty("messageId") + property.getProperty("msg_id") + "} }")				
				.when()
				.post(property.getProperty("web_engage_path"))
				.then().statusCode(HttpStatus.SC_OK).extract().response();
		String statusLine = response.getStatusLine();
		System.out.print("response line is " + statusLine);
		int statusCode = response.getStatusCode();
		System.out.println(" reponse code is " + statusCode);
	}

}
