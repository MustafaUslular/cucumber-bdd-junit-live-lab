package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith (Cucumber.class) // This enforcing this class to be run or used as the cucumber runner class
@CucumberOptions(
        plugin ="html:target/cucumber-reports.html", // where the test reports will be stored.

        features = "src/test/resources/features",
        glue = "com/cydeo/step_definitions",
        dryRun = false,
        tags = "@wip",
        publish = true
)
public class cukesRunner {}

