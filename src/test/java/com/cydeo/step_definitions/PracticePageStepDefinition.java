package com.cydeo.step_definitions;

import com.cydeo.pages.PracticePage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.remote.Browser;

public class PracticePageStepDefinition {
    PracticePage practicePage;
    @Given("User is on the home page")
    public void user_is_on_the_home_page() {
        Driver.getDriver ().get (ConfigurationReader.getProperty ("url"));
    }
    @When("User clicks {string} link")
    public void user_clicks_link(String linkText) {
    practicePage=new PracticePage ();
    practicePage.clickLink (linkText);
        BrowserUtils.sleep (3);
    }
    @Then("User should be able to see {string} in url")
    public void user_should_be_able_to_see_in_url(String urlContains) {
        Driver.getDriver ().getCurrentUrl ().contains (urlContains);
    }
}
