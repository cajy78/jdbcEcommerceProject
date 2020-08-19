package seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FrameSeleniumTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = SeleniumWebDriver.initiateChromeDriver();
		
		driver.get("http://demo.guru99.com/test/guru99home");
		driver.switchTo().frame("a077aa5e");
		Thread.sleep(2000);
		driver.findElement(By.id("")).click();
	}

}
