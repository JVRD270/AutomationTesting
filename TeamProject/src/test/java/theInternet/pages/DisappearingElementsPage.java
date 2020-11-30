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
	
	public DisappearingElementsPage reloadAndCheckForElement(int numberOfReloads) {
		int currentNumberOfLi = liElements.size();
		for(int i=0;i<=numberOfReloads;i++) {
			navigate();
			if(currentNumberOfLi != liElements.size()) {
				elementDisappearsAtLeastOnce = true;
				break;
			}
			
		}
		return this;
	}

	public boolean disappearedAtLeastOnce() {
		return elementDisappearsAtLeastOnce;
	}
	
	

}
