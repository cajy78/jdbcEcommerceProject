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

public class GmailLogin {

	private static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			driver = SeleniumWebDriver.initiateChromeDriver();
			
			driver.get("https://www.gmail.com");
			driver.manage().window().maximize();
			
			driver.findElement(By.id("identifierId")).click();
			Thread.sleep(500);
			driver.findElement(By.id("identifierId")).sendKeys("cajy78");
			Thread.sleep(500);
			driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/div[2]")).click();
		}
		catch(Exception e)
		{}
	}

}
