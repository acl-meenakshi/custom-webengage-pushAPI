package org.pages;

import static io.restassured.RestAssured.given;
import org.apache.http.HttpStatus;
import org.utility.RestAssuredMainClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

public class webEngageAPI extends RestAssuredMainClass {

	public static void postRequestToWebEngageProCam() {
		Response response = given().urlEncodingEnabled(false).log().all().given().contentType(ContentType.JSON)
				.header("username", property.getProperty("uname")).header("password", property.getProperty("pswd"))
				.header("appid", property.getProperty("appid"))
				.body(property.getProperty("version") + property.getProperty("ver_no") + ","
						+ property.getProperty("smsData") + "{" + property.getProperty("toNo")
						+ property.getProperty("mobilenumber") + "," + property.getProperty("fromNo")
						+ property.getProperty("from") + "," + property.getProperty("body")
						+ property.getProperty("body_text") + "}," + property.getProperty("metadata") + "{"
						+ property.getProperty("campaignType") + property.getProperty("pro_campaign") + ","
						+ property.getProperty("timestamp") + property.getProperty("timestamp_value") + ","
						+ property.getProperty("messageId") + property.getProperty("msg_id") + "} }")
				.when().post(property.getProperty("web_engage_path")).then().statusCode(HttpStatus.SC_OK).extract()
				.response();
		String statusLine = response.getStatusLine();
		System.out.print("response line is " + statusLine);
		int statusCode = response.getStatusCode();
		System.out.println(" reponse code is " + statusCode);
		Assert.assertEquals(property.getProperty("accepted"), response.jsonPath().get("status"));
	}

	public static void postRequestToWebEngageTranCamp() {
		Response response = given().urlEncodingEnabled(false).log().all().given().contentType(ContentType.JSON)
				.header("username", property.getProperty("uname")).header("password", property.getProperty("pswd"))
				.header("appid", property.getProperty("appid"))
				.body(property.getProperty("version") + property.getProperty("ver_no") + ","
						+ property.getProperty("smsData") + "{" + property.getProperty("toNo")
						+ property.getProperty("mobilenumber") + "," + property.getProperty("fromNo")
						+ property.getProperty("from") + "," + property.getProperty("body")
						+ property.getProperty("body_text") + "}," + property.getProperty("metadata") + "{"
						+ property.getProperty("campaignType") + property.getProperty("tra_campaign") + ","
						+ property.getProperty("timestamp") + property.getProperty("timestamp_value") + ","
						+ property.getProperty("messageId") + property.getProperty("msg_id") + "} }")
				.when().post(property.getProperty("web_engage_path")).then().statusCode(HttpStatus.SC_OK).extract()
				.response();
		String statusLine = response.getStatusLine();
		System.out.print("response line is " + statusLine);
		int statusCode = response.getStatusCode();
		System.out.println(" reponse code is " + statusCode);
		Assert.assertEquals(property.getProperty("accepted"), response.jsonPath().get("status"));
	}

	public static void postRequestToWebEngageWithInvalidUsername() {
		Response response = given().urlEncodingEnabled(false).log().all().given().contentType(ContentType.JSON)
				.header("username", property.getProperty("uname") + loadRandomText())
				.header("password", property.getProperty("pswd")).header("appid", property.getProperty("appid"))
				.body(property.getProperty("version") + property.getProperty("ver_no") + ","
						+ property.getProperty("smsData") + "{" + property.getProperty("toNo")
						+ property.getProperty("mobilenumber") + "," + property.getProperty("fromNo")
						+ property.getProperty("from") + "," + property.getProperty("body")
						+ property.getProperty("body_text") + "}," + property.getProperty("metadata") + "{"
						+ property.getProperty("campaignType") + property.getProperty("pro_campaign") + ","
						+ property.getProperty("timestamp") + property.getProperty("timestamp_value") + ","
						+ property.getProperty("messageId") + property.getProperty("msg_id") + "} }")
				.when().post(property.getProperty("web_engage_path")).then().statusCode(HttpStatus.SC_BAD_REQUEST)
				.extract().response();
		String statusLine = response.getStatusLine();
		System.out.print("response line is " + statusLine);
		int statusCode = response.getStatusCode();
		System.out.println(" reponse code is " + statusCode);
		Assert.assertEquals(property.getProperty("rejected"), response.jsonPath().get("status"));
		// Assert.assertEquals(property.getProperty("auth_code"),
		// response.jsonPath().getInt("statusCode"));
		Assert.assertEquals(property.getProperty("auth_fail"), response.jsonPath().get("message"));
	}

	public static void postRequestToWebEngageWithInvalidPswd() {
		Response response = given().urlEncodingEnabled(false).log().all().given().contentType(ContentType.JSON)
				.header("username", property.getProperty("uname"))
				.header("password", property.getProperty("pswd") + loadRandomPhoneNumber())
				.header("appid", property.getProperty("appid"))
				.body(property.getProperty("version") + property.getProperty("ver_no") + ","
						+ property.getProperty("smsData") + "{" + property.getProperty("toNo")
						+ property.getProperty("mobilenumber") + "," + property.getProperty("fromNo")
						+ property.getProperty("from") + "," + property.getProperty("body")
						+ property.getProperty("body_text") + "}," + property.getProperty("metadata") + "{"
						+ property.getProperty("campaignType") + property.getProperty("pro_campaign") + ","
						+ property.getProperty("timestamp") + property.getProperty("timestamp_value") + ","
						+ property.getProperty("messageId") + property.getProperty("msg_id") + "} }")
				.when().post(property.getProperty("web_engage_path")).then().statusCode(HttpStatus.SC_BAD_REQUEST)
				.extract().response();
		String statusLine = response.getStatusLine();
		System.out.print("response line is " + statusLine);
		int statusCode = response.getStatusCode();
		System.out.println(" reponse code is " + statusCode);
		Assert.assertEquals(property.getProperty("rejected"), response.jsonPath().get("status"));
		/// Assert.assertEquals(property.getProperty("auth_code"),
		/// response.jsonPath().get("statusCode"));
		Assert.assertEquals(property.getProperty("auth_fail"), response.jsonPath().get("message"));
	}

