package StepObject;

import PageObject.ShoppingObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ShoppingSteps extends ShoppingObject {
    WebDriver driver;
    public  ShoppingSteps(WebDriver driver1){
        driver= driver1;
    }
   public void clickProductButton(){
        driver.findElement(productButton).click();
   }
   public void viewProduct(){
        driver.findElement(productView1).click();
   }

    public void scrollDown() {
        // Use JavascriptExecutor to scroll down
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 200)");
    }
public void addToCart(){
        driver.findElement(addToCart).click();
}
public void viewCart(){
        driver.findElement(viewCart).click();
}
public void checkOut(){
        driver.findElement(checkOut).click();
}
}
