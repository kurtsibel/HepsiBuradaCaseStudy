package com.hepsiburada.Pages;

import com.hepsiburada.BaseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest {

    @FindBy(id = "shoppingCart")
    public WebElement btnShoppingCart;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isHomePageDisplayed() {
        if (btnShoppingCart.isDisplayed()) {
            logger.info("Ana Sayfa basari ile acildi.");
            return true;
        } else {
            logger.info("Ana Sayfa acilma islemi BASARISIZ!");
            return false;
        }
    }
}
