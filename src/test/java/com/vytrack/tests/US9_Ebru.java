package com.vytrack.tests;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.vytrack.utilities.Driver.getDriver;

public class US9_Ebru {

    WebDriver driver;

    @BeforeMethod

    public void setUpMethod() {

        Driver.getDriver().get(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env1"));
    }
    @Test
    public void test_case_01(){
//      1- Users are on the homepage
        WebElement usernameBox = driver.findElement(By.id("prependedInput"));
        usernameBox.sendKeys("user44");

        WebElement passwordBox = driver.findElement(By.id("prependedInput2"));
        passwordBox.sendKeys("UserUser123");

        WebElement loginButton = driver.findElement(By.id("_submit"));
        loginButton.click();

//      2- Click the “java.util.Calendar Events” under the Activities
        WebElement activitiesTab = driver.findElement(By.xpath("(//a[@class='unclickable'])[3]"));
        activitiesTab.click();


//      3- Click the “Create Calendar Event” button
        WebElement calenderEventsTab = driver.findElement(By.xpath("//span[text()='Calendar Events']"));
        calenderEventsTab.click();

        WebElement createCalenderEventBox = driver.findElement(By.xpath("//a[@title='Create Calendar event']"));
        createCalenderEventBox.click();

//      4- Check the Repeat checkbox
        WebElement repeatCheckbox = driver.findElement(By.xpath("//input[contains(@id,'recurrence-repeat-view')]"));
        repeatCheckbox.click();

//      5- Users enter an INVALID integer (x<1 || x>99)
        WebElement repeatEveryBox = driver.findElement(By.xpath("(//input[@class='recurrence-subview-control__number'])[1]"));
        repeatEveryBox.clear();
        repeatEveryBox.sendKeys("-1");

        //      6- Verify users get 2 error messages
        WebElement message1 = driver.findElement(By.xpath("//span[text()='The value have not to be less than 1.']"));
        String expectedMessage1 = message1.getText();
        String actualMessage1 = "The value have not to be less than 1.";


        repeatEveryBox.clear();
        repeatEveryBox.sendKeys("100");


        WebElement message2 = driver.findElement(By.xpath("//span[.='The value have not to be more than 99.']"));
        String expectedMessage2 = message2.getText();
        String actualMessage2 = "The value have not to be more than 99.";

        Assert.assertEquals(actualMessage2, expectedMessage2);


    }
    @Test
    public void test_case_02() {
        WebElement usernameBox = driver.findElement(By.id("prependedInput"));
        usernameBox.sendKeys("storemanager75");

        WebElement passwordBox = driver.findElement(By.id("prependedInput2"));
        passwordBox.sendKeys("UserUser123");

        WebElement loginButton = driver.findElement(By.id("_submit"));
        loginButton.click();

        //WebElement calendarEventsButton = driver.findElement(By.xpath("//div[@id='main-menu']/ul/li[5]/div//ul//li[4]/a/span"));
        //WebElement calendarEventsButton = driver.findElement(By.xpath("//div[@id='main-menu']//div//ul//li//a//span[text()='Calendar Events']"));
        //calendarEventsButton.click();
        getDriver().findElement(By.xpath("(//div[@id='main-menu']/ul/li)[5]")).click();
        getDriver().findElement(By.linkText("Create Calendar")).click();

//      3- Click the “Create Calendar Event” button
        WebElement createCalenderEventButton = driver.findElement(By.xpath("//a[@title='Create Calendar event']"));
        createCalenderEventButton.click();

//      4- Check the Repeat checkbox
        WebElement repeatCheckbox = driver.findElement(By.xpath("//input[contains(@id,'recurrence-repeat-view')]"));
        repeatCheckbox.click();

//      5- Users enter an INVALID integer (x<1 || x>99)
        WebElement repeatEveryBox = driver.findElement(By.xpath("//label[@class='fields-row']//input[3]"));
        repeatCheckbox.clear();

        repeatEveryBox.sendKeys("0");

//      6- Verify users get 2 error messages
        WebElement errorMessage = driver.findElement(By.xpath("//span[text()='The value have not to be less than 1.']")) ;
        String expectedErrorMessage = "The value have not to be less than 1.";
        String actualErrorMessage = errorMessage.getText();
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);

        repeatEveryBox.clear();
        repeatEveryBox.sendKeys("100");

        WebElement errorMessage2 = driver.findElement(By.xpath("//span[text()='The value have not to be more than 99.']"));
        String expectedErrorMessage2 = "The value have not to be more than 99.";
        String actualErrorMessage2 = errorMessage2.getText();
        Assert.assertEquals(actualErrorMessage2, expectedErrorMessage2);

    }


}
