package io.ecom.ui.pageobjects.catalogPage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.ecom.ui.pageobjects.basePage.BasePage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Component
public class CatalogPage extends BasePage {

    public SelenideElement categoryName = $x("//div[data-apiary-widget-name=\"@MarketNode/CatalogHeader\"]//h1");

    private SelenideElement navigationTree = $("[data-apiary-widget-name=\"@MarketNode/NavigationTree\"]");

    public ElementsCollection subcategoriesLists = navigationTree.findAll(new By.ByClassName("_1YdrM"));

    public void clickOnSubcategoryTitle(String subcategoryName) {
        for (SelenideElement subcategoryList: subcategoriesLists) {
            SelenideElement subcategoryTitle = subcategoryList.$("[class='egKyN _2jA_3 _2EJs7']");
            if (subcategoryTitle.text().equals(subcategoryName)) {
                subcategoryTitle.click();
            }
        }
    }

    public void clickOnMoreSubcategoryItem(String subcategoryName) {
        for (SelenideElement subcategoryList: subcategoriesLists) {
            SelenideElement subcategoryTitle = subcategoryList.$("[class='egKyN _2jA_3 _2EJs7']");
            if (subcategoryTitle.text().equals(subcategoryName)) {
                subcategoryList.$x(".//*[text()='Ещё']").scrollIntoView(false).click();
                return;
            }
        }
    }

    public void clickOnSubcategoryItem(String subcategoryName, String subcategoryItem) {
        for (SelenideElement subcategoryList: subcategoriesLists) {
            SelenideElement subcategoryTitle = subcategoryList.$("[class='egKyN _2jA_3 _2EJs7']");
            if (subcategoryTitle.text().equals(subcategoryName)) {
                subcategoryList.$x(String.format(".//*[text()='%s']", subcategoryItem)).scrollIntoView(false).click();
                return;
            }
        }
    }

}
