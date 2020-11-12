package theInternet.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;

public class DisappearingElementsPage extends PageObjectBase{
	
	private boolean elementDisappearsAtLeastOnce;
	
	public DisappearingElementsPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	@FindBy(css=".example li")
	List<WebElement> liElements;
	
	public DisappearingElementsPage navigate() {
		super.navigate("/disappearing_elements");
		return this;
	}
	
	public DisappearingElementsPage reloadAndCheckForElement(int reloadThisManyTimes) {
		int currentNumberOfLi = liElements.size();
		for(int i=0;i<=reloadThisManyTimes;i++) {
			navigate();
			if(currentNumberOfLi != liElements.size()) {
				elementDisappearsAtLeastOnce = true;
			}
			
		}
		return this;
	}

	public boolean disappearedAtLeastOnce() {
		return elementDisappearsAtLeastOnce;
	}
	
	

}
