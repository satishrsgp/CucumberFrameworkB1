package org.Abc.utils;

import org.Abc.stepDefiniation.hooks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class driverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static Logger logger = LogManager.getLogger(driverFactory.class);


    // to get the diver object
    public static WebDriver getDriver(){
        logger.info("In this function we are getting webDriver");
        if(driver.get()==null){
            initDriver();
        }
        return driver.get();
    }

    // This method is to initiate the driver object
    private static void initDriver() {
        logger.info("In this function we are initiating webDriver");
        //System.setProperty("browser","chrome");
        String browser = System.getProperty("browser", "chrome");

            switch (browser.toLowerCase()) {
                case "chrome":
                    driver.set(new ChromeDriver());;
                    break;
                case "edge":
                    driver.set(new EdgeDriver());
                    break;
                case "firefox":
                    driver.set(new FirefoxDriver());
                    break;
                default:
                    System.out.println("Please select valid browser");
                    break;
            }

    }

    //This method is used to Quit the driver object
    public static void quitDriver(){
        logger.info("In this function we are quitting webDriver");
        if(driver.get()!=null){
            driver.get().quit();
            driver.remove();
        }
    }

}
