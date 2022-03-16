package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Dashboard {

    public Dashboard() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(css =".nav-multilevel.main-menu")
    public WebElement mainManuBar;

    @FindBy(xpath = "//div[@id='main-menu']//span[contains(text(),'Fleet')][1]")
    public WebElement moduleFleet;

    @FindBy(xpath = "//li[@class='dropdown-menu-single-item first']//span[contains(text(),'Vehicles')]")
    public WebElement moduleFleetVehicle;

    @FindBy(xpath = "//span[.='Vehicles Model']")
    public WebElement vehiclesModelBtn;

    @FindAll({
            @FindBy(linkText = "Vehicles"),
            @FindBy(linkText = "Vehicle Odometers"),
            @FindBy(linkText = "Vehicle Costs"),
            @FindBy(linkText = "Vehicle Contracts"),
            @FindBy(linkText = "Vehicles Fuel Logs"),
            @FindBy(linkText = "Vehicle Services"),
            @FindBy(linkText = "Vehicles Model")
    })
    public List<WebElement> fleetModulesList;



    @FindAll({
            @FindBy(linkText = "Fleet"),
            @FindBy(linkText = "Customers"),
            @FindBy(linkText = "Activities"),
            @FindBy(linkText = "System")})

    public List<WebElement> mainManuListShort;


    @FindAll({
            @FindBy(linkText = "Dashboards"),
            @FindBy(linkText = "Fleet"),
            @FindBy(linkText = "Customers"),
            @FindBy(linkText = "Sales"),
            @FindBy(linkText = "Activities"),
            @FindBy(linkText = "Marketing"),
            @FindBy(linkText = "Reports & Segments"),
            @FindBy(linkText = "System")

    })
    public List<WebElement> mainManuListLarge;

}
