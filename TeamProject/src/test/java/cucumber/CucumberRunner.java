package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber/features", glue={"cucumber.stepDefinitions"})
public class CucumberRunner extends AbstractTestNGCucumberTests{
}

