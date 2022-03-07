package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static com.vytrack.utilities.Driver.getDriver;
import static com.vytrack.utilities.ExtraUtils.HeaderMap.goToPage;
import static com.vytrack.utilities.ExtraUtils.LoginBy.loginBy;
import static com.vytrack.utilities.ExtraUtils.Sleep.Zzz;

public class US10_Ahmet extends TestBase {

    @DataProvider(name = "DriverLogin")
    Object[][] TruckDriver() {

        return new Object[][]{
                {"user44"},
                {"user49"}
        };

    }

    @Test(dataProvider = "DriverLogin")
    public void TC1_Verifying_Description_MsgByDriver(String truckDriverUserName) {

        loginBy(truckDriverUserName);

        goToPage(3, "Calendar Events");
        /*getDriver().findElement(By.xpath("(//div[@id='main-menu']/ul/li)[3]")).click();
        getDriver().findElement(By.linkText("Calendar Events")).click();*/
        Zzz(3);
        getDriver().findElement(By.xpath("(//div[@class='container-fluid page-title']/div/div/div)[2]")).click();

        Zzz(3);
        getDriver().switchTo().frame(getDriver().findElement(By.xpath("//iframe[starts-with(@id,'oro_calendar_event_form_description')]")));

        Zzz(3);
        String expectedResult = "Scrum Daily Meeting setup at 10:30";

        getDriver().findElement(By.tagName("body")).sendKeys(expectedResult);
        String actualResult = getDriver().findElement(By.tagName("p")).getText();
        getDriver().switchTo().parentFrame();

        WebElement repeatBTN = getDriver().findElement(By.xpath("//input[starts-with(@id,'recurrence-repeat')]"));
        repeatBTN.click();
        System.out.println("repeatBTN.isSelected() = " + repeatBTN.isSelected());

        Assert.assertEquals(actualResult, expectedResult);


    }

    @DataProvider(name = "SalesManagerLogin")
    Object[][] SalesManager() {

        return new Object[][]{
                {"storemanager75"},
                {"storemanager78"}
        };

    }

    @Test(dataProvider = "SalesManagerLogin")
    public void TC1_Verifying_Description_MsgBySalesManager(String salesManagerUserName) {

        loginBy(salesManagerUserName);
        Zzz(3);
        goToPage(5, "Calendar Events");
        Zzz(3);
        getDriver().findElement(By.xpath("(//div[@class='container-fluid page-title']/div/div/div)[2]")).click();


        getDriver().switchTo().frame(getDriver().findElement(By.xpath("//iframe[starts-with(@id,'oro_calendar_event_form_description')]")));

        Zzz(3);
        String expectedResult = "Scrum Daily Meeting setup at 10:30";

        getDriver().findElement(By.tagName("body")).sendKeys(expectedResult);
        String actualResult = getDriver().findElement(By.tagName("p")).getText();
        getDriver().switchTo().parentFrame();

        WebElement repeatBTN = getDriver().findElement(By.xpath("//input[starts-with(@id,'recurrence-repeat')]"));
        repeatBTN.click();
        System.out.println("repeatBTN.isSelected() = " + repeatBTN.isSelected());

        Assert.assertEquals(actualResult, expectedResult);


    }

    @DataProvider(name = "StoreManagerLogin")
    Object[][] StoreManager() {
        return new Object[][]{
                {"salesmanager133"}, {"salesmanager136"}

        };
    }

    @Test(dataProvider = "StoreManagerLogin")
    public void TC1_Verifying_Description_MsgByStoreManager(String storeManagerLogin) {

        loginBy(storeManagerLogin);
        Zzz(3);
        goToPage(5, "Calendar Events");
        /*getDriver().findElement(By.xpath("(//div[@id='main-menu']/ul/li)[5]")).click();
        getDriver().findElement(By.linkText("Calendar Events")).click();*/

        Zzz(3);
        getDriver().findElement(By.xpath("(//div[@class='container-fluid page-title']/div/div/div)[2]")).click();
        getDriver().switchTo().frame(getDriver().findElement(By.xpath("//iframe[starts-with(@id,'oro_calendar_event_form_description')]")));

        Zzz(3);
        String expectedResult = "Scrum Daily Meeting setup at 10:30";

        getDriver().findElement(By.tagName("body")).sendKeys(expectedResult);
        String actualResult = getDriver().findElement(By.tagName("p")).getText();
        getDriver().switchTo().parentFrame();

        WebElement repeatBTN = getDriver().findElement(By.xpath("//input[starts-with(@id,'recurrence-repeat')]"));
        repeatBTN.click();
        System.out.println("repeatBTN.isSelected() = " + repeatBTN.isSelected());

        Assert.assertEquals(actualResult, expectedResult);


    }

    @DataProvider(name = "LoginAll")
    Object[][] loginCredentials() {

        return new Object[][]{
                {"user44"},
                {"user49"},
                {"salesmanager133"},
                {"salesmanager136"},
                {"storemanager75"},
                {"storemanager78"}
        };

    }

    @Ignore
    @Test(dataProvider = "LoginAll")
    public void TC1_Verifying_Description_Msg(String user) {

        loginBy(user);

        goToPage("Calendar Events");
        /*getDriver().findElement(By.xpath("(//div[@id='main-menu']/ul/li)[3]")).click();
        getDriver().findElement(By.linkText("Calendar Events")).click();*/
        Zzz(3);
        getDriver().findElement(By.xpath("(//div[@class='container-fluid page-title']/div/div/div)[2]")).click();

        Zzz(3);
        getDriver().switchTo().frame(getDriver().findElement(By.xpath("//iframe[starts-with(@id,'oro_calendar_event_form_description')]")));

        Zzz(3);
        String expectedResult = "Scrum Daily Meeting setup at 10:30";

        getDriver().findElement(By.tagName("body")).sendKeys(expectedResult);
        String actualResult = getDriver().findElement(By.tagName("p")).getText();
        getDriver().switchTo().parentFrame();

        WebElement repeatBTN = getDriver().findElement(By.xpath("//input[starts-with(@id,'recurrence-repeat')]"));
        repeatBTN.click();
        System.out.println("repeatBTN.isSelected() = " + repeatBTN.isSelected());

        Assert.assertEquals(actualResult, expectedResult);


    }

}
