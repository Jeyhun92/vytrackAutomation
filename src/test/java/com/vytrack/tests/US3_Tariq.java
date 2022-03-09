package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class US3_Tariq extends TestBase {

    @Test
    public void PinbarTest_Driver() {
        //login page

        VytrackUtils.loginAsDriver();



        //click on "learn how to use this space"

        WebElement learnHowtoUseThisSpace = Driver.getDriver().findElement(By.xpath("//a[.='Learn how to use this space']"));
        learnHowtoUseThisSpace.click();

        BrowserUtils.sleep(1);

        WebElement pinBarButton = Driver.getDriver().findElement(By.xpath("//i[@class='fa-thumb-tack hide-text']"));
        pinBarButton.click();

        //verify the image

       WebElement imageActual = Driver.getDriver().findElement(By.cssSelector("img[src='/bundles/oronavigation/images/pinbar-location.jpg']"));
       Assert.assertTrue(imageActual.isDisplayed());

       BrowserUtils.sleep(1);




    }

        @Test
        public void PinbarTest_Sales () {

            //Login
            VytrackUtils.loginAsSalesManager();



            //Click
            WebElement learnHowToUseThisSpace2 = Driver.getDriver().findElement(By.xpath("//a[text()='Learn how to use this space']"));
            learnHowToUseThisSpace2.click();

            BrowserUtils.sleep(1);

            WebElement pinBarButton2 = Driver.getDriver().findElement(By.xpath("//i[@class='fa-thumb-tack hide-text']"));
            pinBarButton2.click();

            //Verify
            WebElement actualImage2 = Driver.getDriver().findElement(By.cssSelector("img[src='/bundles/oronavigation/images/pinbar-location.jpg']"));
            Assert.assertTrue(actualImage2.isDisplayed());

            BrowserUtils.sleep(1);
        }

        @Test
        public void PinbarTest_Store () {


            //Login
            VytrackUtils.loginAsStoreManger();



            WebElement learnHowToUseThisSpace3 = Driver.getDriver().findElement(By.xpath("//a[text()='Learn how to use this space']"));
            learnHowToUseThisSpace3.click();

            BrowserUtils.sleep(1);

            WebElement pinBarButton3 = Driver.getDriver().findElement(By.xpath("//i[@class='fa-thumb-tack hide-text']"));
            pinBarButton3.click();

            //Verify
            WebElement actualImage3 = Driver.getDriver().findElement(By.cssSelector("img[src='/bundles/oronavigation/images/pinbar-location.jpg']"));
            Assert.assertTrue(actualImage3.isDisplayed());


        }

    }


