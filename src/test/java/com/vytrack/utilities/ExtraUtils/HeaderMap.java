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

    public static void goToPage(String dropDownName){
        ArrayList<String> headerLists = new ArrayList<>();

        Driver.getDriver().findElements(By.xpath("//div[@id='main-menu']/ul/li")).forEach(p->headerLists.add(p.getText()));

        if(headerLists.size()>4){
        getDriver().findElement(By.xpath("(//div[@id='main-menu']/ul/li)[5]")).click();
        getDriver().findElement(By.linkText(dropDownName)).click();}
        else{getDriver().findElement(By.xpath("(//div[@id='main-menu']/ul/li)[3]")).click();
            getDriver().findElement(By.linkText(dropDownName)).click();

        }


    }


}
