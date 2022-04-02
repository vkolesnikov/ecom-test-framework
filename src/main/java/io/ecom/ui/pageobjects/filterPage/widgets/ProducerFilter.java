package io.ecom.ui.pageobjects.filterPage.widgets;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProducerFilter {

    private SelenideElement producerFilterModal = $x("//*[local-name() = 'legend'][text()=\"Производитель\"]//parent::fieldset");

    public SelenideElement vieAllProducersButton = producerFilterModal.$x(".//button[text()=\"Показать всё\"]");

    public SelenideElement searchField = producerFilterModal.$("[name=\"Поле поиска\"]");

    public ElementsCollection producersList = producerFilterModal.$$x(".//li//span");

    public void clickOnVieAllProducersButton() {
        vieAllProducersButton.scrollIntoView(false).click();
    }
}
