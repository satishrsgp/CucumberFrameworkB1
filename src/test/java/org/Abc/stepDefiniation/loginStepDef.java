package org.Abc.stepDefiniation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.Abc.PageInitializer.PageInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class loginStepDef extends PageInitializer {
    public static Logger logger = LogManager.getLogger(loginStepDef.class);


    @Given("As a user I want to launch to the application")
    public void as_a_user_i_want_to_login_to_the_application() {
        driver.get(hooks.getConfigValue("url"));
        logger.info("Open cart application launched successfully");
    }

    @When("I enter a valid username")
    public void i_enter_a_valid_username() {
        loginPage.seteMailAddress(hooks.getConfigValue("username"));
        logger.info("I am able to enter email address");
    }

    @When("I enter a valid password")
    public void i_enter_a_valid_password() {
        loginPage.setPassword(hooks.getConfigValue("password"));
        logger.info("I am able to enter Password");
    }

    @Then("I should login successfully")
    public void i_should_login_succesfully() {
        logger.info("We are verifying login is success or not");
        boolean Actualvalue = accountPage.isMyAccount();
        Assert.assertTrue(Actualvalue);
    }

    @And("I need to click on Login link")
    public void iNeedToClickOnLoginLink() {

        homePage.clickOnMyAccount();
        homePage.clickOnLogin();
        logger.info("I am able to click on login link");
    }

    @And("I need to click on login button")
    public void iNeedToClickOnLoginButton() {
        loginPage.clickOnLogin();
    }

    @When("I enter a invalid username")
    public void iEnterAInvalidUsername() {
        loginPage.seteMailAddress("satish122@mailinator.com");
        logger.info("I am able to enter email address");

    }

    @And("I enter a invalid password")
    public void iEnterAInvalidPassword() {
        loginPage.setPassword("Password@1");
        logger.info("I am able to enter Password");
    }

    @Then("I should not login successfully")
    public void iShouldNotLoginSuccessfully() {
        boolean status = accountPage.isMyAccount();
        Assert.assertTrue(!status);
    }

    @When("User enters email {string} and password {string}")
    public void user_enters_credentials(String email, String password) {
        loginPage.seteMailAddress(email);
        loginPage.setPassword(password);
    }


    @Then("The login {string} should be displayed")
    public void verify_result(String expectedResult) {
        switch (expectedResult) {
            case "success":
                Assert.assertTrue(accountPage.isMyAccount());
                break;
            case "login error":
                Assert.assertTrue(loginPage.getWarningMessage().contains("No match for E-Mail Address and/or Password."));
                break;
        }
    }

}