	public static void postRequestToWebEngageWithBlankUsername() {
		Response response = given().urlEncodingEnabled(false).log().all().given().contentType(ContentType.JSON)
				.header("username", "").header("password", property.getProperty("pswd"))
				.header("appid", property.getProperty("appid"))
				.body(property.getProperty("version") + property.getProperty("ver_no") + ","
						+ property.getProperty("smsData") + "{" + property.getProperty("toNo")
						+ property.getProperty("mobilenumber") + "," + property.getProperty("fromNo")
						+ property.getProperty("from") + "," + property.getProperty("body")
						+ property.getProperty("body_text") + "}," + property.getProperty("metadata") + "{"
						+ property.getProperty("campaignType") + property.getProperty("pro_campaign") + ","
						+ property.getProperty("timestamp") + property.getProperty("timestamp_value") + ","
						+ property.getProperty("messageId") + property.getProperty("msg_id") + "} }")
				.when().post(property.getProperty("web_engage_path")).then().statusCode(HttpStatus.SC_BAD_REQUEST)
				.extract().response();
		String statusLine = response.getStatusLine();
		System.out.print("response line is " + statusLine);
		int statusCode = response.getStatusCode();
		System.out.println(" reponse code is " + statusCode);
		Assert.assertEquals(property.getProperty("rejected"), response.jsonPath().get("status"));
		// Assert.assertEquals(property.getProperty("auth_code"),
		// response.jsonPath().get("statusCode"));
		Assert.assertEquals(property.getProperty("auth_fail"), response.jsonPath().get("message"));
	}

	public static void postRequestToWebEngageWithBlankPswd() {
		Response response = given().urlEncodingEnabled(false).log().all().given().contentType(ContentType.JSON)
				.header("username", property.getProperty("uname")).header("password", " ")
				.header("appid", property.getProperty("appid"))
				.body(property.getProperty("version") + property.getProperty("ver_no") + ","
						+ property.getProperty("smsData") + "{" + property.getProperty("toNo")
						+ property.getProperty("mobilenumber") + "," + property.getProperty("fromNo")
						+ property.getProperty("from") + "," + property.getProperty("body")
						+ property.getProperty("body_text") + "}," + property.getProperty("metadata") + "{"
						+ property.getProperty("campaignType") + property.getProperty("pro_campaign") + ","
						+ property.getProperty("timestamp") + property.getProperty("timestamp_value") + ","
						+ property.getProperty("messageId") + property.getProperty("msg_id") + "} }")
				.when().post(property.getProperty("web_engage_path")).then().statusCode(HttpStatus.SC_BAD_REQUEST)
				.extract().response();
		String statusLine = response.getStatusLine();
		System.out.print("response line is " + statusLine);
		int statusCode = response.getStatusCode();
		System.out.println(" reponse code is " + statusCode);
		Assert.assertEquals(property.getProperty("rejected"), response.jsonPath().get("status"));
		// Assert.assertEquals(property.getProperty("auth_code"),
		// response.jsonPath().get("statusCode"));
		Assert.assertEquals(property.getProperty("auth_fail"), response.jsonPath().get("message"));
	}

	public static void postRequestToWebEngageWithoutUsername() {
		Response response = given().urlEncodingEnabled(false).log().all().given().contentType(ContentType.JSON)
				.header("password", property.getProperty("pswd")).header("appid", property.getProperty("appid"))
				.body(property.getProperty("version") + property.getProperty("ver_no") + ","
						+ property.getProperty("smsData") + "{" + property.getProperty("toNo")
						+ property.getProperty("mobilenumber") + "," + property.getProperty("fromNo")
						+ property.getProperty("from") + "," + property.getProperty("body")
						+ property.getProperty("body_text") + "}," + property.getProperty("metadata") + "{"
						+ property.getProperty("campaignType") + property.getProperty("pro_campaign") + ","
						+ property.getProperty("timestamp") + property.getProperty("timestamp_value") + ","
						+ property.getProperty("messageId") + property.getProperty("msg_id") + "} }")
				.when().post(property.getProperty("web_engage_path")).then().statusCode(HttpStatus.SC_BAD_REQUEST)
				.extract().response();
		String statusLine = response.getStatusLine();
		System.out.print("response line is " + statusLine);
		int statusCode = response.getStatusCode();
		System.out.println(" reponse code is " + statusCode);
		Assert.assertEquals(property.getProperty("rejected"), response.jsonPath().get("status"));
		// Assert.assertEquals(property.getProperty("auth_code"),
		// response.jsonPath().get("statusCode"));
		Assert.assertEquals(property.getProperty("auth_fail"), response.jsonPath().get("message"));
	}

	public static void postRequestToWebEngageWithoutPswd() {
		Response response = given().urlEncodingEnabled(false).log().all().given().contentType(ContentType.JSON)
				.header("username", property.getProperty("uname")).header("appid", property.getProperty("appid"))
				.body(property.getProperty("version") + property.getProperty("ver_no") + ","
						+ property.getProperty("smsData") + "{" + property.getProperty("toNo")
						+ property.getProperty("mobilenumber") + "," + property.getProperty("fromNo")
						+ property.getProperty("from") + "," + property.getProperty("body")
						+ property.getProperty("body_text") + "}," + property.getProperty("metadata") + "{"
						+ property.getProperty("campaignType") + property.getProperty("pro_campaign") + ","
						+ property.getProperty("timestamp") + property.getProperty("timestamp_value") + ","
						+ property.getProperty("messageId") + property.getProperty("msg_id") + "} }")
				.when().post(property.getProperty("web_engage_path")).then().statusCode(HttpStatus.SC_BAD_REQUEST)
				.extract().response();
		String statusLine = response.getStatusLine();
		System.out.print("response line is " + statusLine);
		int statusCode = response.getStatusCode();
		System.out.println(" reponse code is " + statusCode);
		Assert.assertEquals(property.getProperty("rejected"), response.jsonPath().get("status"));
		// Assert.assertEquals(property.getProperty("auth_code"),
		// response.jsonPath().get("statusCode"));
		Assert.assertEquals(property.getProperty("auth_fail"), response.jsonPath().get("message"));
	}

