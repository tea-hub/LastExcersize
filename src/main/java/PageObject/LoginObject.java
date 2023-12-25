package PageObject;

import org.openqa.selenium.By;

public class LoginObject {
  protected   By
    emailField=By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]"),
    passwordField=By.name("password"),
    logInButton=By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button");

}
