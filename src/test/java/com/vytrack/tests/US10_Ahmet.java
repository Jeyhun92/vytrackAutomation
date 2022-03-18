package com.vytrack.tests;

import com.vytrack.pages.CalendarEvent;
import com.vytrack.pages.Dashboard;
import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.ExtraUtils.All_DP;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static com.vytrack.utilities.Driver.getDriver;
import static com.vytrack.utilities.ExtraUtils.HeaderMap.goToPage;
import static com.vytrack.utilities.ExtraUtils.LoginBy.loginBy;
import static com.vytrack.utilities.ExtraUtils.LoginBy.loginPg;
import static com.vytrack.utilities.ExtraUtils.Sleep.Zzz;
import static com.vytrack.utilities.ExtraUtils.Sleep.bePatient;

public class US10_Ahmet extends TestBase {

    /*@Test(dataProvider = "DriverLogin", dataProviderClass = All_DP.class)
    public void test(String user) {
        loginPg(user);
        Zzz(3);
        goToPage(user,"Activities", "Calendar Events");

    }*/
// Data Driven Test




    @Test(dataProvider = "LoginAll", dataProviderClass = All_DP.class)
    public void TC1_Verifying_Description_Msg(String user) {

        loginPg(user); //user44

      //  bePatient(dashboard.activitiesHover,15);
        Zzz(3);
        goToPage(user,"Activities", "Calendar Events");

        Zzz(3);
       // bePatient(event.createCalendarEventBtn,10);
        event.createCalendarEventBtn.click();

        Zzz(3);
        getDriver().switchTo().frame(create.iframePg);

        Zzz(3);
        String expectedResult = "Scrum Daily Meeting setup at 10:30";
        create.textBoardInput.sendKeys(expectedResult);

        String actualResult = create.textBoard.getText();
        getDriver().switchTo().parentFrame();

        create.repeatBtn.click();
        System.out.println("repeatBTN.isSelected() = " + create.repeatBtn.isSelected());

        Assert.assertEquals(actualResult, expectedResult);


    }


}
