package seleniumTest;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PopupWindowTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = SeleniumWebDriver.initiateChromeDriver();
		
		driver.get("http://demo.guru99.com/popup.php");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
		
		String mainWindow = driver.getWindowHandle();
		
		Set<String> subWindows = driver.getWindowHandles();
		Iterator<String> i = subWindows.iterator();
		
		while(i.hasNext())
		{
			String childWindow = i.next();
			if(!mainWindow.equals(childWindow))
			{
				driver.switchTo().window(childWindow);
				//driver.findElement(By.id("")).click();
				Thread.sleep(2000);
				driver.findElement(By.name("emailid")).sendKeys("Test@test.com");
				Thread.sleep(3000);
				driver.findElement(By.name("btnLogin")).click();
				Thread.sleep(3000);
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		driver.close();
	}

}
