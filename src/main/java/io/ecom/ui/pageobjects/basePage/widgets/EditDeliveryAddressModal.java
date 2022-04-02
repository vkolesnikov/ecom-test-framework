package io.ecom.ui.pageobjects.basePage.widgets;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class EditDeliveryAddressModal {

    public SelenideElement editDeliveryAddressModal = $("[data-zone-name=\"AddressMapEdit\"]");

    public SelenideElement inputAddressField = editDeliveryAddressModal.$x(".//label[text()=\"Населённый пункт, улица, дом\"]/following-sibling ::input");

    public SelenideElement submitAddressButton = editDeliveryAddressModal.$x(".//span[text()=\"Привезти сюда\"]");

    public SelenideElement addressesSelector = editDeliveryAddressModal.$x(".//*[@id='react-autowhatever-address']/ul/li[1]");

}
