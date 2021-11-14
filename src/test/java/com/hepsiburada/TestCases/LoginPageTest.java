package com.hepsiburada.TestCases;

import com.hepsiburada.BaseTest.BaseTest;
import com.hepsiburada.Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginPageTest extends BaseTest {

    LoginPage loginPage;

    public LoginPageTest() {
        super();
        loginPage = new LoginPage();
    }

    @Test(description = "Kullanıcı bilgileri ile giriş yapılır.")
    public void userLogin() throws InterruptedException {

        boolean returnValue;
        loginPage.clickLoginButtonInHomePage();
        Thread.sleep(2000);
        loginPage.clickLoginLink();
        Thread.sleep(2000);
        loginPage.enterEmail(properties.getProperty("kullaniciEmail"));
        loginPage.enterPassword(properties.getProperty("kullaniciSifre"));
        loginPage.clickLoginButton();
        Thread.sleep(2000);
        Assert.assertTrue(returnValue= loginPage.isEnteredToAccount(), "Kullanıcı hesabına giriş yapılamadı.");
        if(returnValue ==true){
            logger.info("Kullanıcı kendi hesabına giriş yaptı.");
        }
    }
}