	public static void postRequestToWebEngageWithoutAppId() {
		Response response = given().urlEncodingEnabled(false).log().all().given().contentType(ContentType.JSON)
				.header("username", property.getProperty("uname")).header("password", property.getProperty("pswd"))
				.body(property.getProperty("version") + property.getProperty("ver_no") + ","
						+ property.getProperty("smsData") + "{" + property.getProperty("toNo")
						+ property.getProperty("mobilenumber") + "," + property.getProperty("fromNo")
						+ property.getProperty("from") + "," + property.getProperty("body")
						+ property.getProperty("body_text") + "}," + property.getProperty("metadata") + "{"
						+ property.getProperty("campaignType") + property.getProperty("pro_campaign") + ","
						+ property.getProperty("timestamp") + property.getProperty("timestamp_value") + ","
						+ property.getProperty("messageId") + property.getProperty("msg_id") + "} }")
				.when().post(property.getProperty("web_engage_path")).then().statusCode(HttpStatus.SC_BAD_REQUEST)
				.extract().response();
		String statusLine = response.getStatusLine();
		System.out.print("response line is " + statusLine);
		int statusCode = response.getStatusCode();
		System.out.println(" reponse code is " + statusCode);
		Assert.assertEquals(property.getProperty("rejected"), response.jsonPath().get("status"));
		// Assert.assertEquals(property.getProperty("unknown_code"),
		// response.jsonPath().get("statusCode"));
		Assert.assertEquals(property.getProperty("invalid_aapId_msg"), response.jsonPath().get("message"));
	}

	public static void postRequestToWebEngageWithBlankAppid() {
		Response response = given().urlEncodingEnabled(false).log().all().given().contentType(ContentType.JSON)
				.header("username", property.getProperty("uname")).header("password", property.getProperty("pswd"))
				.header("appid", " ")
				.body(property.getProperty("version") + property.getProperty("ver_no") + ","
						+ property.getProperty("smsData") + "{" + property.getProperty("toNo")
						+ property.getProperty("mobilenumber") + "," + property.getProperty("fromNo")
						+ property.getProperty("from") + "," + property.getProperty("body")
						+ property.getProperty("body_text") + "}," + property.getProperty("metadata") + "{"
						+ property.getProperty("campaignType") + property.getProperty("pro_campaign") + ","
						+ property.getProperty("timestamp") + property.getProperty("timestamp_value") + ","
						+ property.getProperty("messageId") + property.getProperty("msg_id") + "} }")
				.when().post(property.getProperty("web_engage_path")).then().statusCode(HttpStatus.SC_BAD_REQUEST)
				.extract().response();
		String statusLine = response.getStatusLine();
		System.out.print("response line is " + statusLine);
		int statusCode = response.getStatusCode();
		System.out.println(" reponse code is " + statusCode);
		Assert.assertEquals(property.getProperty("rejected"), response.jsonPath().get("status"));
		// Assert.assertEquals(property.getProperty("unknown_code"),
		// response.jsonPath().get("statusCode"));
		Assert.assertEquals(property.getProperty("invalid_aapId_msg"), response.jsonPath().get("message"));
	}

	public static void postRequestToWebEngageWithInvalidAppId() {
		Response response = given().urlEncodingEnabled(false).log().all().given().contentType(ContentType.JSON)
				.header("username", property.getProperty("uname")).header("password", property.getProperty("pswd"))
				.header("appid", property.getProperty("appid") + loadRandomPhoneNumber())
				.body(property.getProperty("version") + property.getProperty("ver_no") + ","
						+ property.getProperty("smsData") + "{" + property.getProperty("toNo")
						+ property.getProperty("mobilenumber") + "," + property.getProperty("fromNo")
						+ property.getProperty("from") + "," + property.getProperty("body")
						+ property.getProperty("body_text") + "}," + property.getProperty("metadata") + "{"
						+ property.getProperty("campaignType") + property.getProperty("pro_campaign") + ","
						+ property.getProperty("timestamp") + property.getProperty("timestamp_value") + ","
						+ property.getProperty("messageId") + property.getProperty("msg_id") + "} }")
				.when().post(property.getProperty("web_engage_path")).then().statusCode(HttpStatus.SC_BAD_REQUEST)
				.extract().response();
		String statusLine = response.getStatusLine();
		System.out.print("response line is " + statusLine);
		int statusCode = response.getStatusCode();
		System.out.println(" reponse code is " + statusCode);
		Assert.assertEquals(property.getProperty("rejected"), response.jsonPath().get("status"));
		// Assert.assertEquals(property.getProperty("unknown_code"),
		// response.jsonPath().get("statusCode"));
		Assert.assertEquals(property.getProperty("invalid_aapId_msg"), response.jsonPath().get("message"));
	}

	public static void postRequestToWebEngageWithoutVersion() {
		Response response = given().urlEncodingEnabled(false).log().all().given().contentType(ContentType.JSON)
				.header("username", property.getProperty("uname")).header("password", property.getProperty("pswd"))
				.header("appid", property.getProperty("appid"))
				.body("{" + property.getProperty("smsData") + "{" + property.getProperty("toNo")
						+ property.getProperty("mobilenumber") + "," + property.getProperty("fromNo")
						+ property.getProperty("from") + "," + property.getProperty("body")
						+ property.getProperty("body_text") + "}," + property.getProperty("metadata") + "{"
						+ property.getProperty("campaignType") + property.getProperty("pro_campaign") + ","
						+ property.getProperty("timestamp") + property.getProperty("timestamp_value") + ","
						+ property.getProperty("messageId") + property.getProperty("msg_id") + "} }")
				.when().post(property.getProperty("web_engage_path")).then().statusCode(HttpStatus.SC_BAD_REQUEST)
				.extract().response();
		String statusLine = response.getStatusLine();
		System.out.print("response line is " + statusLine);
		int statusCode = response.getStatusCode();
		System.out.println(" reponse code is " + statusCode);
		Assert.assertEquals(property.getProperty("rejected"), response.jsonPath().get("status"));
		// Assert.assertEquals(property.getProperty("ver_code"),
		// response.jsonPath().get("statusCode"));
		Assert.assertEquals(property.getProperty("ver_msg"), response.jsonPath().get("message"));
		Assert.assertEquals(property.getProperty("ver_support"), response.jsonPath().get("supportedVersion"));
	}

