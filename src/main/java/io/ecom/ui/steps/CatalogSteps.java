package io.ecom.ui.steps;

import io.ecom.ui.pageobjects.catalogPage.CatalogPage;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CatalogSteps extends GeneralUiSteps {

    @Autowired
    private CatalogPage catalogPage;

    @Step("Click on more button of subcategory: {0}")
    public CatalogSteps clickOnMoreSubcategoryButton(String subcategoryName) {
        catalogPage.clickOnMoreSubcategoryItem(subcategoryName);
        return this;
    }

    @Step("Click on subcategory {0} item {1}")
    public CatalogSteps clickOnSubcategoryItem(String subcategoryName, String subcategoryItem) {
        catalogPage.clickOnSubcategoryItem(subcategoryName, subcategoryItem);
        return this;
    }

}
