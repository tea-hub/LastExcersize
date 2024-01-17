package StepObject;

import PageObject.LoginObject;
import org.openqa.selenium.WebDriver;



public class LoginSteps extends LoginObject {
WebDriver driver;
public  LoginSteps(WebDriver driver1){
    driver= driver1;
}
public void emailFieldAction(String email){
    driver.findElement(emailField).sendKeys(email);
}
public void passwordFieldAction(String password){
    driver.findElement(passwordField).sendKeys(password);
}
public void loginButtonAction(){
    driver.findElement(logInButton).click();
}

}
