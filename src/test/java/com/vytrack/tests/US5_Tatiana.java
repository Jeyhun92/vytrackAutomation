package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.ExtraUtils.Sleep;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US5_Tatiana extends TestBase {

    @Test
    public void test_vehicle_model_as_sales_manager() {
        VytrackUtils.loginAsSalesManager();

        Sleep.Zzz(2);
        WebElement fleetBtn = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
        fleetBtn.click();

        WebElement vehiclesModelBtn = Driver.getDriver().findElement(By.xpath("//span[.='Vehicles Model']"));
        vehiclesModelBtn.click();
        Sleep.Zzz(2);
        List<WebElement> vehiclesModelTable = Driver.getDriver().findElements(By.xpath("//thead[@class='grid-header']/tr/th/a"));

        List<String> actualVehiclesModelText = new ArrayList<>();
        /*vehiclesModelTable.forEach(p -> actualVehiclesModelText.add(p.getText()));*/

        for (WebElement each : vehiclesModelTable) {
            actualVehiclesModelText.add(each.getText());

        }
        System.out.println("actualVehiclesModelText = " + actualVehiclesModelText);

        List<String> expectedVehiclesModuleText = new ArrayList<>(Arrays.asList(
                "MODEL NAME",
                "MAKE",
                "CAN BE REQUESTED",
                "CVVI",
                "CO2 FEE (/MONTH)",
                "COST (DEPRECIATED)",
                "TOTAL COST (DEPRECIATED)",
                "CO2 EMISSIONS",
                "FUEL TYPE",
                "VENDORS"));

        System.out.println("expectedVehiclesModuleText = " + expectedVehiclesModuleText);
        Assert.assertEquals(actualVehiclesModelText, expectedVehiclesModuleText);
    }

    @Test
    public void test_vehicle_model_as_store_manager() {
        VytrackUtils.loginAsStoreManger();
        Sleep.Zzz(2);
        WebElement fleetBtn = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
        fleetBtn.click();

        WebElement vehiclesModelBtn = Driver.getDriver().findElement(By.xpath("//span[.='Vehicles Model']"));
        vehiclesModelBtn.click();

        Sleep.Zzz(2);
        List<WebElement> vehiclesModelTable = Driver.getDriver().findElements(By.xpath("//thead[@class='grid-header']/tr/th/a"));

        List<String> actualVehiclesModelText = new ArrayList<>();
        /*vehiclesModelTable.forEach(p -> actualVehiclesModelText.add(p.getText()));*/

        for (WebElement each : vehiclesModelTable) {
            actualVehiclesModelText.add(each.getText());

        }
        System.out.println("actualVehiclesModelText = " + actualVehiclesModelText);

        List<String> expectedVehiclesModuleText = new ArrayList<>(Arrays.asList(
                "MODEL NAME",
                "MAKE",
                "CAN BE REQUESTED",
                "CVVI",
                "CO2 FEE (/MONTH)",
                "COST (DEPRECIATED)",
                "TOTAL COST (DEPRECIATED)",
                "CO2 EMISSIONS",
                "FUEL TYPE",
                "VENDORS"));

        System.out.println("expectedVehiclesModuleText = " + expectedVehiclesModuleText);
        Assert.assertEquals(actualVehiclesModelText, expectedVehiclesModuleText);
    }

    @Test
    public void test_vehicle_model_as_driver() {
        VytrackUtils.loginAsDriver();
        Sleep.Zzz(2);
        WebElement fleetBtn = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        fleetBtn.click();
        Sleep.Zzz(2);
        WebElement vehiclesModelBtn = Driver.getDriver().findElement(By.xpath("//span[.='Vehicles Model']"));
        vehiclesModelBtn.click();

        WebElement errorText = Driver.getDriver().findElement(By.xpath("//div[.='You do not have permission to perform this action.']"));

        Assert.assertTrue(errorText.isDisplayed());
    }
}
