package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;

public class UploadFilesPage extends PageObjectBase {
	public UploadFilesPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	public UploadFilesPage navigate() {
		super.navigate("/upload");
		return this;
	}
	
	@FindBy(id="file-upload")
	WebElement fileInput;
	
	@FindBy(id="file-submit")
	WebElement submitFileButton;
	
	public UploadFilesPage inputFile(String filePath) {
		fileInput.sendKeys(filePath);
		return this;
	}
	
	public UploadFilesPage submitFile() {
		submitFileButton.click();
		return this;
	}
	
	public String getUploadedFileAsString() {
		return driver.findElement(By.id("uploaded-files")).getText();
	}
}
