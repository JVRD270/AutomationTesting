package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;
import theInternet.foundation.tablesControl.TableControlExtension;

public class TablesPage extends PageObjectBase{

	public TablesPage(WebDriver driver, String baseUrl) {
		super(driver,baseUrl);
	}
	
	@FindBy(id="table1")
	WebElement table1Element;
	
	public TablesPage navigate() {
		super.navigate("/tables");
		
		return this;
	}
	
	public String getAmountDueForUserTableRow(String userEmailAddres) {
		String text = new TableControlExtension(table1Element,driver)
				.getRow(1)
				.getCell("Due")
				.getText();
		
		return text;
	}
	
}
