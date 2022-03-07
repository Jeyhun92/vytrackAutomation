package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


    public class US1_Gunay extends TestBase {

        @Test
        public void verifying_modules_as_store_manger(){

            VytrackUtils.loginAsStoreManger();

            List<String> expected_result=new ArrayList<>(Arrays.asList("Dashboards",
                    "Fleet",
                    "Customers",
                    "Sales",
                    "Activities",
                    "Marketing",
                    "Reports & Segments",
                    "System"));


            List<WebElement> moduleElements = Driver.getDriver().findElements(By.xpath("//span[@class='title title-level-1']"));
            List<String> actual_result=new ArrayList<>();
            for (WebElement each : moduleElements) {
                actual_result.add(each.getText());
            }

            Assert.assertEquals(actual_result,expected_result);

        }

        @Test
        public void verifying_modules_as_store_manger_negative_scenario(){

            VytrackUtils.loginAsStoreManger();

            List<String> expected_result=new ArrayList<>(Arrays.asList("Dashboards ",
                    "Fleet",
                    "Customers",
                    "Sales",
                    "Activities",
                    "Marketing1",
                    "Reports & Segments",
                    "System"));


            List<WebElement> moduleElements = Driver.getDriver().findElements(By.xpath("//span[@class='title title-level-1']"));
            List<String> actual_result=new ArrayList<>();
            for (WebElement each : moduleElements) {
                actual_result.add(each.getText());
            }

            Assert.assertNotEquals(actual_result,expected_result);

        }

        @Test
        public void verifying_modules_as_sales_manger() {

            VytrackUtils.loginAsSalesManager();

            List<String> expected_result=new ArrayList<>(Arrays.asList("Dashboards",
                    "Fleet",
                    "Customers",
                    "Sales",
                    "Activities",
                    "Marketing",
                    "Reports & Segments",
                    "System"));


            List<WebElement> moduleElements = Driver.getDriver().findElements(By.xpath("//span[@class='title title-level-1']"));
            List<String> actual_result=new ArrayList<>();
            for (WebElement each : moduleElements) {
                actual_result.add(each.getText());
            }

            Assert.assertEquals(actual_result,expected_result);

        }

        @Test
        public void verifying_modules_as_sales_manger_negative_scenario() {

            VytrackUtils.loginAsSalesManager();

            List<String> expected_result=new ArrayList<>(Arrays.asList("Dashboards",
                    "Fleet",
                    "Customers",
                    "Activities",
                    "Marketing",
                    "Reports & Segments",
                    "System"));


            List<WebElement> moduleElements = Driver.getDriver().findElements(By.xpath("//span[@class='title title-level-1']"));
            List<String> actual_result=new ArrayList<>();
            for (WebElement each : moduleElements) {
                actual_result.add(each.getText());
            }

            Assert.assertNotEquals(actual_result,expected_result);

        }

        @Test
        public void verifying_modules_as_drive(){

            VytrackUtils.loginAsDriver();

            List<String> expected_result=new ArrayList<>(Arrays.asList("Fleet",
                    "Customers",
                    "Activities",
                    "System"));

            List<String> actual_result=new ArrayList<>();

            List<WebElement> allModules= Driver.getDriver().findElements(By.xpath("//span[@class='title title-level-1']"));

            for (WebElement each : allModules) {
                actual_result.add(each.getText());
            }

            Assert.assertEquals(actual_result,expected_result);

        }

        @Test
        public void verifying_modules_as_drive_negative_scenario(){

            VytrackUtils.loginAsDriver();

            List<String> expected_result=new ArrayList<>(Arrays.asList("Fleet",
                    "Custjjkdgsg",
                    "Activities",
                    "System"));

            List<String> actual_result=new ArrayList<>();

            List<WebElement> allModules= Driver.getDriver().findElements(By.xpath("//span[@class='title title-level-1']"));

            for (WebElement each : allModules) {
                actual_result.add(each.getText());
            }

            Assert.assertNotEquals(actual_result,expected_result);

        }
    }

