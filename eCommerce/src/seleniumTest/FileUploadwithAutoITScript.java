package seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadwithAutoITScript {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = SeleniumWebDriver.initiateChromeDriver();
		driver.get("http://localhost:8080/eCommerce/TestUpload.html");
		
		try
		{
			driver.findElement(By.xpath("//input[@type='file']")).click(); //sendKeys("C:\\Users\\cajy7\\OneDrive\\Desktop\\Newfolder\\Selenium.png");
			Thread.sleep(5000);
			Runtime.getRuntime().exec("C:\\Users\\cajy7\\git\\eCommerce\\eCommerce\\src\\seleniumTest\\AutoITUpload.exe");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
