package com.vytrack.utilities.ExtraUtils;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.vytrack.utilities.Driver.getDriver;

public class HeaderMap {

    public static void goToPage(int headIndex, String subName){

        getDriver().findElement(By.xpath("(//div[@id='main-menu']/ul/li)["+headIndex+"]")).click();
        getDriver().findElement(By.linkText(subName)).click();
    }
    public static void goToPage(String head, String subName){

        getDriver().findElement(By.linkText(head)).click();
        getDriver().findElement(By.linkText(subName)).click();
    }







}
