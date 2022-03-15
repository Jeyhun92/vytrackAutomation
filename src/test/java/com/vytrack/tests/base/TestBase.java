package com.vytrack.tests.base;

import com.vytrack.pages.CalendarEvent;

import com.vytrack.pages.Dashboard;
import com.vytrack.pages.EventCreate;
import com.vytrack.utilities.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public abstract class TestBase {

    protected CalendarEvent event;
    protected EventCreate create;
    protected Dashboard dashboard;
    @BeforeMethod
    public void setUp() {

        event = new CalendarEvent();
        create = new EventCreate();
        dashboard = new Dashboard();


    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

}