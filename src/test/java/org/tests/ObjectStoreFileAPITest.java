package org.tests;

import org.pages.ObjectStoreFileAPI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.utility.Reporting;
import org.utility.RestAssuredMainClass;
import org.utility.TestUpdater;

@Listeners(value = { TestUpdater.class, Reporting.class })
public class ObjectStoreFileAPITest extends RestAssuredMainClass {

	/* POST API used for files. */

	@Test(priority = 1, groups = { "Smoke", "Regression" }, description = "verify create new file API")
	@TestData(testId = 11)
	public static void postRequestToCreateNewFile() {
		ObjectStoreFileAPI.postRequestToCreateNewFile();
	}

	/* DELETE API used for files. */

	@Test(priority = 1, groups = { "Smoke", "Regression" }, description = "verify delete file API")
	@TestData(testId = 11)
	public static void deleteRequestToDeletetFile() {
		ObjectStoreFileAPI.deleteRequestToDeletetFile();
	}

	@Test(priority = 2, groups = { "Regression" }, description = "verify delete file API when ObjectId not exist")
	@TestData(testId = 11)
	public static void deleteRequestToDeletetFileIdNotExist() {
		ObjectStoreFileAPI.deleteRequestToDeletetFileIdNotExist();
	}

	@Test(priority = 3, groups = { "Regression" }, description = "verify delete file API when Objectpath not exist")
	@TestData(testId = 11)
	public static void deleteRequestToDeletetPathNotExist() {
		ObjectStoreFileAPI.deleteRequestToDeletetPathNotExist();
	}

	/* Rename API used for files . */

	@Test(priority = 1, groups = { "Smoke", "Regression" }, description = "verify rename file API")
	@TestData(testId = 11)
	public static void patchRequestToRenameFile() {
		ObjectStoreFileAPI.patchRequestToRenameFile();
	}

	@Test(priority = 2, groups = { "Regression" }, description = "verify rename file API without objectid")
	@TestData(testId = 11)
	public static void patchRequestToRenameFileWithoutObjectId() {
		ObjectStoreFileAPI.patchRequestToRenameFileWithoutObjectId();
	}

	@Test(priority = 2, groups = { "Regression" }, description = "verify rename file API, objectid Does Not Exist")
	@TestData(testId = 11)
	public static void patchRequestToRenameFileObjectIdNotExist() {
		ObjectStoreFileAPI.patchRequestToRenameFileObjectIdNotExist();
	}

	@Test(priority = 3, groups = { "Regression" }, description = "verify rename file API, without header")
	@TestData(testId = 11)
	public static void patchRequestToRenameFileWithoutHeader() {
		ObjectStoreFileAPI.patchRequestToRenameFileWithoutHeader();
	}

	@Test(priority = 3, groups = { "Regression" }, description = "verify rename file API, without JSON body")
	@TestData(testId = 11)
	public static void patchRequestToRenameFileWithoutJsonBody() {
		ObjectStoreFileAPI.patchRequestToRenameFileWithoutJsonBody();
	}

	/* Move API used for files . */

	@Test(priority = 1, groups = { "Smoke", "Regression" }, description = "verify move file API")
	@TestData(testId = 11)
	public static void putRequestToMoveFile() {
		ObjectStoreFileAPI.putRequestToMoveFile();
	}

	@Test(priority = 2, groups = { "Regression" }, description = "verify move file API without From Uri param")
	@TestData(testId = 11)
	public static void putRequestToMoveFileWithoutFromUri() {
		ObjectStoreFileAPI.putRequestToMoveFileWithoutFromUri();
	}

	@Test(priority = 2, groups = { "Regression" }, description = "verify move file API without To Uri param")
	@TestData(testId = 11)
	public static void putRequestToMoveFileWithoutToUri() {
		ObjectStoreFileAPI.putRequestToMoveFileWithoutToUri();
	}

	@Test(priority = 3, groups = { "Regression" }, description = "verify move file API When From Uri folder not exist")
	@TestData(testId = 11)
	public static void putRequestToMoveFileWhenFromUriFolderNotExist() {
		ObjectStoreFileAPI.putRequestToMoveFileWhenFromUriFolderNotExist();
	}

