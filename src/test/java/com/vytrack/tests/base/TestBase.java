package com.vytrack.tests.base;

import com.vytrack.pages.*;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public abstract class TestBase {

    protected CalendarEvent event;
    protected EventCreate create;
    protected Dashboard dashboard;
    protected VehiclePage vehiclePage;
    protected Accounts accounts;

    @BeforeMethod
    public void setUp() {

        event = new CalendarEvent();
        create = new EventCreate();
        dashboard = new Dashboard();
        vehiclePage = new VehiclePage();
        accounts = new Accounts();

    }

  @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

}