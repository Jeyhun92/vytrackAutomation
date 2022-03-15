package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EventCreate {

    public EventCreate(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//iframe[starts-with(@id,'oro_calendar_event_form_description')]")
    public WebElement iframePg;

    @FindBy(tagName = "body")
    public WebElement textBoardInput;
    @FindBy(tagName = "p")
    public WebElement textBoard;
    @FindBy(xpath = "//input[starts-with(@id,'recurrence-repeat')]")
    public WebElement repeatBtn;

}
