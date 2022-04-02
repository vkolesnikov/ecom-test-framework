package io.ecom.ui.steps;

import com.codeborne.selenide.Condition;
import io.ecom.ui.pageobjects.productPage.ProductPage;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductSteps extends GeneralUiSteps {

    @Autowired
    private ProductPage productPage;

    @Step("Check title of product is: {0}")
    public ProductSteps checkProductTitle(String expectedProductTitle) {
        productPage.productTitle.shouldHave(Condition.text(expectedProductTitle));
        return this;
    }

    public String getProductPrice() {
        return productPage.mainOrderWidget.mainOrderPrice.text().replaceAll(" ", "");
    }

    @Step("Click on add product to card button")
    public ProductSteps clickOnAddProductButton() {
        productPage.mainOrderWidget.addToCardButton.click();
        return this;
    }

    @Step("Close successes product adding modal")
    public ProductSteps clickOnContinueShoppingButton() {
        productPage.successAddingProductModal.continueShoppingButton.click();
        return this;
    }

}
