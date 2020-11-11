package theInternet.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;

public class KeyPressPage extends PageObjectBase {

	private String detectedKeysIntoString;

	public KeyPressPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	@FindBy(css="input#target")
	WebElement inputField;

	@FindBy(id="result")
	WebElement detectedKeyText;

	public KeyPressPage navigate() {
		super.navigate("/key_presses");
		return this;
	}

	public KeyPressPage pressAndRecordKeysIntoString(String textInput) {
		String[] textInputKeys = textInput.split("");
		List<String> detectedKeys = new ArrayList<String>();
		for(String key : textInputKeys) {
			inputField.sendKeys(key);
			String resultText = detectedKeyText.getText();
			String detectedKey = resultText.split("")[resultText.length()-1];
			detectedKeys.add(detectedKey);
		}
		
		detectedKeysIntoString = String.join("", detectedKeys);
		return this;
	}
	
	public String getRecordedKeys() {
		return detectedKeysIntoString;
	}





}
