package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.ExtraUtils.All_DP;
import com.vytrack.utilities.ExtraUtils.Sleep;
import org.openqa.selenium.By;
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
        dashboard.moduleFleet.click();
        Sleep.Zzz(3);
        dashboard.moduleFleetVehicle.click();
        //vehiclePage.checkboxAll.click();
        Assert.assertFalse(vehiclePage.checkboxAll.isSelected(),"Checkbox is selected");

        //AC2_Verify that User check the first checkbox to check all the cars
        vehiclePage.checkboxAll.click();
        Assert.assertTrue(vehiclePage.checkboxAll.isSelected(),"Checkbox is not selected");
        vehiclePage.checkboxAll.click();

        //AC3Verify that Users can select any car
        List<WebElement> randomCheckbox = Driver.getDriver().findElements(By.xpath("//input[@tabindex='-1']"));
        //Select $ UnSelect EachCheckBox
        for (WebElement eachCheckbox : randomCheckbox) {
            if (!eachCheckbox.isSelected()) {
                eachCheckbox.click();
            }
            for (WebElement eachUncheckBox : randomCheckbox) {
                if (eachUncheckBox.isSelected()) {
                    eachUncheckBox.click();
                }
            }
        }

    }

}
