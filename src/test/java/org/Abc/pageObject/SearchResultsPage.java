package org.Abc.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultsPage extends basePage {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnProduct(String productName) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement productLink = driver.findElement(By.linkText(productName));
        Actions actions = new Actions(driver);
        actions.moveToElement(productLink).click().perform();


    }
}
