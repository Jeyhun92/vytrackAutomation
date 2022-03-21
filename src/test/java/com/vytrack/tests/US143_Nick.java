package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.ExtraUtils.All_DP;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.vytrack.utilities.ExtraUtils.All_DP;
import com.vytrack.utilities.ExtraUtils.Sleep;

import java.util.Locale;

import static com.vytrack.utilities.ExtraUtils.LoginBy.loginBy;

public class US143_Nick extends TestBase {

    @Test(dataProvider = "StoreManagerLogin", dataProviderClass = All_DP.class)
    public void vehicle_cost_page_test(String storeManagerLogin){

        //As a user, I want to manage filters on the Vehicle Costs page.
        //AC #1: Users should see three columns on the Vehicle Cost page.
        //               Expected Column names:
        //               TYPE, TOTAL PRICE, DATE
        //
        //AC #2: users check the first checkbox to check all the Vehicle Costs

        loginBy(storeManagerLogin);

       //Locating Fleet Tab web element
        WebElement fleetTab = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));

        //Locating Vehicle Cost option
        WebElement vehicleCostOption = Driver.getDriver().findElement(By.xpath("//span[.='Vehicle Costs']"));

        Sleep.Zzz(2);
        //Hovering over Fleet Tab
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(fleetTab).perform();

        Sleep.Zzz(2);
        //Hovering over Vehicle Cost option
        actions.moveToElement(vehicleCostOption).perform();

        Sleep.Zzz(2);
        //Clicking on the Vehicles Cost option
        vehicleCostOption.click();

        //Locating Type element
        WebElement typeHeader = Driver.getDriver().findElement(By.xpath("//span[.='Type']"));
        //Locating Total Price Header
        WebElement totalPriceHeader = Driver.getDriver().findElement(By.xpath("//span[.='Total Price']"));
        //Locating the Date header
        WebElement dateHeader = Driver.getDriver().findElement(By.xpath("//span[.='Date']"));

        String typeHeaderText = typeHeader.getText();
        String totalPriceHeaderText = totalPriceHeader.getText();
        String dateHeaderText = dateHeader.getText();

        //System.out.println(typeHeaderText);
        //System.out.println(totalPriceHeaderText);
        //System.out.println(dateHeaderText);

        Assert.assertEquals(typeHeaderText, "TYPE");
        Assert.assertEquals(totalPriceHeaderText, "TOTAL PRICE");
        Assert.assertEquals(dateHeaderText, "DATE");

        //Locating the check box
        WebElement checkBox = Driver.getDriver().findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        Sleep.Zzz(2);
        checkBox.click();
        Sleep.Zzz(2);

        Assert.assertTrue(checkBox.isSelected());

    }

}
