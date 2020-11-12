package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.DownloadsPage;

import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class FileDownloadTest extends TheInternetTestBase{
  @Test
  public void canDownloadFiles() throws FileNotFoundException, InterruptedException {
	  DownloadsPage downloadPage = new DownloadsPage(webDriver, baseUrl).navigate();
	  List<String> expectedFilesToDownload = downloadPage
			  .getAvailableFileNames();
	  
	  List<String> downloadedFiles = downloadPage
			  .downloadAllFiles()
			  .getDownloaded();
	  
	  Assert.assertEquals(downloadedFiles, expectedFilesToDownload);
			  
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
