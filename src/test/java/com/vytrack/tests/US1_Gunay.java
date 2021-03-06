package com.vytrack.tests;

import com.vytrack.pages.Dashboard;
import com.vytrack.pages.LoginPage;
import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.ExtraUtils.All_DP;
import com.vytrack.utilities.ExtraUtils.LoginBy;
import com.vytrack.utilities.ExtraUtils.Sleep;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.vytrack.utilities.ExtraUtils.LoginBy.loginBy;


public class US1_Gunay extends TestBase {



        @Test(dataProvider = "StoreManagerLogin", dataProviderClass = All_DP.class)
        public void verifying_modules_as_store_manger(String storeManagerLogin){

            LoginBy.loginPg(storeManagerLogin);

            Sleep.Zzz(1);

            List<String> expected_result=new ArrayList<>(Arrays.asList("Dashboards",
                    "Fleet",
                    "Customers",
                    "Sales",
                    "Activities",
                    "Marketing",
                    "Reports & Segments",
                    "System"));


            Dashboard dashboard=new Dashboard();

            List<WebElement> moduleElements =  dashboard.mainMenuListLarge;
            List<String> actual_result=new ArrayList<>();
            for (WebElement each : moduleElements) {
                actual_result.add(each.getText());
            }

            Assert.assertEquals(actual_result,expected_result);

        }

    @Test(dataProvider = "StoreManagerLogin", dataProviderClass = All_DP.class)
        public void verifying_modules_as_store_manger_negative_scenario(String storeManagerLogin){

        LoginBy.loginPg(storeManagerLogin);

        Sleep.Zzz(1);

            List<String> expected_result=new ArrayList<>(Arrays.asList("Dashboards ",
                    "Fleet",
                    "Customers",
                    "Sales",
                    "Activities",
                    "Marketing1",
                    "Reports & Segments",
                    "System"));

        Dashboard dashboard=new Dashboard();

        List<WebElement> moduleElements =  dashboard.mainMenuListLarge;
            List<String> actual_result=new ArrayList<>();
            for (WebElement each : moduleElements) {
                actual_result.add(each.getText());
            }

            Assert.assertNotEquals(actual_result,expected_result);

        }

        @Test(dataProvider = "SalesManagerLogin",dataProviderClass = All_DP.class)
        public void verifying_modules_as_sales_manger(String salesManagerLogin) {

        loginBy(salesManagerLogin);

            Sleep.Zzz(1);

            List<String> expected_result=new ArrayList<>(Arrays.asList("Dashboards",
                    "Fleet",
                    "Customers",
                    "Sales",
                    "Activities",
                    "Marketing",
                    "Reports & Segments",
                    "System"));

            Dashboard dashboard=new Dashboard();

            List<WebElement> moduleElements =  dashboard.mainMenuListLarge;
            List<String> actual_result=new ArrayList<>();
            for (WebElement each : moduleElements) {
                actual_result.add(each.getText());
            }

            Assert.assertEquals(actual_result,expected_result);

        }

    @Test(dataProvider = "SalesManagerLogin",dataProviderClass = All_DP.class)
        public void verifying_modules_as_sales_manger_negative_scenario(String salesManagerLogin) {

        loginBy(salesManagerLogin);

        Sleep.Zzz(1);

            List<String> expected_result=new ArrayList<>(Arrays.asList("Dashboards",
                    "Fleet",
                    "Customers",
                    "Activities",
                    "Marketing",
                    "Reports & Segments",
                    "System"));


        Dashboard dashboard=new Dashboard();

        List<WebElement> moduleElements =  dashboard.mainMenuListLarge;
            List<String> actual_result=new ArrayList<>();
            for (WebElement each : moduleElements) {
                actual_result.add(each.getText());
            }

            Assert.assertNotEquals(actual_result,expected_result);

        }

    @Test(dataProvider = "DriverLogin",dataProviderClass = All_DP.class)
        public void verifying_modules_as_drive(String driverLogin){

      loginBy(driverLogin);

        Sleep.Zzz(1);

        List<String> expected_result=new ArrayList<>(Arrays.asList("Fleet",
                    "Customers",
                    "Activities",
                    "System"));

            List<String> actual_result=new ArrayList<>();

        Dashboard dashboard=new Dashboard();

        List<WebElement> allModules =  dashboard.mainMenuListShort;

            for (WebElement each : allModules) {
                actual_result.add(each.getText());
            }

            Assert.assertEquals(actual_result,expected_result);

        }

    @Test(dataProvider = "DriverLogin",dataProviderClass = All_DP.class)
        public void verifying_modules_as_drive_negative_scenario(String  truckDriverUserName){

        loginBy( truckDriverUserName);

        Sleep.Zzz(1);

        List<String> expected_result=new ArrayList<>(Arrays.asList("Fleet",
                    "Custjjkdgsg",
                    "Activities",
                    "System"));

            List<String> actual_result=new ArrayList<>();

        Dashboard dashboard=new Dashboard();

        List<WebElement> allModules =  dashboard.mainMenuListShort;

            for (WebElement each : allModules) {
                actual_result.add(each.getText());
                
            }

            Assert.assertNotEquals(actual_result,expected_result);

        }
    }

