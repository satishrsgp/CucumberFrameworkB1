package org.Abc.cucumberRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = {"src/test/resources/features"},
        glue = {"org.Abc.stepDefiniation"},
        plugin = {"pretty",
                "html:target/cucumber.html",
                "json:target/Cucumber.json",
                "junit:target/Cucumber.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:target/parallel-threads",
                "rerun:target/failedrerun.txt"},
        dryRun = false,
        monochrome = true,
        tags = "@regression")
public class cucumberTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
