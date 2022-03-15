package com.vytrack.utilities.ExtraUtils;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Sleep {

    public static void Zzz(int snooze) {

        try {
            Thread.sleep(snooze * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void bePatient(WebElement webElement, int patienceLevel) {
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), patienceLevel);
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

}
