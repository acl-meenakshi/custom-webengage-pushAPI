package org.pages;

import static io.restassured.RestAssured.given;

import java.io.File;

import io.restassured.response.Response;

import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.utility.RestAssuredMainClass;

/**
 * Page classes will extend RestAssuredMainClass so as to take all the functions
 * of the REST Assured. Here we will use BDD capability of Rest Assured to get
 * response./
 */

public class ObjectStoreFileAPI extends RestAssuredMainClass {
	/**
	 * This method will extract response from the request and store it in the
	 * response object of Response type. Also json path is getting stored in the
	 * Jsonpath variable so as to assert the result
	 */

	//static Logger logger = Logger.getLogger(ObjectStoreFileAPI.class);

	public static void postRequestToCreateNewFile() {
		String path = System.getProperty("user.dir")
				+ "/resources/config.properties";
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.header("Content-Type", "multipart/form-data")
				.given()
				.multiPart("file", new File(path), "multipart/form-data")
				.formParam(property.getProperty("filename"),
						loadRandomText() + property.getProperty("file_extension"))
				.formParam(
						property.getProperty("uploaded_file_path"),
						"/" + property.getProperty("temp_folder") + "/"
								+ property.getProperty("user_folder") + "/")
				.when().post(property.getProperty("api_object")).then()
				.statusCode(HttpStatus.SC_CREATED).extract().response();
		/** Get status line */
		String statusLine = response.getStatusLine();
		//logger.info("Status line is " + statusLine);
		/** Get status code */
		int statusCode = response.getStatusCode();
		//logger.info("Status Code is " + statusCode);
		/* Measuring Response Time */
		long timeInMs = response.time();
		//logger.info("Time taken is " + timeInMs);
		String body = response.getBody().asString();
		//logger.info("Response body is" + body);
		Assert.assertNotNull(response.jsonPath().get("filename"));
		Assert.assertNotNull(response.jsonPath().get("location"));
		Assert.assertNotNull(response.jsonPath().get("size"));
		Assert.assertNotNull(response.jsonPath().get("version"));
		Assert.assertNotNull(response.jsonPath().get("created_timestamp"));
		Assert.assertNotNull(response.jsonPath().get("last_updated_timestamp"));
	}

