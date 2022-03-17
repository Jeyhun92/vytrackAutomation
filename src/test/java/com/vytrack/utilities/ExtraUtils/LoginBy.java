package com.vytrack.utilities.ExtraUtils;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;

public class LoginBy {

    public static void loginBy(String username) {
        //go to website
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        // pass username
        // Driver.getDriver().findElement(By.cssSelector("#prependedInput"));
        Driver.getDriver().findElement(By.id("prependedInput")).sendKeys(username);
        //pass password
        Driver.getDriver().findElement(By.cssSelector("#prependedInput2")).sendKeys(ConfigurationReader.getProperty("driver_password"));
        //click login button
        Driver.getDriver().findElement(By.tagName("button")).click();
    }

    public static void loginPg(String username) {
        LoginPage loginpage = new LoginPage();

        //go to website
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        // pass username
        // Driver.getDriver().findElement(By.cssSelector("#prependedInput"));
        loginpage.loginInput.sendKeys(username);  //user44
        //pass password
        loginpage.passwordInput.sendKeys(ConfigurationReader.getProperty("driver_password"));
        //click login button
        loginpage.loginBtn.click();
    }


}
