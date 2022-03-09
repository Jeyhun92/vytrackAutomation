package com.vytrack.tests;

import com.github.javafaker.Faker;
import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.ExtraUtils.All_DP;
import com.vytrack.utilities.ExtraUtils.HeaderMap;
import com.vytrack.utilities.ExtraUtils.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.vytrack.utilities.ExtraUtils.LoginBy.loginBy;

public class US14_Mumin_substituted extends TestBase {


    @Test(dataProvider = "StoreManagerLogin", dataProviderClass = All_DP.class)
    public void TC1_manage_Filters_on_the_MarketingByStoreM(String storeManagerLogin) {

        loginBy(storeManagerLogin);
        Sleep.Zzz(3);

        HeaderMap.goToPage(6, "Campaigns");
        Driver.getDriver().findElement(By.xpath("//a[@class='action btn mode-icon-only']")).click();
        Driver.getDriver().findElement(By.className("add-filter-button")).click();
        List<WebElement> filterOptions = Driver.getDriver().findElements(By.cssSelector("ul[class='ui-multiselect-checkboxes ui-helper-reset fixed-li']>li"));
        List<String> expectedFilterList = new ArrayList<>(Arrays.asList("Name", "Code", "Start Date", "End Date", "Budget"));
        List<String> actualFilterList = new ArrayList<>();

        filterOptions.forEach(p -> actualFilterList.add(p.getText()));

        Assert.assertEquals(actualFilterList, expectedFilterList);

       /*
       I used forEach(p->actual.add(p.getText())
       lambda method to add all names in the List<Sting>

       The lambda method giving me the same result of forEach method below
       for (WebElement each : filterOptions) {
            actaalFilterList.add(each.getText());
        }*/


    }

    @Test(dataProvider = "SalesManagerLogin", dataProviderClass = All_DP.class)
    public void TC1_manage_Filters_on_the_MarketingBySalesM(String salesManager) {

        loginBy(salesManager);
        Sleep.Zzz(3);

        HeaderMap.goToPage(6, "Campaigns");
        Driver.getDriver().findElement(By.xpath("//a[@class='action btn mode-icon-only']")).click();
        Driver.getDriver().findElement(By.className("add-filter-button")).click();
        List<WebElement> filterOptions = Driver.getDriver().findElements(By.cssSelector("ul[class='ui-multiselect-checkboxes ui-helper-reset fixed-li']>li"));
        List<String> expectedFilterList = new ArrayList<>(Arrays.asList("Name", "Code", "Start Date", "End Date", "Budget"));
        List<String> actualFilterList = new ArrayList<>();

        filterOptions.forEach(p -> actualFilterList.add(p.getText()));

        Assert.assertEquals(actualFilterList, expectedFilterList);

       /*
       I used forEach(p->actual.add(p.getText())
       lambda method to add all names in the List<Sting>

       The lambda method giving me the same result of forEach method below
       for (WebElement each : filterOptions) {
            actaalFilterList.add(each.getText());
        }*/


    }

    @Test(dataProvider = "StoreManagerLogin", dataProviderClass = All_DP.class)
    public void TC2_checkboxVerification(String storeM) {
        loginBy(storeM);

        Sleep.Zzz(3);

        HeaderMap.goToPage(6, "Campaigns");
        Driver.getDriver().findElement(By.xpath("//a[@class='action btn mode-icon-only']")).click();
        Driver.getDriver().findElement(By.className("add-filter-button")).click();
        List<WebElement> filterOptions = Driver.getDriver().findElements(By.xpath("//ul[@class='ui-multiselect-checkboxes ui-helper-reset fixed-li']/li"));

        WebElement checkbox1 = Driver.getDriver().findElement(By.id("ui-multiselect-0-0-option-0"));
        WebElement checkbox2 = Driver.getDriver().findElement(By.id("ui-multiselect-0-0-option-1"));
        WebElement checkbox3 = Driver.getDriver().findElement(By.id("ui-multiselect-0-0-option-2"));
        WebElement checkbox4 = Driver.getDriver().findElement(By.id("ui-multiselect-0-0-option-3"));
        WebElement checkbox5 = Driver.getDriver().findElement(By.id("ui-multiselect-0-0-option-4"));

        checkbox1.isSelected();
        checkbox2.isSelected();
        checkbox3.isSelected();
        checkbox4.isSelected();
        checkbox5.isSelected();

        try {

            checkbox1.click();
            System.out.println("checkbox1.isSelected() = " + checkbox1.isSelected());
            Driver.getDriver().navigate().refresh();


        } catch (StaleElementReferenceException e) {

            e.printStackTrace();
        }


    }

}







