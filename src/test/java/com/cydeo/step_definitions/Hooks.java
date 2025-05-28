package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/*
We will be able to create "pre" and "post" conditions for all
the scenarios and even steps.
 */
public class Hooks {

    @Before
    public void setUpMethod(){
        System.out.println ("---> Before: RUNNING BEFORE EACH SCENARIO");
    }
    @After
    public void tearDownMethod(Scenario scenario){

        if (scenario.isFailed ()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver ()).getScreenshotAs (OutputType.BYTES);
            scenario.attach (screenshot, "image/png", scenario.getName ());
        }
        System.out.println ("--->@After: RUNNING AFTER EACH SCENARIO");
        Driver.closeDriver ();
    }
//  @BeforeStep
    public void setUpStep(){
        System.out.println ("---> @BeforeStep: RUNNING BEFORE EACH STEP");
    }
//  @AfterStep
    public void tearDownStep(){
        System.out.println ("---> @AfterStep: RUNNING AFTER EACH STEP");
    }

}