	/**
	 * Delete File API
	 * 
	 */
	public static void deleteRequestToDeletetFile() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.when()
				.delete(property.getProperty("api_object")
						+ property.getProperty("object_id")).then()
				.statusCode(HttpStatus.SC_OK).extract().response();
		// Get Status line
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		// Get status code
		int statusCode = response.getStatusCode();
		logger.info("Status code is " + statusCode);
	}

	public static void deleteRequestToDeletetFileIdNotExist() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.when()
				.delete(property.getProperty("api_object")
						+ property.getProperty("object_id")
						+ loadRandomPhoneNumber()).then()
				.statusCode(HttpStatus.SC_NOT_FOUND).extract().response();
		/* Get Status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/* Get status code */
		int statusCode = response.getStatusCode();
		logger.info("Status code is " + statusCode);
	}

	public static void deleteRequestToDeletetPathNotExist() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.when()
				.delete(property.getProperty("")
						+ property.getProperty("object_id")).then()
				.statusCode(HttpStatus.SC_NOT_FOUND).extract().response();
		/* Get Status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/* Get status code */
		int statusCode = response.getStatusCode();
		logger.info("Status code is " + statusCode);
	}

	/*
	 * Rename file
	 */
	public static void patchRequestToRenameFile() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.header("Content-Type", "application/json")
				.body(property.getProperty("rename_object")
						+ property.getProperty("rename_file_name") + "}")
				.when()
				.patch(property.getProperty("api_object")
						+ property.getProperty("file_id")).then()
				.statusCode(HttpStatus.SC_OK).extract().response();
		/* Get Status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/* Get Status code */
		int statusCode = response.getStatusCode();
		logger.info("Status code is " + statusCode);
		// TODO: Add assertion
	}

	public static void patchRequestToRenameFileWithoutObjectId() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.header("Content-Type", "application/json")
				.when()
				.body(property.getProperty("rename_object")
						+ property.getProperty("rename_file_name") + "}")
				.when().patch(property.getProperty("api_object")).then()
				.statusCode(HttpStatus.SC_BAD_REQUEST).extract().response();
		/* Get Status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/* Get Status code */
		int statusCode = response.getStatusCode();
		logger.info("Status code is " + statusCode);
	}

	public static void patchRequestToRenameFileObjectIdNotExist() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.header("Content-Type", "application/json")
				.body(property.getProperty("rename_object")
						+ property.getProperty("rename_file_name") + "}")
				.when()
				.patch(property.getProperty("api_object")
						+ property.getProperty("file_id"
								+ loadRandomPhoneNumber())).then()
				.statusCode(HttpStatus.SC_NOT_FOUND).extract().response();
		/* Get Status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/* Get Status code */
		int statusCode = response.getStatusCode();
		logger.info("Status code is " + statusCode);
	}

	public static void patchRequestToRenameFileWithoutHeader() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.body(property.getProperty("rename_object")
						+ property.getProperty("rename_file_name") + "}")
				.when()
				.patch(property.getProperty("api_object")
						+ property.getProperty("file_id")).then()
				.statusCode(HttpStatus.SC_UNSUPPORTED_MEDIA_TYPE).extract().response();
		/* Get Status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/* Get Status code */
		int statusCode = response.getStatusCode();
		logger.info("Status code is " + statusCode);
	}

	public static void patchRequestToRenameFileWithoutJsonBody() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.header("Content-Type", "application/json")
				.when()
				.patch(property.getProperty("api_object")
						+ property.getProperty("file_id")).then()
				.statusCode(HttpStatus.SC_OK).extract().response();
		/* Get Status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/* Get Status code */
		int statusCode = response.getStatusCode();
		logger.info("Status code is " + statusCode);
	}

	/*
	 * Move File
	 */
	public static void putRequestToMoveFile() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.param("from_uri",
						"/" + property.getProperty("temp_folder") + "/"
								+ property.getProperty("move_folder_from")
								+ property.getProperty("file_to_move"))
				.param("to_uri",
						"/" + property.getProperty("temp_folder") + "/"
								+ property.getProperty("move_folder_to"))
				.when().put(property.getProperty("api_folder")).then()
				.statusCode(HttpStatus.SC_OK).extract().response();
		/* Get Status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/* Get Status code */
		int statusCode = response.getStatusCode();
		logger.info("Status code is " + statusCode);
	}

	public static void putRequestToMoveFileWithoutFromUri() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.param("to_uri",
						"/" + property.getProperty("temp_folder") + "/"
								+ property.getProperty("move_folder_to"))
				.when().put(property.getProperty("api_folder")).then()
				.statusCode(HttpStatus.SC_BAD_REQUEST).extract().response();
		/* Get Status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/* Get Status code */
		int statusCode = response.getStatusCode();
		logger.info("Status code is " + statusCode);
	}

	public static void putRequestToMoveFileWithoutToUri() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.param("from_uri",
						"/" + property.getProperty("temp_folder") + "/"
								+ property.getProperty("move_folder_from")
								+ property.getProperty("file_to_move")).when()
				.put(property.getProperty("api_folder")).then()
				.statusCode(HttpStatus.SC_BAD_REQUEST).extract().response();
		/* Get Status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/* Get Status code */
		int statusCode = response.getStatusCode();
		logger.info("Status code is " + statusCode);
	}

	public static void putRequestToMoveFileWhenFromUriFolderNotExist() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.header("Content-Type", "application/json")
				.param("from_uri",
						"/" + property.getProperty("temp_folder") + "/"
								+ property.getProperty("move_folder_from")
								+ loadRandomText()
								+ property.getProperty("file_to_move"))
				.param("to_uri",
						"/" + property.getProperty("temp_folder") + "/"
								+ property.getProperty("move_folder_to"))
				.when().put(property.getProperty("api_folder")).then()
				.statusCode(HttpStatus.SC_BAD_REQUEST).extract().response();
		/* Get Status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/* Get Status code */
		int statusCode = response.getStatusCode();
		logger.info("Status code is " + statusCode);
	}

	public static void putRequestToMoveFileWhenToUriFolderNotExist() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.header("Content-Type", "application/json")
				.param("from_uri",
						"/" + property.getProperty("temp_folder") + "/"
								+ property.getProperty("move_folder_from")
								+ property.getProperty("file_to_move"))
				.param("to_uri",
						"/" + property.getProperty("temp_folder") + "/"
								+ property.getProperty("move_folder_to")
								+ loadRandomText()).when()
				.put(property.getProperty("api_folder")).then()
				.statusCode(HttpStatus.SC_BAD_REQUEST).extract().response();
		/* Get Status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/* Get Status code */
		int statusCode = response.getStatusCode();
		logger.info("Status code is " + statusCode);
	}

	/* Post request to share file via quickcode */

	public static void postRequestToShareFileViaQuickcode() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.header("Content-Type", "application/json")
				.body(property.getProperty("file_key")
						+ property.getProperty("share_folder") + "/"
						+ property.getProperty("user_folder") + "/"
						+ property.getProperty("share_file") + ","
						+ property.getProperty("file_validity")
						+ property.getProperty("validity") + "}").when()
				.post(property.getProperty("quick_code_share")).then()
				.statusCode(HttpStatus.SC_CREATED).extract().response();
		/** Get status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/** Get status code */
		int statusCode = response.getStatusCode();
		logger.info("Status Code is " + statusCode);
		/* Measuring Response Time */
		long timeInMs = response.time();
		logger.info("Time taken is " + timeInMs);
		String body = response.getBody().asString();
		logger.info("Response body is" + body);
		String quick_code = response.jsonPath().get("by_me.quick_code");
		Assert.assertNotNull(quick_code);
		logger.info("quick_code is" + quick_code);
		property.setProperty("quick_code", quick_code.toString());
		Assert.assertNotNull(response.jsonPath().get("by_me.id"));
		Assert.assertNotNull(response.jsonPath().get("by_me.quick_code"));
		Assert.assertNotNull(response.jsonPath().get("by_me.object_id"));
		Assert.assertNotNull(response.jsonPath().get(
				"by_me.valid_until_timestamp"));
		Assert.assertNotNull(response.jsonPath().get("for_me.id"));
		Assert.assertNotNull(response.jsonPath().get("for_me.quick_code"));
		Assert.assertNotNull(response.jsonPath().get("for_me.object_id"));
		Assert.assertNotNull(response.jsonPath().get(
				"for_me.valid_until_timestamp"));
		Assert.assertNotNull(response.jsonPath().get("objects.filename"));
		Assert.assertNotNull(response.jsonPath().get("objects.location"));
		Assert.assertNotNull(response.jsonPath().get(
				"objects.created_timestamp"));
		Assert.assertNotNull(response.jsonPath().get(
				"objects.last_updated_timestamp"));
	}

	public static void postRequestToShareFileViaQuickcodeWithNullValidity() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.header("Content-Type", "application/json")
				.body(property.getProperty("file_key")
						+ property.getProperty("share_folder") + "/"
						+ property.getProperty("user_folder") + "/"
						+ property.getProperty("share_file") + ","
						+ property.getProperty("file_validity")
						+ property.getProperty("") + "}").when()
				.post(property.getProperty("quick_code_share")).then()
				.statusCode(HttpStatus.SC_BAD_REQUEST).extract().response();
		/** Get status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/** Get status code */
		int statusCode = response.getStatusCode();
		logger.info("Status Code is " + statusCode);
	}

	public static void postRequestToShareFileViaQuickcodeWithoutValidityParam() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.header("Content-Type", "application/json")
				.body(property.getProperty("file_key")
						+ property.getProperty("share_folder") + "/"
						+ property.getProperty("user_folder") + "/"
						+ property.getProperty("share_file") + "}").when()
				.post(property.getProperty("quick_code_share")).then()
				.statusCode(HttpStatus.SC_BAD_REQUEST).extract().response();
		/** Get status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/** Get status code */
		int statusCode = response.getStatusCode();
		logger.info("Status Code is " + statusCode);
	}

	public static void postRequestToShareFileViaQuickcodeWithoutFilename() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.header("Content-Type", "application/json")
				.body(property.getProperty("file_key")
						+ property.getProperty("share_folder") + "/"
						+ property.getProperty("user_folder") + "/" + ","
						+ property.getProperty("file_validity")
						+ property.getProperty("validity") + "}").when()
				.post(property.getProperty("quick_code_share")).then()
				.statusCode(HttpStatus.SC_BAD_REQUEST).extract().response();
		/** Get status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/** Get status code */
		int statusCode = response.getStatusCode();
		logger.info("Status Code is " + statusCode);
	}

	public static void postRequestToShareFileViaQuickcodeWithoutKeyParam() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.header("Content-Type", "application/json")
				.body("{" + property.getProperty("file_validity")
						+ property.getProperty("validity") + "}").when()
				.post(property.getProperty("quick_code_share")).then()
				.statusCode(HttpStatus.SC_BAD_REQUEST).extract().response();
		/** Get status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/** Get status code */
		int statusCode = response.getStatusCode();
		logger.info("Status Code is " + statusCode);
	}

	public static void postRequestToShareFileViaQuickcodeWhenFolderNotExist() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.header("Content-Type", "application/json")
				.body(property.getProperty("file_key")
						+ property.getProperty("share_folder") + "/"
						+ property.getProperty("user_folder")
						+ loadRandomText() + "/"
						+ property.getProperty("share_file") + ","
						+ property.getProperty("file_validity")
						+ property.getProperty("validity") + "}").when()
				.post(property.getProperty("quick_code_share")).then()
				.statusCode(HttpStatus.SC_NOT_IMPLEMENTED).extract().response();
		/** Get status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/** Get status code */
		int statusCode = response.getStatusCode();
		logger.info("Status Code is " + statusCode);
	}

	public static void postRequestToShareFileViaQuickcodeWhenFileNotExist() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.header("Content-Type", "application/json")
				.body(property.getProperty("file_key")
						+ property.getProperty("share_folder") + "/"
						+ property.getProperty("user_folder") + "/"
						+ loadRandomText() + property.getProperty("share_file")
						+ "," + property.getProperty("file_validity")
						+ property.getProperty("validity") + "}").when()
				.post(property.getProperty("quick_code_share")).then()
				.statusCode(HttpStatus.SC_NOT_IMPLEMENTED).extract().response();
		/** Get status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/** Get status code */
		int statusCode = response.getStatusCode();
		logger.info("Status Code is " + statusCode);
	}

	public static void postRequestToShareFileViaQuickcodeWhenValidityIsRandomValue() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.header("Content-Type", "application/json")
				.body(property.getProperty("file_key")
						+ property.getProperty("share_folder")
						+ "/"
						+ property.getProperty("user_folder")
						+ "/"
						+ property.getProperty("share_file")
						+ ","
						+ property.getProperty("file_validity")
						+ property.getProperty("validity"
								+ loadRandomPhoneNumber()) + "}").when()
				.post(property.getProperty("quick_code_share")).then()
				.statusCode(HttpStatus.SC_BAD_REQUEST).extract().response();
		/** Get status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/** Get status code */
		int statusCode = response.getStatusCode();
		logger.info("Status Code is " + statusCode);
	}

	public static void postRequestToShareFileViaQuickcodeWhenValidityIsZero() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.header("Content-Type", "application/json")
				.body(property.getProperty("file_key")
						+ property.getProperty("share_folder") + "/"
						+ property.getProperty("user_folder") + "/"
						+ property.getProperty("share_file") + ","
						+ property.getProperty("file_validity") + "0" + "}")
				.when().post(property.getProperty("quick_code_share")).then()
				.statusCode(HttpStatus.SC_BAD_REQUEST).extract().response();
		/** Get status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/** Get status code */
		int statusCode = response.getStatusCode();
		logger.info("Status Code is " + statusCode);
	}

	/* Delete API of shared file */

	public static void deleteRequestToShareFileViaQuickcode() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.when()
				.delete(property.getProperty("quick_code_share")
						+ property.getProperty("share_id") + "/").then()
				.statusCode(HttpStatus.SC_OK).extract().response();
		/* Get Status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/* Get status code */
		int statusCode = response.getStatusCode();
		logger.info("Status code is " + statusCode);
	}

	public static void deleteRequestToShareFileViaQuickcodeWhenIdNotExist() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.when()
				.delete(property.getProperty("quick_code_share")
						+ property.getProperty("share_id"
								+ loadRandomPhoneNumber()) + "/").then()
				.statusCode(HttpStatus.SC_NOT_FOUND).extract().response();
		/* Get Status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/* Get status code */
		int statusCode = response.getStatusCode();
		logger.info("Status code is " + statusCode);
	}

	public static void deleteRequestToShareFileViaQuickcodeWhenIdNotGiven() {
		Response response = given().urlEncodingEnabled(false).log().all()
				.when().delete(property.getProperty("quick_code_share")).then()
				.statusCode(HttpStatus.SC_BAD_REQUEST).extract().response();
		/* Get Status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/* Get status code */
		int statusCode = response.getStatusCode();
		logger.info("Status code is " + statusCode);
	}

	public static void deleteRequestToShareFileViaQuickcodeWithInvalidUrl() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.when()
				.delete(property.getProperty("quick_code_share"
						+ loadRandomText() + "/")
						+ property.getProperty("share_id") + "/").then()
				.statusCode(HttpStatus.SC_NOT_FOUND).extract().response();
		/* Get Status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/* Get status code */
		int statusCode = response.getStatusCode();
		logger.info("Status code is " + statusCode);
	}

	public static void getRequestToShareFileViaQuickcode() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.header("Authorization", property.getProperty("quick_code"))
				.when()
				.get(property.getProperty("quick_code_share")
						+ property.getProperty("share_id")).then()
				.statusCode(HttpStatus.SC_OK).extract().response();
		/** Get status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/** Get status code */
		int statusCode = response.getStatusCode();
		logger.info("Status Code is " + statusCode);
		/* Measuring Response Time */
		long timeInMs = response.time();
		logger.info("Time taken is " + timeInMs);
		String body = response.getBody().asString();
		logger.info("Response body is" + body);
	}

	public static void getRequestToShareFileViaQuickcodeWithoutQuickcode() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.header("Authorization", "")
				.when()
				.get(property.getProperty("quick_code_share")
						+ property.getProperty("share_id")).then()
				.statusCode(HttpStatus.SC_BAD_REQUEST).extract().response();
		/** Get status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/** Get status code */
		int statusCode = response.getStatusCode();
		logger.info("Status Code is " + statusCode);
		/* Measuring Response Time */
		long timeInMs = response.time();
		logger.info("Time taken is " + timeInMs);
		String body = response.getBody().asString();
		logger.info("Response body is" + body);
	}

	public static void getRequestToShareFileViaQuickcodeWithoutAuthorization() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.when()
				.get(property.getProperty("quick_code_share")
						+ property.getProperty("share_id")).then()
				.statusCode(HttpStatus.SC_NOT_FOUND).extract().response();
		/** Get status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/** Get status code */
		int statusCode = response.getStatusCode();
		logger.info("Status Code is " + statusCode);
		/* Measuring Response Time */
		long timeInMs = response.time();
		logger.info("Time taken is " + timeInMs);
		String body = response.getBody().asString();
		logger.info("Response body is" + body);
	}

	public static void getRequestToShareFileViaQuickcodeWithInvalidQuickcode() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.header("Authorization",
						property.getProperty("quick_code") + loadRandomText())
				.when()
				.get(property.getProperty("quick_code_share")
						+ property.getProperty("share_id")
						+ loadRandomPhoneNumber() + "/").then()
				.statusCode(HttpStatus.SC_NOT_FOUND).extract().response();
		/** Get status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/** Get status code */
		int statusCode = response.getStatusCode();
		logger.info("Status Code is " + statusCode);
		/* Measuring Response Time */
		long timeInMs = response.time();
		logger.info("Time taken is " + timeInMs);
		String body = response.getBody().asString();
		logger.info("Response body is" + body);
	}

	public static void getRequestToShareFileViaQuickcodeExpiredValidity() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.header("Authorization",
						property.getProperty("expired_quickcode"))
				.when()
				.get(property.getProperty("quick_code_share")
						+ property.getProperty("expired_share_id")).then()
				.statusCode(HttpStatus.SC_NOT_FOUND).extract().response();
		/** Get status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/** Get status code */
		int statusCode = response.getStatusCode();
		logger.info("Status Code is " + statusCode);
		/* Measuring Response Time */
		long timeInMs = response.time();
		logger.info("Time taken is " + timeInMs);
		String body = response.getBody().asString();
		logger.info("Response body is" + body);
	}

	/* Share file via static url */

	public static void postRequestToShareFileViaStaticUrl() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.header("Content-Type", "application/json")
				.body(property.getProperty("file_key")
						+ property.getProperty("share_folder") + "/"
						+ property.getProperty("user_folder") + "/"
						+ property.getProperty("share_file") + ","
						+ property.getProperty("file_validity")
						+ property.getProperty("validity") + "}").when()
				.post(property.getProperty("static_file_share")).then()
				.statusCode(HttpStatus.SC_CREATED).extract().response();
		/** Get status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/** Get status code */
		int statusCode = response.getStatusCode();
		logger.info("Status Code is " + statusCode);
		/* Measuring Response Time */
		long timeInMs = response.time();
		logger.info("Time taken is " + timeInMs);
		String body = response.getBody().asString();
		logger.info("Response body is" + body);
		String quick_code = response.jsonPath().get("by_me.quick_code");
		property.setProperty("quick_code", quick_code.toString());
		Assert.assertSame(property.getProperty("quick_code"), "");
		Assert.assertNotNull(response.jsonPath().get("for_me.id"));
		Assert.assertNotNull(response.jsonPath().get("for_me.object_id"));
		Assert.assertNotNull(response.jsonPath().get(
				"for_me.valid_until_timestamp"));
		Assert.assertSame(property.getProperty("quick_code"), "");
		Assert.assertNotNull(response.jsonPath().get("by_me.id"));
		Assert.assertNotNull(response.jsonPath().get("by_me.object_id"));
		Assert.assertNotNull(response.jsonPath().get(
				"by_me.valid_until_timestamp"));
		Assert.assertNotNull(response.jsonPath().get("objects.filename"));
		Assert.assertNotNull(response.jsonPath().get("objects.location"));
		Assert.assertNotNull(response.jsonPath().get(
				"objects.created_timestamp"));
		Assert.assertNotNull(response.jsonPath().get(
				"objects.last_updated_timestamp"));
	}

	public static void deleteRequestToUnShareFileViaStaticUrl() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.when()
				.delete(property.getProperty("static_file_share")
						+ property.getProperty("share_id") + "/").then()
				.statusCode(HttpStatus.SC_OK).extract().response();
		/* Get Status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/* Get status code */
		int statusCode = response.getStatusCode();
		logger.info("Status code is " + statusCode);
	}

	public static void deleteRequestToShareFileViaStaticUrlWhenIdNotExist() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.when()
				.delete(property.getProperty("static_file_share")
						+ property.getProperty("share_id"
								+ loadRandomPhoneNumber()) + "/").then()
				.statusCode(HttpStatus.SC_NOT_FOUND).extract().response();
		/* Get Status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/* Get status code */
		int statusCode = response.getStatusCode();
		logger.info("Status code is " + statusCode);
	}

	public static void deleteRequestToShareFileViaStaticUrlWhenIdNotGiven() {
		Response response = given().urlEncodingEnabled(false).log().all()
				.when().delete(property.getProperty("static_file_share"))
				.then().statusCode(HttpStatus.SC_BAD_REQUEST).extract()
				.response();
		/* Get Status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/* Get status code */
		int statusCode = response.getStatusCode();
		logger.info("Status code is " + statusCode);
	}

	public static void deleteRequestToShareFileViaStaticUrlWithInvalidUrl() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.when()
				.delete(property.getProperty("static_file_share"
						+ loadRandomText() + "/")
						+ property.getProperty("share_id") + "/").then()
				.statusCode(HttpStatus.SC_NOT_FOUND).extract().response();
		/* Get Status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/* Get status code */
		int statusCode = response.getStatusCode();
		logger.info("Status code is " + statusCode);
	}

	public static void getRequestToShareFileViaStaticUrl() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.when()
				.get(property.getProperty("static_file_share")
						+ property.getProperty("static_url_share_id")).then()
				.statusCode(HttpStatus.SC_OK).extract().response();
		/** Get status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/** Get status code */
		int statusCode = response.getStatusCode();
		logger.info("Status Code is " + statusCode);
		/* Measuring Response Time */
		long timeInMs = response.time();
		logger.info("Time taken is " + timeInMs);
		String body = response.getBody().asString();
		logger.info("Response body is" + body);
	}

	public static void getRequestToShareFileViaStaticUrlExpiredValidity() {
		Response response = given()
				.urlEncodingEnabled(false)
				.log()
				.all()
				.when()
				.get(property.getProperty("static_url_share_id")
						+ property.getProperty("expired_share_id")).then()
				.statusCode(HttpStatus.SC_NOT_FOUND).extract().response();
		/** Get status line */
		String statusLine = response.getStatusLine();
		logger.info("Status line is " + statusLine);
		/** Get status code */
		int statusCode = response.getStatusCode();
		logger.info("Status Code is " + statusCode);
		/* Measuring Response Time */
		long timeInMs = response.time();
		logger.info("Time taken is " + timeInMs);
		String body = response.getBody().asString();
		logger.info("Response body is" + body);
	}

}
