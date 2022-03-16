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

    @Test(dataProvider = "DriverLogin", dataProviderClass = All_DP.class)
    public void TC1_verify_that_driver_select_any_car(String truckDriverUserName) {

        //Verify that User launched to the Vehicle page, all the checkboxes should be unchecked
        loginBy(truckDriverUserName);
        Sleep.Zzz(3);



        //Driver.getDriver().findElement(By.xpath("//div[@id='main-menu']//span[contains(text(),'Fleet')][1]")).click();
        Sleep.Zzz(3);
        Driver.getDriver().findElement(By.xpath("//li[@class='dropdown-menu-single-item first']//span[contains(text(),'Vehicles')]")).click();
        WebElement checkbox = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-default btn-small dropdown-toggle']/input[@type='checkbox']"));
        Assert.assertFalse(checkbox.isSelected(),"Checkbox is selected");

        //AC2_Verify that User check the first checkbox to check all the cars
        checkbox.click();
        Assert.assertTrue(checkbox.isSelected(),"Checkbox is not selected");
        //checkbox.click();

        //AC3Verify that Users can select any car
        List<WebElement> randomCheckbox = Driver.getDriver().findElements(By.xpath("//input[@tabindex='-1']"));
        //Select $ UnSelect EachCheckBox
        for (WebElement eachCheckbox : randomCheckbox) {
            if (!eachCheckbox.isSelected()){
                eachCheckbox.click();
            }
            for (WebElement eachUncheckBox : randomCheckbox) {
                if (eachUncheckBox.isSelected()){
                    eachUncheckBox.click();
                }
            }
        }

    }
    @Test(dataProvider = "SalesManagerLogin", dataProviderClass = All_DP.class)
    public void TC1_verify_that_salesmanager_select_any_car(String salesManagerUserName) {

        //Verify that User launched to the Vehicle page, all the checkboxes should be unchecked
        loginBy(salesManagerUserName);
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

    @Test(dataProvider = "StoreManagerLogin", dataProviderClass = All_DP.class)
    public void TC1_verify_that_storemanager_select_any_car(String storeManagerLogin){

        //Verify that User launched to the Vehicle page, all the checkboxes should be unchecked
        loginBy(storeManagerLogin);
        Sleep.Zzz(3);
        Driver.getDriver().findElement(By.xpath("//div[@id='main-menu']//span[contains(text(),'Fleet')][1]")).click();
        Sleep.Zzz(3);
        Driver.getDriver().findElement(By.xpath("//li[@class='dropdown-menu-single-item first']//span[contains(text(),'Vehicles')]")).click();
        WebElement checkbox = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-default btn-small dropdown-toggle']/input[@type='checkbox']"));
        Assert.assertFalse(checkbox.isSelected(),"Checkbox is selected");

        //AC2_Verify that User check the first checkbox to check all the cars
        checkbox.click();
        Assert.assertTrue(checkbox.isSelected(),"Checkbox is not selected");
        checkbox.click();

        //AC3Verify that Users can select any car
        List<WebElement> randomCheckbox = Driver.getDriver().findElements(By.xpath("//input[@tabindex='-1']"));
        //Select $ UnSelect EachCheckBox
        for (WebElement eachCheckbox : randomCheckbox) {
            if (!eachCheckbox.isSelected()) {
                eachCheckbox.click();
                System.out.println(eachCheckbox + "checked");

            }
            for (WebElement eachUncheckBox : randomCheckbox) {
                if (eachUncheckBox.isSelected()) {
                    eachUncheckBox.click();
                    System.out.println(eachCheckbox + "unchecked");
                }
            }

        }


    }


}
