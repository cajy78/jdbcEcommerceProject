package seleniumTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWebDriver {

	private static WebDriver driver;
	
	public static WebDriver initiateChromeDriver()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\cajy7\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
}
