package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.ExtraUtils.All_DP;
import com.vytrack.utilities.VytrackUtils;
import org.testng.annotations.Test;
import com.vytrack.utilities.ExtraUtils.All_DP;
import com.vytrack.utilities.ExtraUtils.Sleep;
import static com.vytrack.utilities.ExtraUtils.LoginBy.loginBy;

public class US143_Nick extends TestBase {

    @Test(dataProvider = "StoreManagerLogin", dataProviderClass = All_DP.class)
    public void vehicle_cost_page_test(){

       VytrackUtils.loginAsStoreManger();


    }


}
