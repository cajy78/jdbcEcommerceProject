package seleniumTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.Keys;
import seleniumTest.SeleniumWebDriver;

public class AmazonSeleniumTest {

	private static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = SeleniumWebDriver.initiateChromeDriver();
		
		//Chrome launched with base URL
		String baseUrl = "https://www.amazon.in";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		
		try
		{
			driver.findElement(By.id("twotabsearchtextbox")).click();
			//Thread.sleep(1000);
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Apple iPhone");
			//Thread.sleep(1000);
			driver.findElement(By.className("nav-input")).click();
			Thread.sleep(5000);
			driver.findElement(By.partialLinkText("iPhone 7")).click();//(By.linkText("Get product by Product ID")).click();
			Thread.sleep(3000);
			driver.findElement(By.partialLinkText("iPhone XR")).click();
			Thread.sleep(4000);
			driver.findElement(By.partialLinkText("iPhone 11")).click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
