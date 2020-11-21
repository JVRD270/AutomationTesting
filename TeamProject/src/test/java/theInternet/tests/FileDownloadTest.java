package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.DownloadsPage;

import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class FileDownloadTest extends TheInternetTestBase{
  @Test
  public void canDownloadFiles() throws FileNotFoundException, InterruptedException {
	  DownloadsPage myDownloadPage = new DownloadsPage(webDriver, baseUrl);
	  
	  int indexOfFileToDownload = 0;
	  String expectedDownloadedFile = myDownloadPage.navigate().getFileNameByIndex(indexOfFileToDownload);
	  
	  String downloadedFile = myDownloadPage.navigate()
			  .downloadFileByIndex(indexOfFileToDownload)
			  .getDownloaded();
	  
	  Assert.assertEquals(downloadedFile, expectedDownloadedFile);
			  
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