	public static void postRequestToWebEngageWithMissingVersion() {
		Response response = given().urlEncodingEnabled(false).log().all().given().contentType(ContentType.JSON)
				.header("username", property.getProperty("uname")).header("password", property.getProperty("pswd"))
				.header("appid", property.getProperty("appid"))
				.body(property.getProperty("version") + property.getProperty("missing_item") + ","
						+ property.getProperty("smsData") + "{" + property.getProperty("toNo")
						+ property.getProperty("mobilenumber") + "," + property.getProperty("fromNo")
						+ property.getProperty("from") + "," + property.getProperty("body")
						+ property.getProperty("body_text") + "}," + property.getProperty("metadata") + "{"
						+ property.getProperty("campaignType") + property.getProperty("pro_campaign") + ","
						+ property.getProperty("timestamp") + property.getProperty("timestamp_value") + ","
						+ property.getProperty("messageId") + property.getProperty("msg_id") + "} }")
				.when().post(property.getProperty("web_engage_path")).then().statusCode(HttpStatus.SC_BAD_REQUEST)
				.extract().response();
		String statusLine = response.getStatusLine();
		System.out.print("response line is " + statusLine);
		int statusCode = response.getStatusCode();
		System.out.println(" reponse code is " + statusCode);
		Assert.assertEquals(property.getProperty("rejected"), response.jsonPath().get("status"));
		// Assert.assertEquals(property.getProperty("ver_code"),
		// response.jsonPath().get("statusCode"));
		Assert.assertEquals(property.getProperty("ver_msg"), response.jsonPath().get("message"));
		Assert.assertEquals(property.getProperty("ver_support"), response.jsonPath().get("supportedVersion"));
	}

	public static void postRequestToWebEngageWithInvalidVersion() {
		Response response = given().urlEncodingEnabled(false).log().all().given().contentType(ContentType.JSON)
				.header("username", property.getProperty("uname")).header("password", property.getProperty("pswd"))
				.header("appid", property.getProperty("appid"))
				.body(property.getProperty("version") + loadRandomPhoneNumber() + "," + property.getProperty("smsData")
						+ "{" + property.getProperty("toNo") + property.getProperty("mobilenumber") + ","
						+ property.getProperty("fromNo") + property.getProperty("from") + ","
						+ property.getProperty("body") + property.getProperty("body_text") + "},"
						+ property.getProperty("metadata") + "{" + property.getProperty("campaignType")
						+ property.getProperty("pro_campaign") + "," + property.getProperty("timestamp")
						+ property.getProperty("timestamp_value") + "," + property.getProperty("messageId")
						+ property.getProperty("msg_id") + "} }")
				.when().post(property.getProperty("web_engage_path")).then().statusCode(HttpStatus.SC_BAD_REQUEST)
				.extract().response();
		String statusLine = response.getStatusLine();
		System.out.print("response line is " + statusLine);
		int statusCode = response.getStatusCode();
		System.out.println(" reponse code is " + statusCode);
		Assert.assertEquals(property.getProperty("rejected"), response.jsonPath().get("status"));
		// Assert.assertEquals(property.getProperty("ver_code"),
		// response.jsonPath().get("statusCode"));
		Assert.assertEquals(property.getProperty("ver_msg"), response.jsonPath().get("message"));
		Assert.assertEquals(property.getProperty("ver_support"), response.jsonPath().get("supportedVersion"));
	}

	public static void postRequestToWebEngageWithoutToNumber() {
		Response response = given().urlEncodingEnabled(false).log().all().given().contentType(ContentType.JSON)
				.header("username", property.getProperty("uname")).header("password", property.getProperty("pswd"))
				.header("appid", property.getProperty("appid"))
				.body(property.getProperty("version") + property.getProperty("ver_no") + ","
						+ property.getProperty("smsData") + "{" + property.getProperty("fromNo")
						+ property.getProperty("from") + "," + property.getProperty("body")
						+ property.getProperty("body_text") + "}," + property.getProperty("metadata") + "{"
						+ property.getProperty("campaignType") + property.getProperty("pro_campaign") + ","
						+ property.getProperty("timestamp") + property.getProperty("timestamp_value") + ","
						+ property.getProperty("messageId") + property.getProperty("msg_id") + "} }")
				.when().post(property.getProperty("web_engage_path")).then().statusCode(HttpStatus.SC_BAD_REQUEST)
				.extract().response();
		String statusLine = response.getStatusLine();
		System.out.print("response line is " + statusLine);
		int statusCode = response.getStatusCode();
		System.out.println(" reponse code is " + statusCode);
		Assert.assertEquals(property.getProperty("rejected"), response.jsonPath().get("status"));
		// Assert.assertEquals(property.getProperty("invalid_no_code"),
		// response.jsonPath().get("statusCode"));
		Assert.assertEquals(property.getProperty("invalid_no_msg"), response.jsonPath().get("message"));
	}

	public static void postRequestToWebEngageWithMissingToNumber() {
		Response response = given().urlEncodingEnabled(false).log().all().given().contentType(ContentType.JSON)
				.header("username", property.getProperty("uname")).header("password", property.getProperty("pswd"))
				.header("appid", property.getProperty("appid"))
				.body(property.getProperty("version") + property.getProperty("ver_no") + ","
						+ property.getProperty("smsData") + "{" + property.getProperty("toNo")
						+ property.getProperty("missing_item") + "," + property.getProperty("fromNo")
						+ property.getProperty("from") + "," + property.getProperty("body")
						+ property.getProperty("body_text") + "}," + property.getProperty("metadata") + "{"
						+ property.getProperty("campaignType") + property.getProperty("pro_campaign") + ","
						+ property.getProperty("timestamp") + property.getProperty("timestamp_value") + ","
						+ property.getProperty("messageId") + property.getProperty("msg_id") + "} }")
				.when().post(property.getProperty("web_engage_path")).then().statusCode(HttpStatus.SC_BAD_REQUEST)
				.extract().response();
		String statusLine = response.getStatusLine();
		System.out.print("response line is " + statusLine);
		int statusCode = response.getStatusCode();
		System.out.println(" reponse code is " + statusCode);
		Assert.assertEquals(property.getProperty("rejected"), response.jsonPath().get("status"));
		// Assert.assertEquals(property.getProperty("invalid_no_code"),
		// response.jsonPath().get("statusCode"));
		Assert.assertEquals(property.getProperty("invalid_no_msg"), response.jsonPath().get("message"));
	}

