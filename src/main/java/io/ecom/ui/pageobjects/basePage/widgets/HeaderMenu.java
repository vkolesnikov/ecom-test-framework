package io.ecom.ui.pageobjects.basePage.widgets;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HeaderMenu {

    private SelenideElement headerMenu = $("div[data-apiary-widget-name=\"@MarketNode/HeaderTabs\"");

    public SelenideElement changeDeliveryAddress = headerMenu.$x(".//*[@title='Регион']/ancestor::button");

    public SelenideElement cardButton = $("[data-auto='header-cart']");

    public String getDeliveryAddress() {
        return changeDeliveryAddress.getText();
    }

    public void clickOnHeaderCategoryItem(HeaderCategory headerCategory) {
        headerMenu.$x(String.format(".//span[text()='%s']", headerCategory.categoryName)).click();
    }

    public enum HeaderCategory {

        EXPRESS("Экспресс"),
        CHILDREN("Дети"),
        ELECTRONICS("Электроника");

        public final String categoryName;

        HeaderCategory(String categoryName) {
            this.categoryName = categoryName;
        }

    }

}
