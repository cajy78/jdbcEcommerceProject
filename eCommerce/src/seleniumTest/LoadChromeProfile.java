package seleniumTest;
import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoadChromeProfile {

    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        ChromeDriverService chSvc = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("C:\\Users\\cajy7\\Downloads\\chromedriver_win32\\chromedriver.exe")).usingAnyFreePort().build();
        ChromeOptions chOption = new ChromeOptions();
        /**
         * "user-data-dir = profilepath" --to open profile
         * "--start-maximized" for maximize the browser
         */
        chOption.addArguments("user-data-dir = \"C:\\Users\\cajy7\\AppData\\Local\\Google\\Chrome\\User Data\\Guest Profile\"");
        chOption.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(chSvc, chOption);
        driver.quit();
    }
}