	public static void postRequestToWebEngageWithStringToNumber() {
		Response response = given().urlEncodingEnabled(false).log().all().given().contentType(ContentType.JSON)
				.header("username", property.getProperty("uname")).header("password", property.getProperty("pswd"))
				.header("appid", property.getProperty("appid"))
				.body(property.getProperty("version") + property.getProperty("ver_no") + ","
						+ property.getProperty("smsData") + "{" + property.getProperty("toNo") + "mobilenumber" + ","
						+ property.getProperty("fromNo") + property.getProperty("from") + ","
						+ property.getProperty("body") + property.getProperty("body_text") + "},"
						+ property.getProperty("metadata") + "{" + property.getProperty("campaignType")
						+ property.getProperty("pro_campaign") + "," + property.getProperty("timestamp")
						+ property.getProperty("timestamp_value") + "," + property.getProperty("messageId")
						+ property.getProperty("msg_id") + "} }")
				.when().post(property.getProperty("web_engage_path")).then().statusCode(HttpStatus.SC_BAD_REQUEST)
				.extract().response();
		String statusLine = response.getStatusLine();
		System.out.print("response line is " + statusLine);
		int statusCode = response.getStatusCode();
		System.out.println(" reponse code is " + statusCode);
		Assert.assertEquals(property.getProperty("rejected"), response.jsonPath().get("status"));
		// Assert.assertEquals(property.getProperty("invalid_no_code"),
		// response.jsonPath().get("statusCode"));
		Assert.assertEquals(property.getProperty("invalid_no_msg"), response.jsonPath().get("message"));
	}

	public static void postRequestToWebEngageWithoutCountryCode() {
		Response response = given().urlEncodingEnabled(false).log().all().given().contentType(ContentType.JSON)
				.header("username", property.getProperty("uname")).header("password", property.getProperty("pswd"))
				.header("appid", property.getProperty("appid"))
				.body(property.getProperty("version") + property.getProperty("ver_no") + ","
						+ property.getProperty("smsData") + "{" + property.getProperty("toNo")
						+ property.getProperty("mobilenumber_missingCoutrycode") + "," + property.getProperty("fromNo")
						+ property.getProperty("from") + "," + property.getProperty("body")
						+ property.getProperty("body_text") + "}," + property.getProperty("metadata") + "{"
						+ property.getProperty("campaignType") + property.getProperty("pro_campaign") + ","
						+ property.getProperty("timestamp") + property.getProperty("timestamp_value") + ","
						+ property.getProperty("messageId") + property.getProperty("msg_id") + "} }")
				.when().post(property.getProperty("web_engage_path")).then().statusCode(HttpStatus.SC_OK).extract()
				.response();
		String statusLine = response.getStatusLine();
		System.out.print("response line is " + statusLine);
		int statusCode = response.getStatusCode();
		System.out.println(" reponse code is " + statusCode);
		Assert.assertEquals(property.getProperty("accepted"), response.jsonPath().get("status"));
	}

	public static void postRequestToWebEngageWithoutFromNumber() {
		Response response = given().urlEncodingEnabled(false).log().all().given().contentType(ContentType.JSON)
				.header("username", property.getProperty("uname")).header("password", property.getProperty("pswd"))
				.header("appid", property.getProperty("appid"))
				.body(property.getProperty("version") + property.getProperty("ver_no") + ","
						+ property.getProperty("smsData") + "{" + property.getProperty("toNo")
						+ property.getProperty("mobilenumber") + "," + property.getProperty("body")
						+ property.getProperty("body_text") + "}," + property.getProperty("metadata") + "{"
						+ property.getProperty("campaignType") + property.getProperty("pro_campaign") + ","
						+ property.getProperty("timestamp") + property.getProperty("timestamp_value") + ","
						+ property.getProperty("messageId") + property.getProperty("msg_id") + "} }")
				.when().post(property.getProperty("web_engage_path")).then().statusCode(HttpStatus.SC_BAD_REQUEST)
				.extract().response();
		String statusLine = response.getStatusLine();
		System.out.print("response line is " + statusLine);
		int statusCode = response.getStatusCode();
		System.out.println(" reponse code is " + statusCode);
		Assert.assertEquals(property.getProperty("rejected"), response.jsonPath().get("status"));
		// Assert.assertEquals(property.getProperty("invalid_sender_code"),
		// response.jsonPath().get("statusCode"));
		Assert.assertEquals(property.getProperty("invalid_sender_msg"), response.jsonPath().get("message"));
	}

	public static void postRequestToWebEngageWithMissingFromNumber() {
		Response response = given().urlEncodingEnabled(false).log().all().given().contentType(ContentType.JSON)
				.header("username", property.getProperty("uname")).header("password", property.getProperty("pswd"))
				.header("appid", property.getProperty("appid"))
				.body(property.getProperty("version") + property.getProperty("ver_no") + ","
						+ property.getProperty("smsData") + "{" + property.getProperty("toNo")
						+ property.getProperty("mobilenumber") + "," + property.getProperty("fromNo")
						+ property.getProperty("missing_item") + "," + property.getProperty("body")
						+ property.getProperty("body_text") + "}," + property.getProperty("metadata") + "{"
						+ property.getProperty("campaignType") + property.getProperty("pro_campaign") + ","
						+ property.getProperty("timestamp") + property.getProperty("timestamp_value") + ","
						+ property.getProperty("messageId") + property.getProperty("msg_id") + "} }")
				.when().post(property.getProperty("web_engage_path")).then().statusCode(HttpStatus.SC_BAD_REQUEST)
				.extract().response();
		String statusLine = response.getStatusLine();
		System.out.print("response line is " + statusLine);
		int statusCode = response.getStatusCode();
		System.out.println(" reponse code is " + statusCode);
		Assert.assertEquals(property.getProperty("rejected"), response.jsonPath().get("status"));
		// Assert.assertEquals(property.getProperty("invalid_sender_code"),
		// response.jsonPath().get("statusCode"));
		Assert.assertEquals(property.getProperty("invalid_sender_msg"), response.jsonPath().get("message"));
	}

