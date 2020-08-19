package seleniumTest;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//comment the above line and uncomment below line to use Chrome
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
import java.util.Map;
import java.util.HashMap;

public class RunGetDataTest {
	private static WebDriver driver;
	private static Map<String, Object> vars;

    public static void main(String[] args) {
        // declaration and instantiation of objects/variables
    //	System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
	//	WebDriver driver = new FirefoxDriver();
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
    	driver = SeleniumWebDriver.initiateChromeDriver();
    	
        String baseUrl = "http://localhost:8080/eCommerce/";
       
        
        vars = new HashMap<String, Object>();
        // launch  and direct it to the Base URL
        driver.get(baseUrl);

        driver.manage().window().maximize();
        //vars.put("window_handles", driver.getWindowHandles());
        //driver.findElement(By.linkText("Get product by Product ID")).click();
        //vars.put("win2548", waitForWindow(2000));
        try {
        //Thread.sleep(1000);
        	//driver.switchTo().window(vars.get("win2548").toString());
            driver.findElement(By.id("ProductIdentification")).click();
            driver.findElement(By.id("ProductIdentification")).sendKeys("123");
            driver.findElement(By.id("getProductbyID")).click();
        }
        catch (Exception e1) { e1.printStackTrace();}
        //driver.findElement(By.name("productName")).click();
        //driver.findElement(By.name("regn_num")).sendKeys("Milk");
        //driver.findElement(By.name("model")).click();
       // driver.findElement(By.name("model")).sendKeys("Corvette");
        //driver.findElement(By.name("color")).click();
        //driver.findElement(By.name("color")).sendKeys("Red");
        //driver.findElement(By.name("mileage")).click();
        //driver.findElement(By.name("mileage")).sendKeys("4444");
        //driver.findElement(By.name("getProductbyName")).click();
        //driver.findElement(By.cssSelector("input:nth-child(15)")).click();
        //assertThat(driver.findElement(By.cssSelector("body")).getText(), is("Successfully Inserted"));
                //close Chrome
        //driver.close();
    }
}