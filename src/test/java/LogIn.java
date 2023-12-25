import StepObject.LoginSteps;
import Utils.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static DataObject.LogInData.*;

public class LogIn extends BrowserActions {
    @Test
    public  void logInWithCorrectData() {
        LoginSteps step1=new LoginSteps(driver);
        step1.emailFieldAction(correctEmail);
        step1.passwordFieldAction(correctPassword);
        step1.loginButtonAction();

          WebElement logoutButton= driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));

         String
          actualResult=logoutButton.getText(),
          expectedResult="Logout";

          SoftAssert softAssert=new SoftAssert();
          softAssert.assertEquals(actualResult,expectedResult);
         softAssert.assertAll();//daemtxveva text da ikneba passed

    }
    @Test
    public  void logInWithIncorrectData()  {
        LoginSteps step1=new LoginSteps(driver);
        step1.emailFieldAction(incorrectEmail);
        step1.passwordFieldAction(incorrectPassword);
        step1.loginButtonAction();

        WebElement errorText= driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(errorText));

        String
           actualResult=errorText.getCssValue("color"),
           expectedResult="rgba(255, 0, 0)";
         SoftAssert softAssert1=new SoftAssert();
         softAssert1.assertEquals(actualResult,expectedResult);
         softAssert1.assertAll();//dafaildeba radgan expectedshi aklia bolos 1iani
    }
}
