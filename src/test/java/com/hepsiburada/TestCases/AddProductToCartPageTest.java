package com.hepsiburada.TestCases;

import com.hepsiburada.BaseTest.BaseTest;
import com.hepsiburada.Pages.AddProductToCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductToCartPageTest extends BaseTest {

    AddProductToCartPage addProductToCartPage;
    String product = "nike kadın spor ayakkabı";

    public AddProductToCartPageTest() {
        super();
        addProductToCartPage = new AddProductToCartPage();
    }

    @Test(description = "Kullanıcı sepetine iki farklı satıcıdan ürün ekler.")
    public void addProductToCart() throws InterruptedException {
        Boolean returnValue;
        Boolean returnValue2;
        addProductToCartPage.searchProduct(product);
        addProductToCartPage.selectFirstProduct();
        addProductToCartPage.addProductsToCartFromSeller1();
        addProductToCartPage.addProductsToCartFromSeller2();
        String nameOfSeller1 = null;
        String nameOfSeller2 = null;
        Assert.assertTrue(returnValue = addProductToCartPage.isAddedFirstProduct(nameOfSeller1), "Birinci satıcıdan ürün sepete eklenemedi!");
        if (returnValue == true) {
            logger.info("Birinci satıcıdan ürün sepete eklendi.");
        }
        Assert.assertTrue(returnValue2 = addProductToCartPage.isAddedSecondProduct(nameOfSeller2), "İkinci satıcıdan ürün sepete eklenemedi!");
        if (returnValue2 == true) {
            logger.info("İkinci satıcıdan ürün sepete eklendi.");
        }
    }
}
