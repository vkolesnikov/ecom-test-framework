package io.ecom.ui.steps;

import com.codeborne.selenide.*;
import io.ecom.ui.pageobjects.basePage.BasePage;
import io.ecom.ui.pageobjects.basePage.widgets.HeaderMenu.HeaderCategory;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.sleep;

@Service
public class GeneralUiSteps {

    @Autowired
    private BasePage basePage;

    @Value("${yandex.market.url}")
    private String mainDomain;

    @Step("Open general page")
    public GeneralUiSteps openGeneralPage() {
        Selenide.open(mainDomain + basePage.getPageUrl());
        return this;
    }

    @Step("Check delivery address equals {0}")
    public GeneralUiSteps checkDeliveryAddress(String expectedDeliveryAddress) {
        basePage.headerMenu.changeDeliveryAddress.shouldHave(Condition.text(expectedDeliveryAddress), Duration.ofMillis(5000));
        return this;
    }

    @Step("Open address selector modal")
    public GeneralUiSteps openSelectDeliveryAddressModal() {
        sleep(1000);
        basePage.headerMenu.changeDeliveryAddress.click();
        return this;
    }

    @Step("Fill new delivery address: {0}")
    public GeneralUiSteps fillNewDeliveryAddress(String deliveryAddress) {
        basePage.editDeliveryAddressModal.inputAddressField.setValue("");
        basePage.editDeliveryAddressModal.inputAddressField.append(deliveryAddress);
        sleep(1000);
        basePage.editDeliveryAddressModal.addressesSelector.shouldBe(Condition.text(deliveryAddress.substring(deliveryAddress.indexOf(",") + 2)));
        basePage.editDeliveryAddressModal.addressesSelector.click();
        sleep(500);
        basePage.editDeliveryAddressModal.submitAddressButton.click();
        return this;
    }

    @Step("Open add new delivery address modal")
    public GeneralUiSteps openAddNewAddressModal() {
        basePage.selectDeliveryAddressModal.addNewDeliveryAddressButton.click();
        return this;
    }

    @Step("Close select address modal")
    public GeneralUiSteps closeSelectAddressModal() {
        basePage.selectDeliveryAddressModal.closeSelectAddressModalButton.click();
        return this;
    }

    @Step("Check select delivery addresses contains {0}")
    public GeneralUiSteps checkSelectDeliveryAddresses(String expectedDeliveryAddress) {
        basePage.selectDeliveryAddressModal.savedAddresses.filterBy(Condition.text(expectedDeliveryAddress)).shouldHave(CollectionCondition.size(1));
        return this;
    }

    @Step("Click on header item: {0}")
    public GeneralUiSteps clickOnHeaderItem(HeaderCategory headerCategory) {
        basePage.headerMenu.clickOnHeaderCategoryItem(headerCategory);
        return this;
    }

    @Step("Click on open card button")
    public GeneralUiSteps clickOnOpenCardButton() {
        basePage.headerMenu.cardButton.click();
        return this;
    }


    protected void editAttribute(SelenideElement element, String attributeName, String attributeValue) {
        executeJavaScript("arguments[0].setAttribute(arguments[1], arguments[2]);",
                element, attributeName, attributeValue);
    }

    protected String plainDigit(String text) {
        return text.trim().replaceAll("[^\\d.]", "");
    }

}
