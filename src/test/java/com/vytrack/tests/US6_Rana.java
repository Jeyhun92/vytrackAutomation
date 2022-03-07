package com.vytrack.tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

    public class US6_Rana {
        WebDriver driver;

        @BeforeMethod
        public void setupMethod() {
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.get("https://qa1.vytrack.com/user/login");

            driver.findElement(By.id("prependedInput")).sendKeys("user44");
            driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
            driver.findElement(By.name("_submit")).click();

        }

        @Test
        public void editOptionsTab() throws InterruptedException {
            driver.findElement(By.xpath("//span[@class='title title-level-1']")).click();
            driver.findElement(By.linkText("Vehicles")).click();

            WebElement dotOption = driver.findElement(By.xpath("//td[@class='action-cell grid-cell grid-body-cell']"));
            dotOption.click();




            System.out.println("dotOption.isDisplayed() = " + dotOption.isDisplayed());

        }}

/*
Description: users see the car edited options on the Vehicle page
Environment: https://qa1.vytrack.com/user/login
Steps:
Users are on the homepage
Click the Vehicles under the Fleet
Verify any car info has 3 dots “...”, and there are “view, edit, delete” icons.
 */




