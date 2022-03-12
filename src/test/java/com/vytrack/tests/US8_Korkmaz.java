package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.ExtraUtils.Sleep;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US8_Korkmaz extends TestBase {

    @Test
    public void verify_default_repeat_day_is1 (){

        VytrackUtils.loginAsDriver();
        Sleep.Zzz(5);

        WebElement activityTab = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[3]"));
        //Actions hover = new Actions(Driver.getDriver());
        //hover.moveToElement(activityTab);
        activityTab.click();

        Sleep.Zzz(3);
        WebElement calendarEventsTab = Driver.getDriver().findElement(By.xpath("//span[.='Calendar Events']"));
        calendarEventsTab.click();

        Sleep.Zzz(3);
        WebElement createCalenderEventTab = Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']"));
        createCalenderEventTab.click();

        Sleep.Zzz(3);
        WebElement checkBox = Driver.getDriver().findElement(By.xpath("//input[@id='recurrence-repeat-view248']"));
        checkBox.click();

        Sleep.Zzz(5);
        WebElement recurringBox = Driver.getDriver().findElement(By.xpath("//input[@class='recurrence-subview-control__number']"));
        System.out.println("recurringBox.attribute() = " + recurringBox.getAttribute("value"));

        Assert.assertEquals(recurringBox.getAttribute("value"), "1");


    }

    @Test
    public void verify_error_message_when_repeat_day_is_cleared(){

        VytrackUtils.loginAsDriver();

        Sleep.Zzz(5);

        WebElement activityTab = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[3]"));
        activityTab.click();

        Sleep.Zzz(3);
        WebElement calendarEventsTab = Driver.getDriver().findElement(By.xpath("//span[.='Calendar Events']"));
        calendarEventsTab.click();

        Sleep.Zzz(3);
        WebElement createCalenderEventTab = Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']"));
        createCalenderEventTab.click();

        Sleep.Zzz(3);
        WebElement checkBox = Driver.getDriver().findElement(By.xpath("//input[@id='recurrence-repeat-view248']"));
        checkBox.click();

        WebElement recurringBox = Driver.getDriver().findElement(By.xpath("//input[@class='recurrence-subview-control__number']"));
        recurringBox.clear();

        WebElement errorMessage = Driver.getDriver().findElement(By.xpath("//span[.='This value should not be blank.']"));
        System.out.println("errorMessage.getText() = " + errorMessage.getText());
        Assert.assertTrue(errorMessage.isDisplayed());

    }


}

/*
Story8:  As a user, I want to create a recurring(repetitive) calendar event.
AC #1: user should see the number “1” by default in the Repeat Every input.
AC #2: user should see an error message “This value should not be blank.”
when the Calendar event repeat field is cleared(delete the number 1).

Test cases #1
Description:  users see the default repeat day as 1
Environment: https://qa2.vytrack.com/user/login
Steps:
1.	Users are on the homepage
2.	Click the “Calendar Events” under the Activities
3.	Click the “Create Calendar Event” button
4.	Check the Repeat checkbox
5.	Verify the repeat number is 1

Test cases #2
Description:  users clear the repat day and see an error message
Environment: https://qa2.vytrack.com/user/login
Steps:
1.	Users are on the homepage
2.	Click the “Calendar Events” under the Activities
3.	Click the “Create Calendar Event” button
4.	Check the Repeat checkbox
5.	Clear(delete) the number 1
6.	Verify the app displays “This value should not be blank.”

 */