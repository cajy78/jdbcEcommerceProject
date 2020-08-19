package seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class TableRowColumnSelTest {

	private static WebDriver driver;
	
	public static void main(String[] args)
	{
		driver = SeleniumWebDriver.initiateChromeDriver();
		driver.get("http://demo.guru99.com/test/web-table-element.php");
		
		List<WebElement> headerCols = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
		System.out.println("Number of columns is: "+headerCols.size());
		for(WebElement item : headerCols)
		{
			System.out.println(item.getText());
		}
		
		WebElement table = driver.findElement(By.tagName("table"));
		
		List<WebElement> rowData = table.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr/td[1]"));
		System.out.println(rowData.size());
		
		for(WebElement item : rowData)
		{
			System.out.println(item.getText());
		}
	}
}
