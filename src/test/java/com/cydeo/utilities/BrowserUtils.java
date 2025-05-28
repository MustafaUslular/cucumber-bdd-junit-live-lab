package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {
       /*
    This method will accept integer (in seconds) and execute
    Thread.sleep method for given duration.
    Arg: int second
     */

    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep (second);
        } catch (InterruptedException e) {

        }
    }

    public static void switchWindowAndVerify(String expectedInUrl, String expectedInTitle) {

        Set<String> allWindowHandles = Driver.getDriver ().getWindowHandles ();

        for (String each : allWindowHandles) {
            Driver.getDriver ().switchTo ().window (each);
            System.out.println ("Current URL: " + Driver.getDriver ().getCurrentUrl ());


            if (Driver.getDriver ().getCurrentUrl ().contains (expectedInUrl)) {
                break;
            }
        }

        String actualTitle = Driver.getDriver ().getTitle ();

        Assert.assertTrue (actualTitle.contains (expectedInTitle));

    }

    public static void verifyTitle(String expectedTitle) {
        Assert.assertEquals (Driver.getDriver ().getTitle (), expectedTitle);
    }

    public static void verifyTitleContains(String expectedInTitle) {
        Assert.assertTrue (Driver.getDriver ().getTitle ().contains (expectedInTitle));

    }

    public static void waitForInvisibilityOf(WebElement target) {
        // Create the object of "WebDriverWait" class, and set up the constructor args.
        WebDriverWait wait = new WebDriverWait (Driver.getDriver (), Duration.ofSeconds (10));

        // Use the "wait" object with the proper syntax to create explicit wait conditions.
        wait.until (ExpectedConditions.invisibilityOf (target));
    }

    public static void waitForTitleContains(String title) {
        // Create object of "WebDriverWait" class, ans set up the constructor args
        WebDriverWait wait = new WebDriverWait (Driver.getDriver (), Duration.ofSeconds (10));

        // use the "wait" object with the proper syntax to create explicit wait conditions.
        wait.until (ExpectedConditions.titleContains (title));
    }

    public static List<String> dropDownOptionsAsString(WebElement dropDownElement){

        Select month = new Select (dropDownElement);

        // Storing all the ACTUAL options in a List of WebElements
        List<WebElement> actualMonthAsWebElement = month.getOptions ();

        //Creating empty list of String to store ACTUAL <option> as String
        List<String> actualMonthAsString = new ArrayList<> ();

        //Looping through the List<WebElement>, getting all options' texts, and storing them into List<String>
        for (WebElement each : actualMonthAsWebElement) {

            actualMonthAsString.add (each.getText ());
        }
        return actualMonthAsString;
    }

}
