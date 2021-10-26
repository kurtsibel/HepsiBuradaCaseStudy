package com.hepsiburada.TestCases;

import com.hepsiburada.BaseTest.BaseTest;
import com.hepsiburada.Pages.LogoutPage;
import org.testng.annotations.Test;

public class LogoutPageTest extends BaseTest {

    LogoutPage logoutPage;

    public LogoutPageTest() {
        super();
        logoutPage = new LogoutPage();
    }

    @Test(description = "Kullanıcı hesabından çıkış yapar.")
    public void logOut() {
        logoutPage.clickProfileButton();
        logoutPage.clickLogoutButton();
        logger.info("Kullanıcı hesabından çıkış yaptı.");
    }
}