	@Test(priority = 3, groups = { "Regression" }, description = "verify move file API When To Uri foldr not exist")
	@TestData(testId = 11)
	public static void putRequestToMoveFileWhenToUriFolderNotExist() {
		ObjectStoreFileAPI.putRequestToMoveFileWhenToUriFolderNotExist();
	}

	/* File sharing via Quick code */

	@Test(priority = 1, groups = { "Smoke", "Regression" }, description = "verify file sharing via Quick code")
	@TestData(testId = 11)
	public static void postRequestToShareFileViaQuickcode() {
		ObjectStoreFileAPI.postRequestToShareFileViaQuickcode();
	}

	@Test(priority = 3, groups = { "Regression" }, description = "verify file sharing via Quick code with null validity")
	@TestData(testId = 11)
	public static void postRequestToShareFileViaQuickcodeWithNullValidity() {
		ObjectStoreFileAPI.postRequestToShareFileViaQuickcodeWithNullValidity();
	}

	@Test(priority = 3, groups = { "Regression" }, description = "verify file sharing via Quick code without validity")
	@TestData(testId = 11)
	public static void postRequestToShareFileViaQuickcodeWithoutValidity() {
		ObjectStoreFileAPI
				.postRequestToShareFileViaQuickcodeWithoutValidityParam();
	}

	@Test(priority = 3, groups = { "Regression" }, description = "verify file sharing via Quick code without filename")
	@TestData(testId = 11)
	public static void postRequestToShareFileViaQuickcodeWithoutFileValue() {
		ObjectStoreFileAPI.postRequestToShareFileViaQuickcodeWithoutFilename();
	}

	@Test(priority = 3, groups = { "Regression" }, description = "verify file sharing via Quick code without key param")
	@TestData(testId = 11)
	public static void postRequestToShareFileViaQuickcodeWithoutKeyParam() {
		ObjectStoreFileAPI.postRequestToShareFileViaQuickcodeWithoutKeyParam();
	}

	@Test(priority = 3, groups = { "Regression" }, description = "verify file sharing via Quick code when folder not exist")
	@TestData(testId = 11)
	public static void postRequestToShareFileViaQuickcodeWhenFolderNotExist() {
		ObjectStoreFileAPI
				.postRequestToShareFileViaQuickcodeWhenFolderNotExist();
	}

	@Test(priority = 3, groups = { "Regression" }, description = "verify file sharing via Quick code when file not exist")
	@TestData(testId = 11)
	public static void postRequestToShareFileViaQuickcodeWhenFileNotExist() {
		ObjectStoreFileAPI.postRequestToShareFileViaQuickcodeWhenFileNotExist();
	}

	@Test(priority = 3, groups = { "Regression" }, description = "verify file sharing via Quick code when validity is zero")
	@TestData(testId = 11)
	public static void postRequestToShareFileViaQuickcodeWhenValidityIsZero() {
		ObjectStoreFileAPI
				.postRequestToShareFileViaQuickcodeWhenValidityIsZero();
	}

	@Test(priority = 3, groups = { "Regression" }, description = "verify file sharing via Quick code when validity is random number")
	@TestData(testId = 11)
	public static void postRequestToShareFileViaQuickcodeWhenValidityIsRandomValue() {
		ObjectStoreFileAPI
				.postRequestToShareFileViaQuickcodeWhenValidityIsRandomValue();
	}

	@Test(priority = 3, groups = { "Regression" }, description = "verify unshared file delete request")
	@TestData(testId = 11)
	public static void deleteRequestToShareFileViaQuickcode() {
		ObjectStoreFileAPI.deleteRequestToShareFileViaQuickcode();
	}

	@Test(priority = 3, groups = { "Regression" }, description = "verify unshared file delete request when id not exist")
	@TestData(testId = 11)
	public static void deleteRequestToShareFileViaQuickcodeWhenIdNotExist() {
		ObjectStoreFileAPI.deleteRequestToShareFileViaQuickcodeWhenIdNotExist();
	}

	@Test(priority = 3, groups = { "Regression" }, description = "verify unshared file delete request when id not given")
	@TestData(testId = 11)
	public static void deleteRequestToShareFileViaQuickcodeWhenIdNotGiven() {
		ObjectStoreFileAPI.deleteRequestToShareFileViaQuickcodeWhenIdNotGiven();
	}

