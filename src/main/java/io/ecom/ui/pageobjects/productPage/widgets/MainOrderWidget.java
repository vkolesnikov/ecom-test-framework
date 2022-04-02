package io.ecom.ui.pageobjects.productPage.widgets;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainOrderWidget {

    public SelenideElement mainOrderWidget = $("[data-apiary-widget-id*='mainDO']");

    public SelenideElement mainOrderPrice = mainOrderWidget.$x(".//span[contains(text(), '₽')]//preceding-sibling::span");

    public SelenideElement addToCardButton = mainOrderWidget.$x(".//span[contains(text(), 'Добавить')]");

}
