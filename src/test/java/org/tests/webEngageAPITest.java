package org.tests;

import org.pages.webEngageAPI;
import org.testng.annotations.Test;
import org.utility.RestAssuredMainClass;

public class webEngageAPITest extends RestAssuredMainClass {
	@Test(priority = 1, groups = { "Smoke", "Regression" }, description = "verify create new file API")
	@TestData(testId = 11)
	public static void postRequestToWebEngage() {
		webEngageAPI.postRequestToWebEngage();
	}

}
