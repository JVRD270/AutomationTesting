package theInternet.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;

import framework.PageObjectBase;

public class NestedFramesPage extends PageObjectBase {
	public NestedFramesPage(WebDriver driver, String url) {
		super(driver, url);
	}

	public NestedFramesPage navigate() {
		super.navigate("/nested_frames");
		return this;
	}

	public String selectFrame(String frameToSelect){
		List<String> topFrames = Arrays.asList("LEFT", "RIGHT", "MIDDLE");
		if(topFrames.contains(frameToSelect)) {
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[contains(@src, 'frame_top')]")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[contains(@src, " + "'frame_" + frameToSelect.toLowerCase() + "')]")));
			if(driver.getPageSource().contains(frameToSelect)) {
				return frameToSelect;
			};
		}
		if(frameToSelect == "BOTTOM") {
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[contains(@src, 'frame_bottom')]")));
			if(driver.getPageSource().contains(frameToSelect)) {
				return frameToSelect;
			};
		}
		throw new NotFoundException("There is no frame with such label");
	}
}
