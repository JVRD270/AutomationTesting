package theInternet.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import framework.PageObjectBase;
import theInternet.foundation.DownloadControlExtension;

public class DownloadsPage extends PageObjectBase{
	public DownloadsPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	List<String> fileNames = new ArrayList<String>();


	@FindBy(css=".example a")
	List<WebElement> downloadLinks;

	public DownloadsPage navigate() {
		super.navigate("/download");
		return this;
	}

	public DownloadControlExtension downloadFileByIndex(int indexOfFile) {
		WebElement linkToClick = downloadLinks.get(indexOfFile);
		linkToClick.click();
		return new DownloadControlExtension(driver, linkToClick.getText());
	}

	
	public String getFileNameByIndex(int indexOfFile) {
		return downloadLinks.get(indexOfFile).getText();
	}
	





}
