package io.ecom.ui.pageobjects.filterPage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.ecom.ui.pageobjects.basePage.BasePage;
import io.ecom.ui.pageobjects.filterPage.widgets.ProducerFilter;
import io.ecom.ui.pageobjects.filterPage.widgets.SearchResultWidget;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

@Component
public class FilterPage extends BasePage {

    public ProducerFilter producerFilter = new ProducerFilter();

    public SearchResultWidget searchResultWidget = new SearchResultWidget();

    public SelenideElement categoryTitle = $x("//*[@data-apiary-widget-name=\"@MarketNode/SearchHeadline\"]//h1");

    public ElementsCollection filters = $$("[data-zone-name=\"search-filter\"]");

    public void selectFilter(String categoryName, String categoryItem) {
        for (SelenideElement filter: filters) {
            if (filter.$x(".//*[local-name() = 'legend']").text().equals(categoryName)) {
                for (SelenideElement filterItem: filter.$$x(".//li//span")) {
                    if (filterItem.text().equals(categoryItem)) {
                        filterItem.click();
                        return;
                    }
                }
            }
        }
    }

}
