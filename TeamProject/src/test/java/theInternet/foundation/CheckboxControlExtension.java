package theInternet.foundation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxControlExtension extends ControlExtensionBase {

	public CheckboxControlExtension(WebElement mappedElement, WebDriver driver) {
		super(mappedElement, driver);
	}

	public void setByLabel(String[] checkboxesLabel, boolean shouldBeChecked) {

		for(String labelForBoxToCheck : checkboxesLabel) {
			List<WebElement> childElements = mappedElement.findElements(By.cssSelector("*"));

			for(WebElement elements : childElements) {
				String lookAfterElement = getFollowingSiblingTextContent(elements);

				if(lookAfterElement == null) {
					continue;
				}

				if(!lookAfterElement.equals(labelForBoxToCheck)) {
					continue;
				}

				boolean isCheckboxCurrentlyChecked = elements.getAttribute("checked") != null;

				if(shouldBeChecked != isCheckboxCurrentlyChecked) {
					elements.click();
				}
			}
		}
	}
	
	
	public String[] getLabelsForChecked() {
		List<String> checkedElementsTexts = new ArrayList<String>();
		
		List<WebElement> childElements = mappedElement.findElements(By.cssSelector("*"));
		
		for(WebElement elements : childElements) {
			boolean isCheckboxCurrentlyChecked = elements.getAttribute("checked") != null;
			
			if(!isCheckboxCurrentlyChecked) {
				continue;
			}
			
			String lookAfterElementText = getFollowingSiblingTextContent(elements);
			
			if(lookAfterElementText == null) {
				throw new RuntimeException("Could not get label for checked box");
			}
			
			checkedElementsTexts.add(lookAfterElementText);
		}
		
		return toArray(checkedElementsTexts);
	}

	private String getFollowingSiblingTextContent(WebElement elements) {

		String script = "var childNode = arguments[0].nextSibling;"
				+ "return childNode === undefined ? null : childNode.textContent;";

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String elementText = (String)js.executeScript(script, elements);

		if(elementText != null) {
			elementText = elementText.trim();
		}

		return elementText;
	}
	
	private String[] toArray(List<String> list) {
		String[] array = new String[list.size()];
		
		for (int i=0; i<list.size(); i++) {
			array[i] = list.get(i);
		}
		
		return array;
	}


}
