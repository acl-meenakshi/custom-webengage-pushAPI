package org.tests;

import org.pages.webEngageAPI;
import org.testng.annotations.Test;
import org.utility.RestAssuredMainClass;

public class webEngageAPITest extends RestAssuredMainClass {
	@Test(priority = 1, groups = { "Smoke", "Regression" }, description = "verify web engage API ")
	public static void postRequestToWebEngage() {
		webEngageAPI.postRequestToWebEngage();
	}

}
