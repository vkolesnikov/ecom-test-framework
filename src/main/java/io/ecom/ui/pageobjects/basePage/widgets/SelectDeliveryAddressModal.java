package io.ecom.ui.pageobjects.basePage.widgets;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SelectDeliveryAddressModal {

    private SelenideElement selectDeliveryAddressModal = $("[data-zone-name=\"UserAddresses\"]");

    public ElementsCollection savedAddresses = selectDeliveryAddressModal.$$x(".//li//div/span");

    public SelenideElement addNewDeliveryAddressButton = selectDeliveryAddressModal.$x(".//*[text()=\"Добавить новый адрес\"]");

    public SelenideElement selectDeliveryAddressButton = selectDeliveryAddressModal.$x(".//*[text()=\"Выбрать\"]");

    public SelenideElement closeSelectAddressModalButton = $x("//*[@class=\"_2no4A _2-a6m g0nMW _28sPD\"]/div/div/div/*[local-name() = 'svg']");

    public ArrayList<String> getSavedDeliveryAddresses() {
        ArrayList<String> deliveryAddresses = new ArrayList<>();
        for (SelenideElement savedAddress: savedAddresses) {
            deliveryAddresses.add(savedAddress.innerText());
        }
        return deliveryAddresses;
    }

}
