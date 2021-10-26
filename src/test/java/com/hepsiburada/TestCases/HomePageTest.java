package com.hepsiburada.TestCases;

import com.hepsiburada.BaseTest.BaseTest;
import com.hepsiburada.Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    HomePage homePage;

    public HomePageTest() {
        initialize();
        homePage=new HomePage();
    }
    @Test(description = "Hepsi Burada ana sayfasına giriş işlemi doğrulanır.")
    public void verifyHomePageOpened(){
        Assert.assertTrue(homePage.isHomePageDisplayed(),"Ana Sayfa Yüklenemedi!");
    }
}
