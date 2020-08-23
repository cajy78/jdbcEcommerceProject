package seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = SeleniumWebDriver.initiateChromeDriver();
		driver.get("http://localhost:8080/eCommerce/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.name("getAllProducts")).click();
	}

}
