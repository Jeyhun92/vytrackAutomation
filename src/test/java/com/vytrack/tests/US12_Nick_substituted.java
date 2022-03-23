package com.vytrack.tests;

import com.vytrack.pages.Accounts;
import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.ExtraUtils.All_DP;
import com.vytrack.utilities.ExtraUtils.HeaderMap;
import com.vytrack.utilities.ExtraUtils.LoginBy;
import com.vytrack.utilities.ExtraUtils.Sleep;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US12_Nick_substituted extends TestBase {

    @Test(dataProvider = "SalesManagerLogin", dataProviderClass = All_DP.class)
    public void verifying_AccountPage(String user) {

        LoginBy.loginPg(user);
        HeaderMap.goToPage(user, "Customers", "Accounts");

        Sleep.bePatient(accounts.managerSelectFilter,10);
        accounts.filterButton.click();

        List<WebElement> managerSelectFilter = accounts.managerFilterBarButtons;

        ArrayList<String> actualAcctFilterBtnList = new ArrayList<>();
        managerSelectFilter.forEach(p -> actualAcctFilterBtnList.add(p.getText().substring(0,p.getText().indexOf(":"))));

        List<String> exceptedFilterBtnList = new ArrayList<>();
        exceptedFilterBtnList.addAll(Arrays.asList("Account Name", "Contact Name", "Contact Email", "Contact Phone","Owner", "Business Unit", "Created At", "Updated At"));

        System.out.println("actualAcctFilterBtnList = " + actualAcctFilterBtnList);
        Assert.assertEquals(actualAcctFilterBtnList,exceptedFilterBtnList);



    }

}
