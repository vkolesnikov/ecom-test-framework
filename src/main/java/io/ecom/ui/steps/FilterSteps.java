package io.ecom.ui.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.ecom.ui.pageobjects.filterPage.FilterPage;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.codeborne.selenide.Selenide.switchTo;

@Service
public class FilterSteps extends GeneralUiSteps {

    @Autowired
    private FilterPage filterPage;

    @Step("Select producer {0}")
    public FilterSteps selectProducer(String producer) {
        filterPage.producerFilter.clickOnVieAllProducersButton();
        filterPage.producerFilter.searchField.setValue(producer);
        filterPage.producerFilter.producersList.filterBy(Condition.text(producer)).shouldHave(CollectionCondition.size(1)).get(0).click();
        return this;
    }

    @Step("Select item {1} in category {0}")
    public FilterSteps selectItemFromCategory(String categoryName, String categoryItem) {
        filterPage.selectFilter(categoryName, categoryItem);
        return this;
    }

    @Step("Open full product page")
    public FilterSteps openFullProductPage() {
        filterPage.searchResultWidget.foundGoods.get(0).click();
        Selenide.sleep(2000);
        switchTo().window(WebDriverRunner.driver().getWebDriver().getWindowHandles().toArray()[1].toString());
        return this;
    }

}
