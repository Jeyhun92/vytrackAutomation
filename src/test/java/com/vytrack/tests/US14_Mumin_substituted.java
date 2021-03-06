package com.vytrack.tests;

import com.github.javafaker.Faker;
import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.ExtraUtils.All_DP;
import com.vytrack.utilities.ExtraUtils.HeaderMap;
import com.vytrack.utilities.ExtraUtils.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static com.vytrack.utilities.ExtraUtils.HeaderMap.goToPage;
import static com.vytrack.utilities.ExtraUtils.LoginBy.loginBy;
import static com.vytrack.utilities.ExtraUtils.LoginBy.loginPg;
import static com.vytrack.utilities.ExtraUtils.Sleep.Zzz;
import static com.vytrack.utilities.ExtraUtils.Sleep.bePatient;

public class US14_Mumin_substituted extends TestBase {


    @Test(dataProvider = "SM", dataProviderClass = All_DP.class)
    public void TC1_manage_Filters_on_the_MarketingByStoreM(String user) {

        loginBy(user);

        Zzz(3);
        goToPage(user, "Marketing", "Campaigns");
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
    public void TC2_checkboxVerification(String user) {
        loginBy(user);

        Zzz(3);

        HeaderMap.goToPage("Marketing", "Campaigns");
        Driver.getDriver().findElement(By.xpath("//a[@class='action btn mode-icon-only']")).click();
        Driver.getDriver().findElement(By.className("add-filter-button")).click();
        List<WebElement> checkbox = Driver.getDriver().findElements(By.xpath("//label/input[@type='checkbox']"));
        System.out.println("checkbox = " + checkbox.size());

        Zzz(3);
        WebElement checkbox3 = Driver.getDriver().findElement(By.id("ui-multiselect-0-0-option-2"));
        checkbox3.click();
        Zzz(3);


        WebElement checkbox5 = Driver.getDriver().findElement(By.id("ui-multiselect-0-0-option-4"));
        checkbox5.click();

        List<WebElement> listSelected = Driver.getDriver().findElements(By.xpath("//input[@checked='checked']"));

        System.out.println("Size of checked " + listSelected.size());
        System.out.println("Size of non-checked " + (checkbox.size() - listSelected.size()));



       /* WebElement checkbox1 = Driver.getDriver().findElement(By.id("ui-multiselect-0-0-option-0"));
        WebElement checkbox2 = Driver.getDriver().findElement(By.id("ui-multiselect-0-0-option-1"));

        WebElement checkbox4 = Driver.getDriver().findElement(By.id("ui-multiselect-0-0-option-3"));


        checkbox1.isSelected();
        Sleep.Zzz(3);
        checkbox2.click();
        Sleep.Zzz(3);
        checkbox2.isSelected();

        Sleep.Zzz(3);
        checkbox3.isSelected();
        Sleep.Zzz(3);
        checkbox4.isSelected();
        Sleep.Zzz(3);
        checkbox5.isSelected();

        checkbox5.click();
        Sleep.Zzz(3);
            checkbox1.click();


        checkbox1.click();
        System.out.println("checkbox1.isSelected() = " + checkbox1.isSelected());
        Driver.getDriver().navigate().refresh();*/


    }
}












