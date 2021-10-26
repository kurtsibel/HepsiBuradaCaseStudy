package com.hepsiburada.Pages;

import com.hepsiburada.BaseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BaseTest {

    @FindBy(xpath = "//*[@id='Header_ee87ca40-31e8-4727-4163-abe92f861d61']/div/div/div[4]/div[2]/div/div[1]/span")
    private WebElement btnProfile;

    @FindBy(xpath = "//*[@id='Header_ee87ca40-31e8-4727-4163-abe92f861d61']/div/div/div[4]/div[2]/div/div[2]/div[2]/ul/li[2]/a")
    private WebElement btnLogout;

    public void clickProfileButton() {
        btnProfile.click();
    }

    public void clickLogoutButton() {
        btnLogout.click();
    }
}
