package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.ExtraUtils.HeaderMap;
import com.vytrack.utilities.ExtraUtils.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



import static com.vytrack.utilities.Driver.getDriver;

public class US9_Ebru extends TestBase {



    @Test
    public void test_case_01(){
//      1- Users are on the homepage
        WebElement usernameBox = Driver.getDriver().findElement(By.id("prependedInput"));
        usernameBox.sendKeys("user44");

        WebElement passwordBox = Driver.getDriver().findElement(By.id("prependedInput2"));
        passwordBox.sendKeys("UserUser123");

        WebElement loginButton = Driver.getDriver().findElement(By.id("_submit"));
        loginButton.click();

        HeaderMap.goToPage(3,"Calendar Events");

/*//      2- Click the “java.util.Calendar Events” under the Activities
        WebElement activitiesTab = Driver.getDriver().findElement(By.xpath("(//a[@class='unclickable'])[3]"));
        activitiesTab.click();


//      3- Click the “Create Calendar Event” button
        WebElement calenderEventsTab = Driver.getDriver().findElement(By.xpath("//span[text()='Calendar Events']"));
        calenderEventsTab.click();*/
        Sleep.Zzz(3);
        WebElement createCalenderEventBox = Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']"));

        createCalenderEventBox.click();

//      4- Check the Repeat checkbox
        WebElement repeatCheckbox = Driver.getDriver().findElement(By.xpath("//input[contains(@id,'recurrence-repeat-view')]"));
        repeatCheckbox.click();
        Sleep.Zzz(2);
//      5- Users enter an INVALID integer (x<1 || x>99)
        WebElement repeatEveryBox = Driver.getDriver().findElement(By.xpath("(//input[@class='recurrence-subview-control__number'])[1]"));
        repeatEveryBox.clear();
        repeatEveryBox.sendKeys("-1");

        //      6- Verify users get 2 error messages
        WebElement message1 = Driver.getDriver().findElement(By.xpath("//span[text()='The value have not to be less than 1.']"));
        String expectedMessage1 = message1.getText();
        String actualMessage1 = "The value have not to be less than 1.";

        Sleep.Zzz(2);
        repeatEveryBox.clear();
        repeatEveryBox.sendKeys("100");

        Sleep.Zzz(2);
        WebElement message2 = Driver.getDriver().findElement(By.xpath("//span[.='The value have not to be more than 99.']"));
        String expectedMessage2 = message2.getText();
        String actualMessage2 = "The value have not to be more than 99.";

        Assert.assertEquals(actualMessage2, expectedMessage2);


    }
    @Test
    public void test_case_02() {
        WebElement usernameBox = Driver.getDriver().findElement(By.id("prependedInput"));
        usernameBox.sendKeys("storemanager75");

        WebElement passwordBox = Driver.getDriver().findElement(By.id("prependedInput2"));
        passwordBox.sendKeys("UserUser123");

        WebElement loginButton = Driver.getDriver().findElement(By.id("_submit"));
        loginButton.click();

        //WebElement calendarEventsButton = Driver.getDriver().findElement(By.xpath("//div[@id='main-menu']/ul/li[5]/div//ul//li[4]/a/span"));
        Sleep.Zzz(2);
        getDriver().findElement(By.xpath("(//div[@id='main-menu']/ul/li)[5]")).click();


        WebElement calendarEventsButton = Driver.getDriver().findElement(By.xpath("//div[@id='main-menu']//div//ul//li//a//span[text()='Calendar Events']"));
        calendarEventsButton.click();

        Sleep.Zzz(2);
//      3- Click the “Create Calendar Event” button
        WebElement createCalenderEventButton = Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']"));
        createCalenderEventButton.click();

//     4- Check the Repeat checkbox
       WebElement repeatCheckbox = Driver.getDriver().findElement(By.xpath("//input[contains(@id,'recurrence-repeat-view')]"));
       repeatCheckbox.click();
       Sleep.Zzz(2);
//     5- Users enter an INVALID integer (x<1 || x>99)
       WebElement repeatEveryBox = Driver.getDriver().findElement(By.xpath("(//input[@class='recurrence-subview-control__number'])[1]"));
       repeatEveryBox.clear();

       repeatEveryBox.sendKeys("-1");

//     //      6- Verify users get 2 error messages
       WebElement message1 = Driver.getDriver().findElement(By.xpath("//span[text()='The value have not to be less than 1.']"));
       String expectedMessage1 = message1.getText();
       String actualMessage1 = "The value have not to be less than 1.";
       Sleep.Zzz(2);
       repeatEveryBox.clear();
       repeatEveryBox.sendKeys("100");
       Sleep.Zzz(2);

       WebElement message2 = Driver.getDriver().findElement(By.xpath("//span[.='The value have not to be more than 99.']"));
       String expectedMessage2 = message2.getText();
       String actualMessage2 = "The value have not to be more than 99.";
       Assert.assertEquals(actualMessage2, expectedMessage2);

    }


}