	public static void postRequestToWebEngageWithStringInFromNumber() {
		Response response = given().urlEncodingEnabled(false).log().all().given().contentType(ContentType.JSON)
				.header("username", property.getProperty("uname")).header("password", property.getProperty("pswd"))
				.header("appid", property.getProperty("appid"))
				.body(property.getProperty("version") + property.getProperty("ver_no") + ","
						+ property.getProperty("smsData") + "{" + property.getProperty("toNo")
						+ property.getProperty("mobilenumber") + "," + property.getProperty("fromNo")
						+ property.getProperty("from") + "," + property.getProperty("body")
						+ property.getProperty("body_text") + "}," + property.getProperty("metadata") + "{"
						+ property.getProperty("campaignType") + property.getProperty("pro_campaign") + ","
						+ property.getProperty("timestamp") + property.getProperty("timestamp_value") + ","
						+ property.getProperty("messageId") + property.getProperty("msg_id") + "} }")
				.when().post(property.getProperty("web_engage_path")).then().statusCode(HttpStatus.SC_OK).extract()
				.response();
		String statusLine = response.getStatusLine();
		System.out.print("response line is " + statusLine);
		int statusCode = response.getStatusCode();
		System.out.println(" reponse code is " + statusCode);
		Assert.assertEquals(property.getProperty("accepted"), response.jsonPath().get("status"));
	}

	public static void postRequestToWebEngageWithIntInFromNumber() {
		Response response = given().urlEncodingEnabled(false).log().all().given().contentType(ContentType.JSON)
				.header("username", property.getProperty("uname")).header("password", property.getProperty("pswd"))
				.header("appid", property.getProperty("appid"))
				.body(property.getProperty("version") + property.getProperty("ver_no") + ","
						+ property.getProperty("smsData") + "{" + property.getProperty("toNo")
						+ property.getProperty("mobilenumber") + "," + property.getProperty("fromNo")
						+ loadRandomPhoneNumber() + "," + property.getProperty("body")
						+ property.getProperty("body_text") + "}," + property.getProperty("metadata") + "{"
						+ property.getProperty("campaignType") + property.getProperty("pro_campaign") + ","
						+ property.getProperty("timestamp") + property.getProperty("timestamp_value") + ","
						+ property.getProperty("messageId") + property.getProperty("msg_id") + "} }")
				.when().post(property.getProperty("web_engage_path")).then().statusCode(HttpStatus.SC_OK).extract()
				.response();
		String statusLine = response.getStatusLine();
		System.out.print("response line is " + statusLine);
		int statusCode = response.getStatusCode();
		System.out.println(" reponse code is " + statusCode);
		Assert.assertEquals(property.getProperty("accepted"), response.jsonPath().get("status"));
	}

	public static void postRequestToWebEngageWithSpecialChracterFromNumber() {
		Response response = given().urlEncodingEnabled(false).log().all().given().contentType(ContentType.JSON)
				.header("username", property.getProperty("uname")).header("password", property.getProperty("pswd"))
				.header("appid", property.getProperty("appid"))
				.body(property.getProperty("version") + property.getProperty("ver_no") + ","
						+ property.getProperty("smsData") + "{" + property.getProperty("toNo")
						+ property.getProperty("mobilenumber") + "," + property.getProperty("fromNo")
						+ loadRandomEmailAddress() + loadRandomPhoneNumber() + "," + property.getProperty("body")
						+ property.getProperty("body_text") + "}," + property.getProperty("metadata") + "{"
						+ property.getProperty("campaignType") + property.getProperty("pro_campaign") + ","
						+ property.getProperty("timestamp") + property.getProperty("timestamp_value") + ","
						+ property.getProperty("messageId") + property.getProperty("msg_id") + "} }")
				.when().post(property.getProperty("web_engage_path")).then().statusCode(HttpStatus.SC_OK).extract()
				.response();
		String statusLine = response.getStatusLine();
		System.out.print("response line is " + statusLine);
		int statusCode = response.getStatusCode();
		System.out.println(" reponse code is " + statusCode);
		Assert.assertEquals(property.getProperty("accepted"), response.jsonPath().get("status"));
	}

	public static void postRequestToWebEngageWithoutBodyTag() {
		Response response = given().urlEncodingEnabled(false).log().all().given().contentType(ContentType.JSON)
				.header("username", property.getProperty("uname")).header("password", property.getProperty("pswd"))
				.header("appid", property.getProperty("appid"))
				.body(property.getProperty("version") + property.getProperty("ver_no") + ","
						+ property.getProperty("smsData") + "{" + property.getProperty("toNo")
						+ property.getProperty("mobilenumber") + "," + property.getProperty("fromNo")
						+ property.getProperty("from") + "}," + property.getProperty("metadata") + "{"
						+ property.getProperty("campaignType") + property.getProperty("pro_campaign") + ","
						+ property.getProperty("timestamp") + property.getProperty("timestamp_value") + ","
						+ property.getProperty("messageId") + property.getProperty("msg_id") + "} }")
				.when().post(property.getProperty("web_engage_path")).then().statusCode(HttpStatus.SC_BAD_REQUEST)
				.extract().response();
		String statusLine = response.getStatusLine();
		System.out.print("response line is " + statusLine);
		int statusCode = response.getStatusCode();
		System.out.println(" reponse code is " + statusCode);
		Assert.assertEquals(property.getProperty("rejected"), response.jsonPath().get("status"));
		// Assert.assertEquals(property.getProperty("missing_body_code"),
		// response.jsonPath().get("statusCode"));
		Assert.assertEquals(property.getProperty("missing_body_msg"), response.jsonPath().get("message"));
	}

	public static void postRequestToWebEngageWithMissingBodyText() {
		Response response = given().urlEncodingEnabled(false).log().all().given().contentType(ContentType.JSON)
				.header("username", property.getProperty("uname")).header("password", property.getProperty("pswd"))
				.header("appid", property.getProperty("appid"))
				.body(property.getProperty("version") + property.getProperty("ver_no") + ","
						+ property.getProperty("smsData") + "{" + property.getProperty("toNo")
						+ property.getProperty("mobilenumber") + "," + property.getProperty("fromNo")
						+ property.getProperty("from") + "," + property.getProperty("body")
						+ property.getProperty("missing_item") + "}," + property.getProperty("metadata") + "{"
						+ property.getProperty("campaignType") + property.getProperty("pro_campaign") + ","
						+ property.getProperty("timestamp") + property.getProperty("timestamp_value") + ","
						+ property.getProperty("messageId") + property.getProperty("msg_id") + "} }")
				.when().post(property.getProperty("web_engage_path")).then().statusCode(HttpStatus.SC_BAD_REQUEST)
				.extract().response();
		String statusLine = response.getStatusLine();
		System.out.print("response line is " + statusLine);
		int statusCode = response.getStatusCode();
		System.out.println(" reponse code is " + statusCode);
		Assert.assertEquals(property.getProperty("rejected"), response.jsonPath().get("status"));
		// Assert.assertEquals(property.getProperty("missing_body_code"),
		// response.jsonPath().get("statusCode"));
		Assert.assertEquals(property.getProperty("missing_body_msg"), response.jsonPath().get("message"));
	}

