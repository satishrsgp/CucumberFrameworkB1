package org.Abc.pageObject;

import org.Abc.PageInitializer.PageInitializer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class cartPage extends basePage {

    public cartPage(WebDriver driver) {
        super(driver);
    }

    //locators
    @FindBy(xpath = "//*[@id='cart']/div/button")
    private WebElement cartTotalButton;

    @FindBy(linkText = "View Cart")
    private WebElement viewCartLink;

    // Cart item rows
    @FindBy(css = ".table-responsive tbody tr")
    List<WebElement> cartRows;


    public void openCart() {
        cartTotalButton.click();
        viewCartLink.click();
    }

    public void removeProduct(String productName) {
        for (WebElement row : cartRows) {
            WebElement nameElement = row.findElement(By.cssSelector("td.text-start a"));
            String name = nameElement.getText().trim();
            if (name.equalsIgnoreCase(productName)) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                WebElement removeBtn = row.findElement(By.cssSelector("div.input-group>a"));
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                wait.until(ExpectedConditions.elementToBeClickable(removeBtn)).click();
                break;
            }
        }
    }

    public List<String> getCartItems() {
        openCart();
        return cartRows.stream()
                .map(row -> row.findElement(By.cssSelector("td.text-start a")).getText())
                .collect(Collectors.toList());
    }
}
