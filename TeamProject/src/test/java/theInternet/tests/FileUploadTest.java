package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.UploadFilesPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class FileUploadTest extends TheInternetTestBase {
  @Test
  public void canUploadFiles() {
	  String expectedUploadedFile = "C:\\Users\\jvict\\Desktop\\Personal\\footpedia\\img\\download.png";
	  String fileName = expectedUploadedFile.substring(expectedUploadedFile.lastIndexOf("\\")+1);
	  String uploadedFile = new UploadFilesPage(webDriver, baseUrl)
			  .navigate()
			  .inputFile(expectedUploadedFile)
			  .submitFile()
			  .getUploadedFileAsString();
	  
	  Assert.assertEquals(uploadedFile, fileName);
  }
  @BeforeTest
  public void beforeTest() {
	  super.beforeTest();
  }

  @AfterTest
  public void afterTest() {
	  super.afterTest();
  }

}
