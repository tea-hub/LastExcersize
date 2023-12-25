package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class BrowserActions {
    public static WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void openBrowser()  {
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/login");

    }
    @AfterMethod
    public void closeBrowser() {
        driver.close();

    }
}
