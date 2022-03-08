package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class US2_Zeyneb extends TestBase {

    @Test
    public void users_access_the_oronic_documentaion_page() throws InterruptedException {

        VytrackUtils.loginAsDriver();

        Thread.sleep(3000);
        WebElement questionMark = Driver.getDriver().findElement(By.xpath("//i[@title='Get help']"));
        questionMark.click();

        Set<String> allWindowsHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowsHandles) {

            Driver.getDriver().switchTo().window(each);

            if (Driver.getDriver().getCurrentUrl().contains("https://doc.oroinc.com/")){
                break;
            }
        }

        System.out.println("URL is = " + Driver.getDriver().getCurrentUrl() );





        }

    }

/*
As a user, I should be access to the Oroinc Documentation page.(Window handle)

AC #1: users access the Oronic Documentation page by clicking the question icon. The page URL: https://doc.oroinc.com/
 */