package seleniumTest;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class TakeScreenshotTest {

	public static void main(String[] args)
		throws IOException, InterruptedException
	{
		// TODO Auto-generated method stub
		WebDriver driver = SeleniumWebDriver.initiateChromeDriver();
		driver.get("https://www.google.com");
		TakeScreenshotTest.takeSS(driver,"C:\\Users\\cajy7\\OneDrive\\Desktop\\Newfolder\\Selenium.jpg");
		Thread.sleep(3000);
		driver.close();
	}
	
	protected static void takeSS(WebDriver driver, String path)
		throws IOException
	{
		TakesScreenshot scrnSht = ((TakesScreenshot)driver);
		
		File scrFile = scrnSht.getScreenshotAs(OutputType.FILE);
		File destFile = new File(path);
		FileUtils.copyFile(scrFile, destFile);
	}
}
