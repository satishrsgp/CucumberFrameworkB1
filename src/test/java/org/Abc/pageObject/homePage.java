package org.Abc.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class homePage extends basePage {

    //constructor
    public homePage(WebDriver driver) {
        super(driver);
    }

    //locators

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    private WebElement myAccountLinkEle;
    @FindBy(xpath = "//a[normalize-space()='Register']")
    private WebElement registerLinkEle;

    @FindBy(xpath = "//a[normalize-space()='Login']")
    private WebElement loginele;

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement searchInput;

    @FindBy(xpath = "//i[@class='fa-solid fa-magnifying-glass']")
    private WebElement searchButton;

    @FindBy(xpath = "//button[@aria-label='Add to Cart']")
    private WebElement addToCartButton;

    //actions
    public void clickOnMyAccount() {
        myAccountLinkEle.click();
    }

    public void clickOnRegister() {
        registerLinkEle.click();
    }

    public void clickOnLogin() {
        loginele.click();
    }

    public void searchProduct(String productName) {
        searchInput.clear();
        searchInput.sendKeys(productName);
        searchButton.click();
    }
}
