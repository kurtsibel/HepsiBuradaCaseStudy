package com.hepsiburada.Pages;

import com.hepsiburada.BaseTest.BaseTest;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {


    @FindBy(id = "myAccount")
    private WebElement btnLoginInHomePage;

    @FindBy(id = "login")
    private WebElement linkLogin;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement userName;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement password;

    @FindBy(id = "btnLogin")
    private WebElement btnLogin;

    @FindBy(xpath = "//span[contains(text(),'Hesabım')]")
    private WebElement btnMyAccount;


    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickLoginButtonInHomePage(){
        btnLoginInHomePage.click();
    }
    public void clickLoginLink(){
        linkLogin.click();
    }

    public void enterEmail(String mail) {
        userName.sendKeys(mail);
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    public void clickLoginButton() {
        btnLogin.click();
    }

    public Boolean isEnteredToAccount() throws InterruptedException {

       Thread.sleep(2000);
       String receivedValue = btnMyAccount.getText();
       System.out.println("Çekilen Değer:" + receivedValue);
       if (receivedValue.equals("Hesabım")){
           logger.info("Kullanıcı başarılı bir şekilde hesabına giriş yaptı.");
           return true;
       }
       else {
           logger.info("Kullanıcının hesabına girişi BAŞARISIZ!");
           return false;
       }
    }
}
