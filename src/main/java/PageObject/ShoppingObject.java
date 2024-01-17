package PageObject;
import org.openqa.selenium.By;

public class ShoppingObject {
    protected By
            productButton = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(2) > a"),
            productView1 = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a"),

            addToCart=By.className("btn btn-default cart"),
            viewCart=By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u"),
            checkOut= By.className("btn btn-default check_out");

}

