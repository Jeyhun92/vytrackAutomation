package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US11_Jeyhun extends TestBase {



    @Test
    public void verify_manager_see_expected_text() throws InterruptedException {
        VytrackUtils.loginAsStoreManger();

     WebElement fleetBtn = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
     fleetBtn.click();

     Thread.sleep(2000);

        WebElement odometerBtn = Driver.getDriver().findElement(By.linkText("Vehicle Odometer"));
        odometerBtn.click();
        WebElement message=Driver.getDriver().findElement(By.xpath("(//div[@class='message'])[2]"));
        String expected_Result= "You do not have permission to perform this action.";

        String actual_Result= message.getText();

        Assert.assertEquals(actual_Result,expected_Result);

    }

}

/*
Story11:  As a user, I want to view car odometer info on the Vehicles Odometers page.

AC1: Store and Sales managers should see an error message “You do not have permission to perform this action.”
when they click the “Vehicle Odometer” module.

Test cases #1
Description:  manager can NOT access the Vehicle Odometer
Environment: https://qa2.vytrack.com/user/login
Steps:
Log in as store or sales managers
Click the “Vehicle Odometers” under the Fleet
Verify the managers see “You do not have permission to perform this action.”
 */