	public static void postRequestToWebEngageWithRandomBodyText() {
		Response response = given().urlEncodingEnabled(false).log().all().given().contentType(ContentType.JSON)
				.header("username", property.getProperty("uname")).header("password", property.getProperty("pswd"))
				.header("appid", property.getProperty("appid"))
				.body(property.getProperty("version") + property.getProperty("ver_no") + ","
						+ property.getProperty("smsData") + "{" + property.getProperty("toNo")
						+ property.getProperty("mobilenumber") + "," + property.getProperty("fromNo")
						+ property.getProperty("from") + "," + property.getProperty("body") + loadRandomText()
						+ loadRandomPhoneNumber() + "}," + property.getProperty("metadata") + "{"
						+ property.getProperty("campaignType") + property.getProperty("pro_campaign") + ","
						+ property.getProperty("timestamp") + property.getProperty("timestamp_value") + ","
						+ property.getProperty("messageId") + property.getProperty("msg_id") + "} }")
				.when().post(property.getProperty("web_engage_path")).then().statusCode(HttpStatus.SC_OK).extract()
				.response();
		String statusLine = response.getStatusLine();
		System.out.print("response line is " + statusLine);
		int statusCode = response.getStatusCode();
		System.out.println(" reponse code is " + statusCode);
		Assert.assertEquals(property.getProperty("accepted"), response.jsonPath().get("status"));
	}

	public static void postRequestToWebEngageWithoutCampaignType() {
		Response response = given().urlEncodingEnabled(false).log().all().given().contentType(ContentType.JSON)
				.header("username", property.getProperty("uname")).header("password", property.getProperty("pswd"))
				.header("appid", property.getProperty("appid"))
				.body(property.getProperty("version") + property.getProperty("ver_no") + ","
						+ property.getProperty("smsData") + "{" + property.getProperty("toNo")
						+ property.getProperty("mobilenumber") + "," + property.getProperty("fromNo")
						+ property.getProperty("from") + "," + property.getProperty("body")
						+ property.getProperty("body_text") + "}," + property.getProperty("metadata") + "{"
						+ property.getProperty("timestamp") + property.getProperty("timestamp_value") + ","
						+ property.getProperty("messageId") + property.getProperty("msg_id") + "} }")
				.when().post(property.getProperty("web_engage_path")).then().statusCode(HttpStatus.SC_BAD_REQUEST)
				.extract().response();
		String statusLine = response.getStatusLine();
		System.out.print("response line is " + statusLine);
		int statusCode = response.getStatusCode();
		System.out.println(" reponse code is " + statusCode);
		Assert.assertEquals(property.getProperty("rejected"), response.jsonPath().get("status"));
		// Assert.assertEquals(property.getProperty("campaign_code"),
		// response.jsonPath().get("statusCode"));
		Assert.assertEquals(property.getProperty("campaign_msg"), response.jsonPath().get("message"));
	}

	public static void postRequestToWebEngageWithMissingCampaign() {
		Response response = given().urlEncodingEnabled(false).log().all().given().contentType(ContentType.JSON)
				.header("username", property.getProperty("uname")).header("password", property.getProperty("pswd"))
				.header("appid", property.getProperty("appid"))
				.body(property.getProperty("version") + property.getProperty("ver_no") + ","
						+ property.getProperty("smsData") + "{" + property.getProperty("toNo")
						+ property.getProperty("mobilenumber") + "," + property.getProperty("fromNo")
						+ property.getProperty("from") + "," + property.getProperty("body")
						+ property.getProperty("body_text") + "}," + property.getProperty("metadata") + "{"
						+ property.getProperty("campaignType") + property.getProperty("missing_item") + ","
						+ property.getProperty("timestamp") + property.getProperty("timestamp_value") + ","
						+ property.getProperty("messageId") + property.getProperty("msg_id") + "} }")
				.when().post(property.getProperty("web_engage_path")).then().statusCode(HttpStatus.SC_BAD_REQUEST)
				.extract().response();
		String statusLine = response.getStatusLine();
		System.out.print("response line is " + statusLine);
		int statusCode = response.getStatusCode();
		System.out.println(" reponse code is " + statusCode);
		Assert.assertEquals(property.getProperty("rejected"), response.jsonPath().get("status"));
		// Assert.assertEquals(property.getProperty("campaign_code"),
		// response.jsonPath().get("statusCode"));
		Assert.assertEquals(property.getProperty("campaign_msg"), response.jsonPath().get("message"));
	}

	public static void postRequestToWebEngageWithInvalidCampaign() {
		Response response = given().urlEncodingEnabled(false).log().all().given().contentType(ContentType.JSON)
				.header("username", property.getProperty("uname")).header("password", property.getProperty("pswd"))
				.header("appid", property.getProperty("appid"))
				.body(property.getProperty("version") + property.getProperty("ver_no") + ","
						+ property.getProperty("smsData") + "{" + property.getProperty("toNo")
						+ property.getProperty("mobilenumber") + "," + property.getProperty("fromNo")
						+ property.getProperty("from") + "," + property.getProperty("body")
						+ property.getProperty("body_text") + "}," + property.getProperty("metadata") + "{"
						+ property.getProperty("campaignType") + loadRandomText() + ","
						+ property.getProperty("timestamp") + property.getProperty("timestamp_value") + ","
						+ property.getProperty("messageId") + property.getProperty("msg_id") + "} }")
				.when().post(property.getProperty("web_engage_path")).then().statusCode(HttpStatus.SC_BAD_REQUEST)
				.extract().response();
		String statusLine = response.getStatusLine();
		System.out.print("response line is " + statusLine);
		int statusCode = response.getStatusCode();
		System.out.println(" reponse code is " + statusCode);
		Assert.assertEquals(property.getProperty("rejected"), response.jsonPath().get("status"));
		// Assert.assertEquals(property.getProperty("campaign_code"),
		// response.jsonPath().get("statusCode"));
		Assert.assertEquals(property.getProperty("campaign_msg"), response.jsonPath().get("message"));
	}