	@Test(priority = 3, groups = { "Smoke", "Regression" }, description = "verify unshared file delete with invalid url")
	@TestData(testId = 11)
	public static void deleteRequestToShareFileViaQuickcodeWithInvalidUrl() {
		ObjectStoreFileAPI.deleteRequestToShareFileViaQuickcodeWithInvalidUrl();
	}

	@Test(priority = 2, groups = { "Smoke", "Regression" }, description = "Get Quickcode shared file info")
	@TestData(testId = 11)
	public static void getRequestToShareFileViaQuickcode() {
		ObjectStoreFileAPI.getRequestToShareFileViaQuickcode();
	}

	@Test(priority = 3, groups = { "Smoke", "Regression" }, description = "Get Quickcode shared file info without quickcode")
	@TestData(testId = 11)
	public static void getRequestToShareFileViaQuickcodeWithoutQuickcode() {
		ObjectStoreFileAPI.getRequestToShareFileViaQuickcodeWithoutQuickcode();
	}

	@Test(priority = 3, groups = { "Smoke", "Regression" }, description = "Get Quickcode shared file info without authorization")
	@TestData(testId = 11)
	public static void getRequestToShareFileViaQuickcodeWithoutAuthorization() {
		ObjectStoreFileAPI
				.getRequestToShareFileViaQuickcodeWithoutAuthorization();
	}

	@Test(priority = 3, groups = { "Smoke", "Regression" }, description = "Get Quickcode shared file info with invalid quickcode")
	@TestData(testId = 11)
	public static void getRequestToShareFileViaQuickcodeWithInvalidQuickcode() {
		ObjectStoreFileAPI
				.getRequestToShareFileViaQuickcodeWithInvalidQuickcode();
	}

	@Test(priority = 3, groups = { "Smoke", "Regression" }, description = "Get Quickcode shared file info with invalid quickcode")
	@TestData(testId = 11)
	public static void getRequestToShareFileViaQuickcodeExpiredValidity() {
		ObjectStoreFileAPI.getRequestToShareFileViaQuickcodeExpiredValidity();
	}

	@Test(priority = 2, groups = { "Smoke", "Regression" }, description = "Share file via static url")
	@TestData(testId = 11)
	public static void postRequestToShareFileViaStaticUrl() {
		ObjectStoreFileAPI.postRequestToShareFileViaStaticUrl();
	}

	@Test(priority = 3, groups = { "Smoke", "Regression" }, description = "Unshared file via static url")
	@TestData(testId = 11)
	public static void deleteRequestToShareFileViaStaticUrl() {
		ObjectStoreFileAPI.deleteRequestToUnShareFileViaStaticUrl();
	}

	@Test(priority = 3, groups = { "Smoke", "Regression" }, description = "Unshared file via static url when id not exist")
	@TestData(testId = 11)
	public static void deleteRequestToShareFileViaStaticUrlWhenIdNotExist() {
		ObjectStoreFileAPI.deleteRequestToShareFileViaStaticUrlWhenIdNotExist();
	}

	@Test(priority = 3, groups = { "Smoke", "Regression" }, description = "Unshared file via static url when id not given")
	@TestData(testId = 11)
	public static void deleteRequestToShareFileViaStaticUrlWhenIdNotGiven() {
		ObjectStoreFileAPI.deleteRequestToShareFileViaStaticUrlWhenIdNotGiven();
	}

	@Test(priority = 3, groups = { "Smoke", "Regression" }, description = "Unshared file via static url with invalid url")
	@TestData(testId = 11)
	public static void deleteRequestToShareFileViaStaticUrlWithInvalidUrl() {
		ObjectStoreFileAPI.deleteRequestToShareFileViaStaticUrlWithInvalidUrl();
	}

	@Test(priority = 3, groups = { "Smoke", "Regression" }, description = "Get file info shared via static url")
	@TestData(testId = 11)
	public static void getRequestToShareFileViaStaticUrl() {
		ObjectStoreFileAPI.getRequestToShareFileViaStaticUrl();
	}

	@Test(priority = 3, groups = { "Smoke", "Regression" }, description = "Get file info shared via static url expired validity")
	@TestData(testId = 11)
	public static void getRequestToShareFileViaStaticUrlExpiredValidity() {
		ObjectStoreFileAPI.getRequestToShareFileViaStaticUrlExpiredValidity();
	}
}
