package dataDriven;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormPage {
	WebDriver driver;
	
	public FormPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public FormPage navigate() {
		driver.navigate().to("https://demoqa.com/automation-practice-form");
		return this;
	}
	
	public FormPage submitData(UserData user) {
		new TestFormFiller(driver, user).submitAllData();
		return this;
	}
	
	public List<String> getRegisteredInfo() {
		WebElement registeredUserModalTable = driver.findElement(By.className("modal-body"));
		new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(registeredUserModalTable));
		List<WebElement> cells = registeredUserModalTable.findElements(By.tagName("td"));
		List<String> cellsText = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		for(WebElement cell : cells) {
			cellsText.add(cell.getText());
		}
		
		for(int i = 0; i<cellsText.size(); i++) {
			if(i%2 != 0) {
				values.add(cellsText.get(i));
			}
		}
		
		return values;
	}
}
