package theInternet.pages;

import java.io.FileNotFoundException;
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
	
	public List<String> getAvailableFileNames(){
		for(WebElement link : downloadLinks) {
			fileNames.add(link.getText());
		}
		
		return fileNames;
	}
	
	public DownloadsPage downloadAllFiles() {
		for(WebElement link : downloadLinks) {
			link.click();
		}
		return this;
	}
	
	public List<String> getDownloaded() throws FileNotFoundException, InterruptedException{
		return new DownloadControlExtension(driver).findFiles(fileNames);
	}
	
	
	
	

}
