package seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioAndCheckbox {

	private static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = SeleniumWebDriver.initiateChromeDriver();
		
		driver.get("http://demo.guru99.com/test/radio.html");
		driver.manage().window().maximize();
		try{Thread.sleep(2000);}catch(Exception e) {}
		WebElement radio1 = driver.findElement(By.id("vfb-7-1"));
		WebElement radio2 = driver.findElement(By.id("vfb-7-2"));
		
		radio1.click();
		System.out.println("Radio Button 1 is clicked");
		try{Thread.sleep(2000);}catch(Exception e) {}
		radio2.click();
		System.out.println("Radio button 2 is clicked");
		
		WebElement checkbox1 = driver.findElement(By.id("vfb-6-0"));
		checkbox1.click();
		checkbox1.click();
		if(checkbox1.isSelected())
			System.out.println("Checkbox 1 is selected");
		else
			System.out.println("Checkbox 1 is deselected");
	}

}
