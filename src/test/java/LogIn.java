import DataObject.ShoppingData;
import StepObject.LoginSteps;
import StepObject.ShoppingSteps;
import Utils.BrowserActions;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static DataObject.LogInData.*;
import org.openqa.selenium.JavascriptExecutor;


public class LogIn extends BrowserActions {
    @Test @Description("სწორი მონაცემებით დალოგინება")
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
    @Test @Description("დალოგინება მცდარი ემეილითა და პაროლით")
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

    @Test @Description("დალოგინება ცარიელი ველებით")
    public void logInWithEmptyCredentials() {
        LoginSteps step1 = new LoginSteps(driver);

        step1.emailFieldAction("");
        step1.passwordFieldAction("");
        step1.loginButtonAction();

        WebElement errorText = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(errorText));

        String actualResult = errorText.getCssValue("color");
        String expectedResult = "rgba(255, 0, 0)";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualResult, expectedResult, "There's no error text actually");

        softAssert.assertAll();
    }

    @Test @Description("არასწორი პაროლით დალოგინება")
    public void loginWithIncorrectPassword() {
        LoginSteps step = new LoginSteps(driver);
        step.emailFieldAction(correctEmail);
        step.passwordFieldAction(incorrectPassword);
        step.loginButtonAction();

        WebElement errorText = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p"));

        // Verify that an error message is displayed for incorrect password
        SoftAssert softAssert2 = new SoftAssert();
        softAssert2.assertTrue(errorText.isDisplayed(), "Your email or password is incorrect!");
        softAssert2.assertAll();
    }
    @Test @Description("არასწორი ფორმატის იმეილით დალოგინების მცდელობა")
    public void loginWithInvalidEmailFormat() {
        LoginSteps step = new LoginSteps(driver);
        step.emailFieldAction(invalidFormatEmail);
        step.passwordFieldAction(correctPassword);
        step.loginButtonAction();

        WebElement loginText = driver.findElement(By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > h2"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(loginText));

        SoftAssert softAssert3 = new SoftAssert();
        softAssert3.assertTrue(loginText.isDisplayed(), "<h2>Login to your account</h2>");
        softAssert3.assertAll();
    }

    @Test @Description("დალოგინებისა და წარმატებულად სისტემიდან დალოგაუთების ტესტი")
    public void successfulLoginAndLogout() {
        LoginSteps step = new LoginSteps(driver);
        step.emailFieldAction(correctEmail);
        step.passwordFieldAction(correctPassword);
        step.loginButtonAction();

        WebElement logoutButton = driver.findElement(By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
        logoutButton.click();


        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button"));
        SoftAssert softAssert4 = new SoftAssert();
        softAssert4.assertTrue(loginButton.isDisplayed(), "Login");

        softAssert4.assertAll();
    }
    @Test @Description(" products ღილაკზე კლიკით გადავდივართ პროდუქტების ჩამონათვალზე, ვსქროლავთ დაბლა და ვაჭერთ view product-ს რომ შევძლოთ პროდუქტის დათვალიერება")
    public void testViewProducts() throws InterruptedException {
        ShoppingSteps steps=new ShoppingSteps(driver);
        steps.clickProductButton();

        steps.scrollDown();
        Thread.sleep(5000);

         steps.viewProduct();
          WebElement blueTop = driver.findElement(By.cssSelector("body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > h2"));
          SoftAssert softAssert4 = new SoftAssert();
           softAssert4.assertTrue(blueTop.isDisplayed(), "body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > h2");

       softAssert4.assertAll();

        }

    @Test @Description(" გადავდივართ ისევ პროდუქტებში ვირჩევთ პირველივე პროდუქტის დათვალიერებას და ვაჭერთ add to cart-ს რომ დავამატოთ ნივთი კალათაში")
    public void addProduct() throws InterruptedException {
        ShoppingSteps steps=new ShoppingSteps(driver);
        steps.clickProductButton();

        steps.scrollDown();
        Thread.sleep(5000);

        steps.viewProduct();
        steps.addToCart();
        SoftAssert softAssert = new SoftAssert();

        WebElement addedToCartMessage = driver.findElement(By.className("text-center"));
        softAssert.assertTrue(addedToCartMessage.isDisplayed(), "Your product has been added to cart.");

        softAssert.assertAll();

    }

    @Test @Description("პროდუქტებზე გადასვლის, ნახვისა და დამატების შემდეგ გადავდივარ კალათაში, ვაჭერ checkout-ს და ვამოწმებ რომ მოთხოვნილი ტექსტი ნამდვილად გამოდის")
    public void viewCart() throws InterruptedException {
        ShoppingSteps steps=new ShoppingSteps(driver);
        steps.clickProductButton();

        steps.scrollDown();
        Thread.sleep(5000);

        steps.viewProduct();
        steps.addToCart();
        steps.viewCart();
        steps.checkOut();

        WebElement infoMessage = driver.findElement(By.xpath("//p[@class='text-center']"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(infoMessage.isDisplayed(), "Register / Login account to proceed on checkout.");
        softAssert.assertAll();

    }
    @Test @Description("დალოგინების შემდეგ ექაუნთის წაშლის ტესტი")
    public  void logInAndDeleteAccount() {
        LoginSteps step1=new LoginSteps(driver);
        step1.emailFieldAction(correctEmail);
        step1.passwordFieldAction(correctPassword);
        step1.loginButtonAction();

        WebElement deleteAccount= driver.findElement(By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(5) > a"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(deleteAccount.isDisplayed(), "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(5) > a");
        deleteAccount.click();
        softAssert.assertAll();


    }


}
