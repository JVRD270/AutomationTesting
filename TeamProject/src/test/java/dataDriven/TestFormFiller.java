package dataDriven;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestFormFiller {
	WebDriver driver;
	UserData user;
	WebElement userForm;
	WebElement submitButton;

	public TestFormFiller(WebDriver driver, UserData user) {
		this.driver = driver;
		this.user = user;
		userForm = driver.findElement(By.id("userForm"));
		submitButton = driver.findElement(By.id("submit"));
	}


	public void submitAllData() {
		driver.manage().window().maximize();
		fillName();
		selectGender();
		fillMobile();
		setBirthDate();
		setSubjects();
		selectHobbies();
		fillAddress();


		submitButton.submit();

	}


	public void fillName() {
		userForm.findElement(By.id("firstName")).sendKeys(user.firstName);
		userForm.findElement(By.id("lastName")).sendKeys(user.lastName);
		userForm.findElement(By.id("userEmail")).sendKeys(user.email);
	}

	public void selectGender() {
		List<WebElement> genderRadios = userForm.findElements(By.className("custom-radio"));
		By labelLocator = By.xpath("//label[text()[contains(.," + "'" + user.gender + "')]]");
		for(WebElement genderRadio : genderRadios) {
			if(genderRadio.findElement(labelLocator) != null) {
				genderRadio.findElement(labelLocator).click();
			}
		}
	}

	public void fillMobile() {
		userForm.findElement(By.id("userNumber")).sendKeys(user.mobile);
	}

	public void setBirthDate() {
		By dateOfBirthLocator = By.id("dateOfBirthInput");
		userForm.findElement(dateOfBirthLocator).sendKeys(Keys.chord(Keys.CONTROL, "A"));
		userForm.findElement(dateOfBirthLocator).sendKeys(user.DOB);
		userForm.findElement(dateOfBirthLocator).sendKeys(Keys.ESCAPE);
	}

	public void setSubjects() {
		By subjectInputLocator = By.id("subjectsInput");
		
		for(String subject : user.subjects) {
			userForm.findElement(subjectInputLocator).sendKeys(subject);
			userForm.findElement(subjectInputLocator).sendKeys(Keys.TAB);
		}
	}

	public void selectHobbies() {
		List<WebElement> hobbiesCheckboxes = userForm.findElements(By.className("custom-checkbox"));
		try {
			for(WebElement checkbox : hobbiesCheckboxes) {
				if(checkbox.findElement(By.xpath("//label[text()[contains(.," + "'" + user.hobby + "')]]")) != null) {
					checkbox.findElement(By.xpath("//label[text()[contains(.," + "'" + user.hobby + "')]]")).click();
				}
			}
		}
		catch(NoSuchElementException e) {
			
		}
	}

	public void fillAddress() {
		userForm.findElement(By.id("currentAddress")).sendKeys(user.houseNumber + ", " + user.street + " " + user.postalCode);
	}

	public void selectState() {
		ReactDropdownControlExtension stateMenu = new ReactDropdownControlExtension(
				userForm.findElement(By.className("css-yk16xz-control")));

		stateMenu.selectByText(user.state);
	}
}
