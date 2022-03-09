package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.ExtraUtils.All_DP;
import com.vytrack.utilities.ExtraUtils.HeaderMap;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.vytrack.utilities.ExtraUtils.LoginBy.loginBy;
import static com.vytrack.utilities.ExtraUtils.Sleep.Zzz;

public class US4_Tyler_substituted extends TestBase {


    @Test(dataProvider = "SM", dataProviderClass = All_DP.class)
    public void TC1_verifying_Accessibility_Vehicle_Contact_Page(String sManagers) {

        loginBy(sManagers);
        Zzz(2);
        HeaderMap.goToPage(2, "Vehicle Contracts");
        Zzz(2);

        String actualURL = Driver.getDriver().getCurrentUrl();
        String expectedURL = "https://qa1.vytrack.com/entity/Extend_Entity_VehicleContract";

        Assert.assertEquals(actualURL, expectedURL);

    }

    @Test(dataProvider = "SM", dataProviderClass = All_DP.class)
    public void TC2_verifying_Accessibility_Vehicle_Contact_Page(String sManagers) {

        loginBy(sManagers);

        Zzz(2);
        HeaderMap.goToPage(2, "Vehicle Contracts");
        Zzz(3);
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "All - Vehicle Contract - Entities - System - Car - Entities - System";

        Assert.assertEquals(actualTitle, expectedTitle);

    }

    @Test(dataProvider = "DriverLogin", dataProviderClass = All_DP.class)
    public void TC3_verifying_Accessibility_Vehicle_Contact_Page(String truckDriverUserName) {

        loginBy(truckDriverUserName);
        Zzz(2);
        HeaderMap.goToPage(1, "Vehicle Contracts");
        Zzz(2);

        String actualMessage = Driver.getDriver().findElement(By.cssSelector("div[class='message']")).getText();
        String expectedMessage = "You do not have permission to perform this action.";

        Assert.assertEquals(actualMessage, expectedMessage);

    }



}
