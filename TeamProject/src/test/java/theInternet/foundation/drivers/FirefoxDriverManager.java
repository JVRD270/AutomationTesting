package theInternet.foundation.drivers;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager {
	
	public FirefoxDriverManager() {
		super("geckodriver.exe", "webdriver.gecko.driver");
	}

	public FirefoxDriver getDriver() {
		super.webDriver = new FirefoxDriver();
		return (FirefoxDriver) super.webDriver;
	}

}
