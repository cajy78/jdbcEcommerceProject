package seleniumTest;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikUlitest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = SeleniumWebDriver.initiateChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		try
		{
			Screen uiScreen = new Screen();
			Pattern img1 = new Pattern("C:\\Users\\cajy7\\OneDrive\\Desktop\\SikULITest\\gmail.png");
			uiScreen.wait(img1, 5);
			uiScreen.click(img1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
