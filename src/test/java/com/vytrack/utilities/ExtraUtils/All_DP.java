package com.vytrack.utilities.ExtraUtils;

import org.testng.annotations.DataProvider;

public class All_DP {
    @DataProvider(name = "DriverLogin")
    Object[][] TruckDriver() {

        return new Object[][]{
                {"user44"},
                {"user49"}
        };

    }

    @DataProvider(name = "SalesManagerLogin")
    Object[][] SalesManager() {

        return new Object[][]{
                {"salesmanager133"},
                {"salesmanager136"}

        };

    }

    @DataProvider(name = "StoreManagerLogin")
    Object[][] StoreManager() {
        return new Object[][]{
                {"storemanager75"},
                {"storemanager78"}

        };
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
}
