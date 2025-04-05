package org.Abc.PageInitializer;

import org.Abc.pageObject.*;
import org.Abc.stepDefiniation.hooks;
import org.Abc.utils.driverFactory;
import org.openqa.selenium.WebDriver;

public class PageInitializer {
    protected WebDriver driver;

    protected hooks hooks;
    protected org.Abc.pageObject.homePage homePage;
    protected SearchResultsPage searchResultsPage;
    protected ProductPage productPage;
    protected org.Abc.pageObject.accountPage accountPage;
    protected org.Abc.pageObject.loginPage loginPage;
    protected registerPage registerPage;
    protected cartPage cartPage;

    public PageInitializer() {
        this.driver =driverFactory.getDriver();

        // Init once, not in every step def
        hooks = new hooks();
        homePage = new homePage(driver);
        productPage = new ProductPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        accountPage = new accountPage(driver);
        loginPage = new loginPage(driver);
        registerPage = new registerPage(driver);
        cartPage = new cartPage(driver);
    }
}
