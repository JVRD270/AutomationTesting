package theInternet.foundation;

import java.io.File;
import java.io.FileNotFoundException;
import org.openqa.selenium.WebDriver;

public class DownloadControlExtension {
	protected WebDriver driver;
	protected String fileName;


	public DownloadControlExtension(WebDriver driver, String fileName) {
		this.driver = driver;
		this.fileName = fileName;
	}


	public String getDownloaded() throws FileNotFoundException, InterruptedException{
		return findFile(fileName);
	}


	public String findFile(String fileName) throws FileNotFoundException, InterruptedException{
		boolean wasFileFound = isFileDownloaded(getDownloadsDirectory(), fileName);
		long startTime = System.currentTimeMillis();
		while(!wasFileFound) {
			Thread.sleep(50);
			wasFileFound = isFileDownloaded(getDownloadsDirectory(), fileName);
			if (System.currentTimeMillis() - startTime > 2000) {
				throw new FileNotFoundException("File " + fileName + " not found");
			}
		}
		deleteFileFromDownloadDirectory(getDownloadsDirectory(), fileName);
		return fileName;
	}

	public String getDownloadsDirectory() {
		return "C:/Users/" + System.getProperty("user.name") + "/Downloads/";
	}


	public boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
		File dir = new File(downloadPath);
		File[] dir_contents = dir.listFiles();

		for (int i = 0; i < dir_contents.length;) {
			if (dir_contents[i].getName().equals(fileName.substring(0,fileName.indexOf(".")-1)));
			return flag=true;
		}

		return flag;
	}

	public void deleteFileFromDownloadDirectory(String downloadPath, String fileName) {
		File dir = new File(downloadPath);
		File[] dir_contents = dir.listFiles();

		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().contains(fileName.substring(0, fileName.indexOf(".")))) {
				dir_contents[i].delete();
			}
		}

	}
}
