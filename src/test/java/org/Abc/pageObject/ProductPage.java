package org.Abc.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends basePage{

    public ProductPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "button-cart")
    WebElement addToCartButton;

    public void addToCart() {
        Actions actions = new Actions(driver);
        actions.moveToElement(addToCartButton).click().perform();
    }
}
