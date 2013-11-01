package com.dianping.ba.crm.Mobile;

import com.salesforce.androidsdk.ui.sfhybrid.SalesforceDroidGapActivity;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Dozer
 * Date: 13-8-2
 * Time: 下午7:47
 * To change this template use File | Settings | File Templates.
 */
public class CrmSalesforceDroidGapActivity extends SalesforceDroidGapActivity {
    public static long startTime;
    public static String loginType;
    private static boolean userLogin;

    @Override
    protected void onResumeNotLoggedIn() {
        loginType = "login";
        startTime = new Date().getTime();
        userLogin = true;
        super.onResumeNotLoggedIn();
    }

    @Override
    protected void onResumeLoggedInNotLoaded() {
        if (userLogin) {
            userLogin = false;
        } else {
            loginType = "autoLogin";
            startTime = new Date().getTime();
        }
        super.onResumeLoggedInNotLoaded();
    }
}
