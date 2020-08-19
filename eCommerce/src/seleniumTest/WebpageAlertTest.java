package seleniumTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebpageAlertTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = SeleniumWebDriver.initiateChromeDriver();
		
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		
		driver.findElement(By.name("cusid")).sendKeys("123434");
		driver.findElement(By.name("submit")).click();
		
		Alert pageAlert = driver.switchTo().alert();
		String alertMsg = pageAlert.getText();
		System.out.println(alertMsg);
		pageAlert.accept();
	}

}
