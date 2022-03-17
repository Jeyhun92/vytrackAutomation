package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.ExtraUtils.All_DP;
import com.vytrack.utilities.ExtraUtils.HeaderMap;
import com.vytrack.utilities.ExtraUtils.LoginBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class US12_Nick_substituted extends TestBase {

    /*@Test(dataProvider = "SalesManagerLogin",dataProviderClass = All_DP.class)
    public void verifying_AccountPage(String user) {

        LoginBy.loginPg(user);
        HeaderMap.goToPage(user,"Customers","Accounts");

        Select select = new Select(accounts.managerSelectFilter);
        List<WebElement> list = select.getOptions();

        ArrayList<String> actualAcctFilterBtnList = new ArrayList<>();
        list.forEach(p->actualAcctFilterBtnList.add(p.getText()));



        System.out.println("actualAcctFilterBtnList = " + actualAcctFilterBtnList);


    }*/

}
