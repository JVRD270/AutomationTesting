import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObjectBase {
	protected WebDriver driver;
	protected String baseUrl;
	
	public PageObjectBase(WebDriver driver, String url) {
		this.driver = driver;
		this.baseUrl = url;
		PageFactory.initElements(driver, this);
	}
	
	
	protected void navigate(String extension) {
		driver.navigate().to(baseUrl + extension);
	}
}
