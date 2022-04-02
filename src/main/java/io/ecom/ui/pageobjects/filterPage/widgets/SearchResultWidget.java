package io.ecom.ui.pageobjects.filterPage.widgets;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SearchResultWidget {

    private SelenideElement searchResultWidget = $("[data-node-name=\"SearchResults\"]");

    public ElementsCollection foundGoods = searchResultWidget.$$x(".//article//span[@data-tid='ce80a508']");

}
