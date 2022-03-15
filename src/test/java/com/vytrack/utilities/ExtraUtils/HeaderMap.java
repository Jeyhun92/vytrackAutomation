package com.vytrack.utilities.ExtraUtils;

import com.vytrack.pages.Dashboard;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

import static com.vytrack.utilities.Driver.getDriver;

public class HeaderMap {

    public static void goToPage(int headIndex, String subName) {

        getDriver().findElement(By.xpath("(//div[@id='main-menu']/ul/li)[" + headIndex + "]")).click();
        getDriver().findElement(By.linkText(subName)).click();
    }

    public static void goToPage(String user, String head, String subName) {

        Actions actions = new Actions(Driver.getDriver());
        Dashboard dashboard = new Dashboard();

        if (user.equals(ConfigurationReader.getProperty("driver_username"))||
                user.equals(ConfigurationReader.getProperty("driver_username2"))) {


            for (WebElement headLabel : dashboard.mainManuListShort) {
                if (headLabel.getText().contains(head)) {
                    actions.click(headLabel).perform();
                }
                    }
                } else {
            for (WebElement headLabel2 : dashboard.mainManuListLarge) {
                if (headLabel2.getText().contains(head)) {
                    actions.click(headLabel2).perform();

                }
            }
        }

        getDriver().findElement(By.linkText(subName)).click();
    }

    public static void goToPage(String head, String subName) {
        getDriver().findElement(By.linkText(head)).click();
        getDriver().findElement(By.linkText(subName)).click();
    }


}

