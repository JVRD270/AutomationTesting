package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import framework.PageObjectBase;

public class DropdownPage extends PageObjectBase {
	
	public DropdownPage(WebDriver driver, String url) {
		super(driver, url);
	}
		
	@FindBy(id = "dropdown")
	WebElement dropdownList;
	
	public DropdownPage navigate() {
		super.navigate("/dropdown");
		return this;
	}
		
	public DropdownPage select(String selection) {
		new Select(dropdownList).selectByVisibleText(selection);
		return this;
	}
		
	public String getSelection() {
		return new Select(dropdownList)
				.getFirstSelectedOption()
				.getText();
	}
}
