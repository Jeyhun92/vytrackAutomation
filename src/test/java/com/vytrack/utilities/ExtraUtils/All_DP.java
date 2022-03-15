package com.vytrack.utilities.ExtraUtils;

import com.vytrack.utilities.ConfigurationReader;
import org.testng.annotations.DataProvider;

public class All_DP {

    String driver1 = ConfigurationReader.getProperty("driver_username");
    String driver2 = ConfigurationReader.getProperty("driver_username2");
    String sales1 = ConfigurationReader.getProperty("sales_manager_username");
    String sales2 = ConfigurationReader.getProperty("sales_manager_username2");
    String store1 = ConfigurationReader.getProperty("store_manager_username");
    String store2 = ConfigurationReader.getProperty("store_manager_username2");


    @DataProvider(name = "DriverLogin")
    Object[][] TruckDriver() {

        return new Object[][]{
                {driver1},
                {driver2}
        };

    }

    @DataProvider(name = "SalesManagerLogin")
    Object[][] SalesManager() {

        return new Object[][]{
                {sales1},
                {sales2}

        };

    }

    @DataProvider(name = "StoreManagerLogin")
    Object[][] StoreManager() {
        return new Object[][]{
                {store1},
                {store2}

        };
    }

    @DataProvider(name = "LoginAll")
    Object[][] loginCredentials() {

        return new Object[][]{
                {driver1},
                {driver2},
                {sales1},
                {sales2},
                {store1},
                {store2}
        };

    }

    @DataProvider(name = "SM")
    Object[][] SManagers() {

        return new Object[][]{

                {sales1},
                {sales2},
                {store1},
                {store2}
        };

    }
}
