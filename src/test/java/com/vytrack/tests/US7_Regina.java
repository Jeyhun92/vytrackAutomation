package com.vytrack.tests;

import com.vytrack.pages.VehiclePage;
import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.ExtraUtils.All_DP;
import com.vytrack.utilities.ExtraUtils.HigthLigth;
import com.vytrack.utilities.ExtraUtils.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.vytrack.utilities.ExtraUtils.LoginBy.loginBy;

public class US7_Regina extends TestBase{

    //As a user, I should be to select any vehicle from the Vehicle page(web-table)
    //AC #1: once the user launched to the Vehicle page, all the checkboxes should be unchecked
    //AC #2: user check the first checkbox to check all the cars
    //AC #3: users can select any car

    @Test(dataProvider = "LoginAll", dataProviderClass = All_DP.class)
    public void TC1_verify_that_driver_select_any_car(String user) {

        //Verify that User launched to the Vehicle page, all the checkboxes should be unchecked
        loginBy(user);
        Sleep.Zzz(3);
        HigthLigth.highlight(dashboard.moduleFleet,"blue");
        dashboard.moduleFleet.click();
        HigthLigth.highlight(dashboard.moduleFleetVehicle,"purple");
        dashboard.moduleFleetVehicle.click();
        Assert.assertFalse(vehiclePage.checkboxAll.isSelected(),"All Checkbox is not empty");

        //AC2_Verify that User check the first checkbox to check all the cars
        vehiclePage.checkboxAll.click();
        Assert.assertTrue(vehiclePage.checkboxAll.isSelected(),"Checkbox is not selected");
        vehiclePage.checkboxAll.click();

        //AC3Verify that Users can select any car
        //Select $ UnSelect EachCheckBox
        for (WebElement eachCheckbox : vehiclePage.randomCheckBox) {
            if (!eachCheckbox.isSelected()) {
                eachCheckbox.click();
                Assert.assertTrue(eachCheckbox.isSelected());
            }
            for (WebElement eachUncheckBox : vehiclePage.randomCheckBox) {
                if (eachUncheckBox.isSelected()) {
                    eachUncheckBox.click();
                }
            }
        }

    }

}
