package com.hepsiburada.Pages;

import com.hepsiburada.BaseTest.BaseTest;
import com.hepsiburada.BaseTest.CommonFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductToCartPage extends BaseTest {

    @FindBy(xpath = "//input[@placeholder='Ürün, kategori veya marka ara']")
    private WebElement searchField;

    @FindBy(xpath = "//span[contains(text(),'ARA')]")
    private WebElement btnSearch;

    @FindBy(xpath = "//span[contains(text(),'Nike Air Force Günlük Spor Ayakkabı')]")
    private WebElement btnProduct;

    @FindBy(xpath = "//a[@href='/magaza/mastertradıng']")
    private WebElement txtNameOfSeller1;

    @FindBy(xpath = "//a[@href='/magaza/novasports']")
    private WebElement txtNameOfSeller2;

    @FindBy(xpath = "//html/body/div[2]/main/div[3]/section[1]/div[4]/div/div[4]/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[3]/div/form/button")
    private WebElement btnAddToCart1;

    @FindBy(xpath = "//html/body/div[2]/main/div[3]/section[1]/div[4]/div/div[4]/div[2]/div[2]/div/div[2]/table/tbody/tr[2]/td[3]/div/form/button")
    private WebElement btnAddToCart2;

    @FindBy(xpath = "//*[@id='AddToCart_296399a0-1829-4f98-3aaf-a22f1a92c56c']/div/div/div/div/div/h1/a")
    private WebElement btnCross;

    @FindBy(xpath = "//button[@type='Sepete git']")
    private WebElement btnGoToCart;

    public void searchProduct(String product) throws InterruptedException {

        //Arama alanı null geliyor bu sebeple string yazamıyor!//
        CommonFunctions.refreshPage();
        searchField.click();
        searchField.sendKeys(product);
        btnSearch.click();
    }

    public void selectFirstProduct() {
        btnProduct.click();
    }

    public String addProductsToCartFromSeller1() {

        String nameOfSeller1 = txtNameOfSeller1.getText();
        System.out.println("İlk satıcının adı:" + txtNameOfSeller1);
        btnAddToCart1.click();
        btnCross.click();
        return nameOfSeller1;
    }

    public String addProductsToCartFromSeller2() {
        String nameOfSeller2 = txtNameOfSeller2.getText();
        System.out.println("İkinci satıcının adı:" + txtNameOfSeller2);
        btnAddToCart2.click();
        btnGoToCart.click();
        return nameOfSeller2;
    }

    public boolean isAddedFirstProduct(String nameOfSeller1) {
        if (nameOfSeller1.equals("mastertradıng")) {
            logger.info("Birinci satıcıdan ürün sepete başarı ile eklendi.");
            return true;
        } else {
            logger.info("Birinci satıcıdan ürünü sepete ekleme BAŞARISIZ!");
            return false;
        }
    }

    public boolean isAddedSecondProduct(String nameOfSeller2) {
        if (nameOfSeller2.equals("novasports")) {
            logger.info("İkinci satıcıdan ürün sepete başarı ile eklendi.");
            return true;
        } else {
            logger.info("İkinci satıcıdan ürünü sepete ekleme BAŞARISIZ!");
            return false;
        }
    }
}
