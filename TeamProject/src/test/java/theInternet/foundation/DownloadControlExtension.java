package theInternet.foundation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

public class DownloadControlExtension {
	WebDriver driver;

	
	public DownloadControlExtension(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public List<String> findFiles(List<String> fileNames) throws FileNotFoundException, InterruptedException{
		List<String> foundFiles = new ArrayList<String>();
		for(String file : fileNames) {
			long startTime = System.currentTimeMillis();
			while(!isFileDownloaded(getDownloadsDirectory(), file)) {
				Thread.sleep(50);
				if (System.currentTimeMillis() - startTime > 3000) {
					break;
				}
			}
			if (isFileDownloaded(getDownloadsDirectory(), file)) {
				foundFiles.add(file);
				deleteFileFromDownloadDirectory(getDownloadsDirectory(), file);
			}
			else {
				throw new FileNotFoundException("File " + file + " not found");
			}
		}
		
		return foundFiles;
	}
	
	public String getDownloadsDirectory() {
		return "C:/Users/" + System.getProperty("user.name") + "/Downloads/";
	}
	
	
	public boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
	    File dir = new File(downloadPath);
	    File[] dir_contents = dir.listFiles();
	  	    
	    for (int i = 0; i < dir_contents.length; i++) {
	        if (dir_contents[i].getName().contains(fileName.substring(0, fileName.indexOf("."))))
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
