package org.tests;

import org.pages.webEngageAPI;
import org.testng.annotations.Test;
import org.utility.RestAssuredMainClass;

public class webEngageAPITest extends RestAssuredMainClass {
	@Test(priority = 1, groups = { "Smoke",
			"Regression" }, description = "verify WebEngage API with valid uname and pswd for PROMOTIONAL campaignType")
	public static void postRequestToWebEngageProCam() {
		webEngageAPI.postRequestToWebEngageProCam();
	}

	@Test(priority = 1, groups = { "Smoke",
			"Regression" }, description = "verify WebEngage API with valid uname and pswd for TRANSACTIONAL campaignType")
	public static void postRequestToWebEngageTranCamp() {
		webEngageAPI.postRequestToWebEngageTranCamp();
	}

	@Test(priority = 2, groups = { "Smoke", "Regression" }, description = "verify WebEngage API with invalid uname")
	public static void postRequestToWebEngageWithInvalidUsername() {
		webEngageAPI.postRequestToWebEngageWithInvalidUsername();
	}

	@Test(priority = 2, groups = { "Smoke", "Regression" }, description = "verify WebEngage API with invalid pswd")
	public static void postRequestToWebEngageWithInvalidPswd() {
		webEngageAPI.postRequestToWebEngageWithInvalidPswd();
	}

	@Test(priority = 2, groups = { "Smoke", "Regression" }, description = "verify WebEngage API with blank uname")
	public static void postRequestToWebEngageWithBlankUsername() {
		webEngageAPI.postRequestToWebEngageWithBlankUsername();
	}

	@Test(priority = 2, groups = { "Smoke", "Regression" }, description = "verify WebEngage API with blank pswd")
	public static void postRequestToWebEngageWithBlankPswd() {
		webEngageAPI.postRequestToWebEngageWithBlankPswd();
	}

	@Test(priority = 2, groups = { "Smoke", "Regression" }, description = "verify WebEngage API without uname param")
	public static void postRequestToWebEngageWithoutUsername() {
		webEngageAPI.postRequestToWebEngageWithoutUsername();
	}

	@Test(priority = 2, groups = { "Smoke", "Regression" }, description = "verify WebEngage API without pswd param")
	public static void postRequestToWebEngageWithoutPswd() {
		webEngageAPI.postRequestToWebEngageWithoutPswd();
	}

	@Test(priority = 2, groups = { "Smoke", "Regression" }, description = "verify WebEngage API without AppId")
	public static void postRequestToWebEngageWithoutAppId() {
		webEngageAPI.postRequestToWebEngageWithoutAppId();
	}

	@Test(priority = 2, groups = { "Smoke", "Regression" }, description = "verify WebEngage API with blank AppId")
	public static void postRequestToWebEngageWithBlankAppid() {
		webEngageAPI.postRequestToWebEngageWithBlankAppid();
	}

	@Test(priority = 2, groups = { "Smoke", "Regression" }, description = "verify WebEngage API with invalid AppId")
	public static void postRequestToWebEngageWithInvalidAppId() {
		webEngageAPI.postRequestToWebEngageWithInvalidAppId();
	}

	@Test(priority = 2, groups = { "Smoke", "Regression" }, description = "verify WebEngage API without version")
	public static void postRequestToWebEngageWithoutVersion() {
		webEngageAPI.postRequestToWebEngageWithoutVersion();
	}

	@Test(priority = 2, groups = { "Smoke", "Regression" }, description = "verify WebEngage API with blank version")
	public static void postRequestToWebEngageWithMissingVersion() {
		webEngageAPI.postRequestToWebEngageWithMissingVersion();
	}

	@Test(priority = 2, groups = { "Smoke", "Regression" }, description = "verify WebEngage API with invalid version")
	public static void postRequestToWebEngageWithInvalidVersion() {
		webEngageAPI.postRequestToWebEngageWithInvalidVersion();
	}

	@Test(priority = 2, groups = { "Smoke", "Regression" }, description = "verify WebEngage API without toNumber")
	public static void postRequestToWebEngageWithoutToNumber() {
		webEngageAPI.postRequestToWebEngageWithoutToNumber();
	}

	@Test(priority = 2, groups = { "Smoke", "Regression" }, description = "verify WebEngage API with blank toNumber")
	public static void postRequestToWebEngageWithMissingToNumber() {
		webEngageAPI.postRequestToWebEngageWithMissingToNumber();
	}

