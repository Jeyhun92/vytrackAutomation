package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VehiclePage {
    public VehiclePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@tabindex='-1']")
    public List<WebElement> randomCheckBox;

    @FindBy(xpath = "//button[@class='btn btn-default btn-small dropdown-toggle']/input[@type='checkbox']" )
    public WebElement checkboxAll;

}
