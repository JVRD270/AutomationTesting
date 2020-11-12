package theInternet.foundation.drivers;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {

	public ChromeDriverManager() {
		super("chromedriver.exe", "webdriver.chrome.driver");
	}

	public ChromeDriver getDriver() {
		super.webDriver = new ChromeDriver();
		return (ChromeDriver) super.webDriver;
	}
}