	@Test(priority = 2, groups = { "Smoke",
			"Regression" }, description = "verify WebEngage API with string in ToNumber")
	public static void postRequestToWebEngageWithStringToNumber() {
		webEngageAPI.postRequestToWebEngageWithStringToNumber();
	}

	@Test(priority = 2, groups = { "Smoke", "Regression" }, description = "verify WebEngage API without countryCode")
	public static void postRequestToWebEngageWithoutCountryCode() {
		webEngageAPI.postRequestToWebEngageWithoutCountryCode();
	}

	@Test(priority = 2, groups = { "Smoke", "Regression" }, description = "verify WebEngage API without fromNumber")
	public static void postRequestToWebEngageWithoutFromNumber() {
		webEngageAPI.postRequestToWebEngageWithoutFromNumber();
	}

	@Test(priority = 2, groups = { "Smoke", "Regression" }, description = "verify WebEngage API with blank fromNumber")
	public static void postRequestToWebEngageWithMissingFromNumber() {
		webEngageAPI.postRequestToWebEngageWithMissingFromNumber();
	}

	@Test(priority = 1, groups = { "Smoke",
			"Regression" }, description = "verify WebEngage API with string in fromNumber")
	public static void postRequestToWebEngageWithStringInFromNumber() {
		webEngageAPI.postRequestToWebEngageWithStringInFromNumber();
	}

	@Test(priority = 1, groups = { "Smoke", "Regression" }, description = "verify WebEngage API with int in fromNumber")
	public static void postRequestToWebEngageWithIntInFromNumber() {
		webEngageAPI.postRequestToWebEngageWithIntInFromNumber();
	}

	@Test(priority = 1, groups = { "Smoke",
			"Regression" }, description = "verify WebEngage API with special character in fromNumber")
	public static void postRequestToWebEngageWithSpecialChracterFromNumber() {
		webEngageAPI.postRequestToWebEngageWithSpecialChracterFromNumber();
	}

	@Test(priority = 2, groups = { "Smoke", "Regression" }, description = "verify WebEngage API without Body tag")
	public static void postRequestToWebEngageWithoutBodyTag() {
		webEngageAPI.postRequestToWebEngageWithoutBodyTag();
	}

	@Test(priority = 2, groups = { "Smoke", "Regression" }, description = "verify WebEngage API with blank body text")
	public static void postRequestToWebEngageWithMissingBodyText() {
		webEngageAPI.postRequestToWebEngageWithMissingBodyText();
	}

	@Test(priority = 1, groups = { "Smoke", "Regression" }, description = "verify WebEngage API with random body text")
	public static void postRequestToWebEngageWithRandomBodyText() {
		webEngageAPI.postRequestToWebEngageWithRandomBodyText();
	}

	@Test(priority = 2, groups = { "Smoke", "Regression" }, description = "verify WebEngage API without campaign type")
	public static void postRequestToWebEngageWithoutCampaignType() {
		webEngageAPI.postRequestToWebEngageWithoutCampaignType();
	}

	@Test(priority = 2, groups = { "Smoke",
			"Regression" }, description = "verify WebEngage API with blank campaign type")
	public static void postRequestToWebEngageWithMissingCampaign() {
		webEngageAPI.postRequestToWebEngageWithMissingCampaign();
	}

	@Test(priority = 2, groups = { "Smoke", "Regression" }, description = "verify WebEngage API with invalid campaign")
	public static void postRequestToWebEngageWithInvalidCampaign() {
		webEngageAPI.postRequestToWebEngageWithInvalidCampaign();
	}

	@Test(priority = 1, groups = { "Smoke",
			"Regression" }, description = "verify WebEngage API with lcase Promtional campaign")
	public static void postRequestToWebEngageWithLowerCaseProCampaign() {
		webEngageAPI.postRequestToWebEngageWithLowerCaseProCampaign();
	}

	@Test(priority = 1, groups = { "Smoke",
			"Regression" }, description = "verify WebEngage API with lcase Transactional campaign")
	public static void postRequestToWebEngageWithLowerCaseTraCampaign() {
		webEngageAPI.postRequestToWebEngageWithLowerCaseTraCampaign();
	}

	@Test(priority = 1, groups = { "Smoke", "Regression" }, description = "verify WebEngage API without msg id")
	public static void postRequestToWebEngageWithoutMessageID() {
		webEngageAPI.postRequestToWebEngageWithoutMessageID();
	}

	@Test(priority = 1, groups = { "Smoke", "Regression" }, description = "verify WebEngage API with missing msg id")
	public static void postRequestToWebEngageWithMissingMsgId() {
		webEngageAPI.postRequestToWebEngageWithMissingMsgId();
	}

}
