package com.vytrack.tests.base;

import com.vytrack.pages.CalendarEvent;

import com.vytrack.pages.Dashboard;
import com.vytrack.pages.EventCreate;
import com.vytrack.pages.VehiclePage;
import com.vytrack.utilities.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public abstract class TestBase {

    protected CalendarEvent event;
    protected EventCreate create;
    protected Dashboard dashboard;
    protected VehiclePage vehiclePage;
    @BeforeMethod
    public void setUp() {

        event = new CalendarEvent();
        create = new EventCreate();
        dashboard = new Dashboard();
        vehiclePage = new VehiclePage();


    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

}