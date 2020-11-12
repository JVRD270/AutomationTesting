package framework.drivers;

public class DriverManagerFactory {
	
	public static DriverManager getManager(String driverType) {
			if (driverType == "Firefox") {
				return new FirefoxDriverManager();
			}
			if(driverType == "Chrome") {
				return new ChromeDriverManager();
			}
			return null;
	}
}
