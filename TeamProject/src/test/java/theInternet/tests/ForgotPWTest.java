package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.ForgotPWPage;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ForgotPWTest extends TheInternetTestBase {
  @Test
  public void canResetEmail() throws InterruptedException {
	  //This test uses a free disposable email service called endtest.io.
	  //We can use a sample email username@endtest-mail.io
	  //The inbox can be accessed at https://endtest.io/mailbox?email=username@endtest-mail.io
	  String sampleEmail = "brand_new_email@endtest-mail.io";
	  String expectedEmailTitle ="Forgot Password from the-internet";
	  String emailReceivedTitle = new ForgotPWPage(webDriver, baseUrl)
			  .navigate()
			  .submitEmail(sampleEmail)
			  .openInbox(sampleEmail)
			  .getLatestEmail()
			  .getTitle();
	  
	  Assert.assertEquals(emailReceivedTitle, expectedEmailTitle);
	  
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
