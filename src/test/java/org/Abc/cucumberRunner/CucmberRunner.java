package org.Abc.cucumberRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
        glue = {"org.Abc.stepDefiniation"},
        plugin = {"pretty",
                "html:target/cucumber.html",
                "json:target/Cucumber.json",
                "junit:target/Cucumber.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        dryRun = false,
        monochrome = true,
        tags = "@regression")
public class CucmberRunner {
}
