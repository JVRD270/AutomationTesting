package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;
import theInternet.foundation.CheckboxControlExtension;

public class CheckboxPage extends PageObjectBase{
	public CheckboxPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	@FindBy(id = "checkboxes")
	WebElement checkboxForm;
	
	public CheckboxPage navigate() {
		super.navigate("/checkboxes");
		
		return this;
	}
	
	public CheckboxPage toggleCheckboxes(String[] boxesToToggle, boolean shouldBeChecked) {
		new CheckboxControlExtension(checkboxForm, driver).setByLabel(boxesToToggle, shouldBeChecked);
		
		return this;
	}
	
	public String[] getSelectedCheckboxes() {
		return new CheckboxControlExtension(checkboxForm, driver).getLabelsForChecked();
	}
}
