package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Accounts {
    public Accounts(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//select[@data-action='add-filter-select']")
    public WebElement managerSelectFilter;

    @FindBy(xpath = "//div[@class='filter-item oro-drop']")
    public List<WebElement> managerFilterBarButtons;

    @FindBy(css = "a[title='Filters']")
    public WebElement filterButton;


}
