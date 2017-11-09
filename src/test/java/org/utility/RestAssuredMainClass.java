package org.utility;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.restassured.RestAssured;

public class RestAssuredMainClass extends MainClass {
	/*
	 * This class will configure all the properties required for the set up of
	 * rest assured. This will include host , port, cookies, auth token etc
	 * required to test any rest service.
	 */

	// This method is picking properties like base, host, port from the property
	// file. And setting that to the rest assured class.
	@BeforeMethod(alwaysRun = true)
	@Parameters({ "base", "host", "port" })
	public static void restSetup(@Optional String r_base,
	        @Optional String r_host, @Optional String r_port) {
		String port = r_port;
		String base_path = r_base;
		String base_host = r_host;
		if (port == null) {
			if (!property.getProperty("base_port").isEmpty()) {
				RestAssured.port = Integer
				        .parseInt(property.getProperty("base_port"));
			}
		} else {
			RestAssured.port = Integer.valueOf(port);
		}

		if (base_path == null) {
			if (!property.getProperty("base_path").isEmpty()) {
				RestAssured.basePath = property.getProperty("base_path");
			}
		} else {
			RestAssured.basePath = base_path;
		}

		if (base_host == null) {
			if (!property.getProperty("base_host").isEmpty()) {
				RestAssured.baseURI = property.getProperty("base_host");
			}
		} else {
			RestAssured.baseURI = base_host;
		}
	}

	// Generic methods
	// @BeforeMethod
	// Fetching authorization token and saving its value in the properties file
	public static void getAuthToken() {
		String auth_token = given().when()
		        .body(property.getProperty("auth_token_payload"))
		        .post("/auth/login").then().extract().path("data.token")
		        .toString();
		property.setProperty("auth_token", auth_token);
		System.out.println(property.getProperty("auth_token"));
		Reporter.log(property.getProperty("auth_token"));
	}

	// Method to create Body For Fetching Cookie
	public static String createBodyForFetchingCookie()
	        throws IOException, InterruptedException {
		String body = "{ \"email\": \"" + property.getProperty("em") + "\","
		        + "\"password\": \"" + property.getProperty("passw") + "\" }";
		property.setProperty("auth_login_body", body);
		return body;
	}

	// This method will fetch cookies
	public static String fetchCookie()
	        throws IOException, InterruptedException {
		restSetup("", property.getProperty("base_host"),
		        property.getProperty("base_port_Admin"));
		String cookie = given().when().body(createBodyForFetchingCookie())
		        .post("/v1.0/auth/login").getHeaders().toString();
		String[] cookies = cookie.split(";");
		String[] cookies1 = cookies[1].split("=");
		String[] cookies2 = cookies[7].split("=");
		System.out.println("session_learn=" + cookies1[3] + ";" + "nonce="
		        + cookies2[3].trim());
		property.setProperty("cookie_value", "session_learn=" + cookies1[3]
		        + ";" + "nonce=" + cookies2[3].trim());
		return "session_learn=" + cookies1[3] + ";" + "nonce="
		        + cookies2[3].trim();
	}

	public static String loadRandomPhoneNumber() {
		Random rng = new Random();
		Integer areaCode = rng.nextInt(900) + 100;
		Integer phoneNumber = rng.nextInt(9000000) + 1000000;
		String fullNumber = areaCode.toString() + phoneNumber.toString();
		return fullNumber;
	}

	public static String loadRandomEmailAddress() {
		String email = loadRandomPhoneNumber() + "@example.com";
		return email;
	}

	public static String loadRandomText() {
		String randomText = "TestDataUserFillNewsLink";
		int length = 4;
		String temp = RandomStringUtils.random(length, randomText);
		return temp;
	}
}