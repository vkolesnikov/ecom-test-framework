package io.ecom.ui.pageobjects.productPage;

import com.codeborne.selenide.SelenideElement;
import io.ecom.ui.pageobjects.basePage.BasePage;
import io.ecom.ui.pageobjects.productPage.widgets.MainOrderWidget;
import io.ecom.ui.pageobjects.productPage.widgets.SuccessAddingProductModal;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$x;

@Component
public class ProductPage extends BasePage {

    public MainOrderWidget mainOrderWidget = new MainOrderWidget();

    public SuccessAddingProductModal successAddingProductModal = new SuccessAddingProductModal();

    public SelenideElement productTitle = $x(".//h1");

}
