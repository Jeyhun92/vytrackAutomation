package com.vytrack.tests;

import com.vytrack.pages.Dashboard;
import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.ExtraUtils.All_DP;
import com.vytrack.utilities.ExtraUtils.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.vytrack.utilities.ExtraUtils.LoginBy.loginBy;
import static com.vytrack.utilities.ExtraUtils.LoginBy.loginPg;

public class US11_Jeyhun extends TestBase {


    @Test(dataProvider = "StoreManagerLogin", dataProviderClass = All_DP.class)
    public void verify_manager_see_expected_text(String storeManagerLogin)  {

      loginPg(storeManagerLogin);
      Sleep.Zzz(3);
     dashboard.fleetBtn.click();

        Sleep.Zzz(3);
        dashboard.odometerModule.click();
        Sleep.Zzz(3);
        String expected_Result= "You do not have permission to perform this action.";
        String actual_Result = dashboard.message.getText();
        Assert.assertEquals(actual_Result,expected_Result);

    }
    @Test(dataProvider = "DriverLogin", dataProviderClass = All_DP.class)
    public void verify_defaultPageNumber_is1(String truckDriverUserName)  {
      loginPg(truckDriverUserName);
      Sleep.Zzz(3);
       dashboard.fleetBtnAsDriver.click();
       Sleep.Zzz(3);
       dashboard.odometerModule.click();

        Sleep.Zzz(3);
        Assert.assertEquals(dashboard.pageNumber.getAttribute("value"), "1");
    }

    @Test(dataProvider = "DriverLogin", dataProviderClass = All_DP.class)
    public void verify_default_view_perPage_is25(String truckDriverUserName) {

        loginPg(truckDriverUserName);
       Sleep.Zzz(3);
        dashboard.fleetBtnAsDriver.click();
        Sleep.Zzz(3);
        dashboard.odometerModule.click();


       Sleep.Zzz(3);
        System.out.println("defaultPageNum = " + dashboard.defaultPageNum.getText());
        Assert.assertEquals(dashboard.defaultPageNum.getText(), "25");


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

Test cases #2
Description:  Drivers should see the default page number as 1
Environment: https://qa2.vytrack.com/user/login
Steps:
Log in as drivers
Click the “Vehicle Odometers” under the Fleet
Verify the default page number is 1

Test cases #3
Description:   Divers should see the View Per Page is 25 by default.
Environment: https://qa2.vytrack.com/user/login
Steps:
Log in as drivers
Click the “Vehicle Odometers” under the Fleet
Verify the default view per page is 25.
 */
