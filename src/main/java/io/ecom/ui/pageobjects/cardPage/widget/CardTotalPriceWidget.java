package io.ecom.ui.pageobjects.cardPage.widget;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CardTotalPriceWidget {

    public SelenideElement cardTotalPriceWidget = $("[data-apiary-widget-name*=\"CartTotalPrice\"]");

    public SelenideElement cardFinalPrice = cardTotalPriceWidget.$x(".//*[text()='Итого']//following-sibling::span/span");

}
