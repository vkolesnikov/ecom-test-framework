package io.ecom.ui.pageobjects.productPage.widgets;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SuccessAddingProductModal {

    public SelenideElement successAddingModal = $x("//h2[text()='Товар успешно добавлен в корзину']//parent::div");

    public SelenideElement continueShoppingButton = successAddingModal.$x(".//*[contains(text(), 'Продолжить')]//parent::button");

}