	public static void postRequestToWebEngageWithLowerCaseProCampaign() {
		Response response = given().urlEncodingEnabled(false).log().all().given().contentType(ContentType.JSON)
				.header("username", property.getProperty("uname")).header("password", property.getProperty("pswd"))
				.header("appid", property.getProperty("appid"))
				.body(property.getProperty("version") + property.getProperty("ver_no") + ","
						+ property.getProperty("smsData") + "{" + property.getProperty("toNo")
						+ property.getProperty("mobilenumber") + "," + property.getProperty("fromNo")
						+ property.getProperty("from") + "," + property.getProperty("body")
						+ property.getProperty("body_text") + "}," + property.getProperty("metadata") + "{"
						+ property.getProperty("campaignType") + property.getProperty("pro_campaign").toLowerCase()
						+ "," + property.getProperty("timestamp") + property.getProperty("timestamp_value") + ","
						+ property.getProperty("messageId") + property.getProperty("msg_id") + "} }")
				.when().post(property.getProperty("web_engage_path")).then().statusCode(HttpStatus.SC_OK).extract()
				.response();
		String statusLine = response.getStatusLine();
		System.out.print("response line is " + statusLine);
		int statusCode = response.getStatusCode();
		System.out.println(" reponse code is " + statusCode);
		Assert.assertEquals(property.getProperty("accepted"), response.jsonPath().get("status"));
	}

	public static void postRequestToWebEngageWithLowerCaseTraCampaign() {
		Response response = given().urlEncodingEnabled(false).log().all().given().contentType(ContentType.JSON)
				.header("username", property.getProperty("uname")).header("password", property.getProperty("pswd"))
				.header("appid", property.getProperty("appid"))
				.body(property.getProperty("version") + property.getProperty("ver_no") + ","
						+ property.getProperty("smsData") + "{" + property.getProperty("toNo")
						+ property.getProperty("mobilenumber") + "," + property.getProperty("fromNo")
						+ property.getProperty("from") + "," + property.getProperty("body")
						+ property.getProperty("body_text") + "}," + property.getProperty("metadata") + "{"
						+ property.getProperty("campaignType") + property.getProperty("tra_campaign").toLowerCase()
						+ "," + property.getProperty("timestamp") + property.getProperty("timestamp_value") + ","
						+ property.getProperty("messageId") + property.getProperty("msg_id") + "} }")
				.when().post(property.getProperty("web_engage_path")).then().statusCode(HttpStatus.SC_OK).extract()
				.response();
		String statusLine = response.getStatusLine();
		System.out.print("response line is " + statusLine);
		int statusCode = response.getStatusCode();
		System.out.println(" reponse code is " + statusCode);
		Assert.assertEquals(property.getProperty("accepted"), response.jsonPath().get("status"));
	}

	public static void postRequestToWebEngageWithoutMessageID() {
		Response response = given().urlEncodingEnabled(false).log().all().given().contentType(ContentType.JSON)
				.header("username", property.getProperty("uname")).header("password", property.getProperty("pswd"))
				.header("appid", property.getProperty("appid"))
				.body(property.getProperty("version") + property.getProperty("ver_no") + ","
						+ property.getProperty("smsData") + "{" + property.getProperty("toNo")
						+ property.getProperty("mobilenumber") + "," + property.getProperty("fromNo")
						+ property.getProperty("from") + "," + property.getProperty("body")
						+ property.getProperty("body_text") + "}," + property.getProperty("metadata") + "{"
						+ property.getProperty("campaignType") + property.getProperty("tra_campaign").toLowerCase()
						+ "," + property.getProperty("timestamp") + property.getProperty("timestamp_value") + "} }")
				.when().post(property.getProperty("web_engage_path")).then().statusCode(HttpStatus.SC_BAD_REQUEST).extract()
				.response();
		String statusLine = response.getStatusLine();
		System.out.print("response line is " + statusLine);
		int statusCode = response.getStatusCode();
		System.out.println(" reponse code is " + statusCode);
		Assert.assertEquals(property.getProperty("rejected"), response.jsonPath().get("status"));
		// Assert.assertEquals(property.getProperty("invalid_msg_code"),
		// response.jsonPath().get("statusCode"));
		Assert.assertEquals(property.getProperty("invalid_msgid_msg"), response.jsonPath().get("message"));
	}
	
	public static void postRequestToWebEngageWithMissingMsgId() {
		Response response = given().urlEncodingEnabled(false).log().all().given().contentType(ContentType.JSON)
				.header("username", property.getProperty("uname")).header("password", property.getProperty("pswd"))
				.header("appid", property.getProperty("appid"))
				.body(property.getProperty("version") + property.getProperty("ver_no") + ","
						+ property.getProperty("smsData") + "{" + property.getProperty("toNo")
						+ property.getProperty("mobilenumber") + "," + property.getProperty("fromNo")
						+ property.getProperty("from") + "," + property.getProperty("body")
						+ property.getProperty("body_text") + "}," + property.getProperty("metadata") + "{"
						+ property.getProperty("campaignType") + property.getProperty("pro_campaign") + ","
						+ property.getProperty("timestamp") + property.getProperty("timestamp_value") + ","
						+ property.getProperty("messageId") + property.getProperty("missing_item") + "} }")
				.when().post(property.getProperty("web_engage_path")).then().statusCode(HttpStatus.SC_BAD_REQUEST).extract()
				.response();
		String statusLine = response.getStatusLine();
		System.out.print("response line is " + statusLine);
		int statusCode = response.getStatusCode();
		System.out.println(" reponse code is " + statusCode);
		Assert.assertEquals(property.getProperty("rejected"), response.jsonPath().get("status"));
		Assert.assertEquals(property.getProperty("invalid_msgid_msg"), response.jsonPath().get("message"));
	}
	

}
