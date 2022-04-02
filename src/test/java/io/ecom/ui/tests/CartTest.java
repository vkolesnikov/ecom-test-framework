package io.ecom.ui.tests;

import com.codeborne.selenide.Selenide;
import io.ecom.ui.BaseUiTest;
import io.ecom.ui.pageobjects.basePage.widgets.HeaderMenu.HeaderCategory;
import io.ecom.ui.steps.CardSteps;
import io.ecom.ui.steps.CatalogSteps;
import io.ecom.ui.steps.FilterSteps;
import io.ecom.ui.steps.ProductSteps;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

@Test(testName = "Card test", groups = "ui")
public class CartTest extends BaseUiTest {

    private static final String SUBCATEGORY_NAME = "Компьютеры и комплектующие";

    private static final String SUBCATEGORY_ITEM = "Мыши";

    private static final String PRODUCER = "xtrfy";

    private static final String CATEGORY_NAME = "Тип подключения";
    private static final String CATEGORY_ITEM = "беспроводной";

    private static final String PRODUCT_TITLE = "Беспроводная игровая мышь Xtrfy M4 Wireless";

    @Autowired
    private CatalogSteps catalogSteps;

    @Autowired
    private FilterSteps filterSteps;

    @Autowired
    private ProductSteps productSteps;

    @Autowired
    private CardSteps cardSteps;


    @Test(description = "Add mouse to card")
    public void addMouseToCardTest() {
        catalogSteps.openGeneralPage();
        catalogSteps.clickOnHeaderItem(HeaderCategory.ELECTRONICS);
        catalogSteps.clickOnMoreSubcategoryButton(SUBCATEGORY_NAME)
                .clickOnSubcategoryItem(SUBCATEGORY_NAME, SUBCATEGORY_ITEM);
        filterSteps.selectProducer(PRODUCER)
                .selectItemFromCategory(CATEGORY_NAME, CATEGORY_ITEM)
                .openFullProductPage();
        productSteps.checkProductTitle(PRODUCT_TITLE);
        String expectedPrice = productSteps.getProductPrice();
        productSteps.clickOnAddProductButton()
                .clickOnContinueShoppingButton()
                .clickOnOpenCardButton();
        cardSteps.waitCardPageLoading()
                .checkTotalCardPrice(expectedPrice);
    }

    @AfterClass(alwaysRun = true)
    private void clearCookies() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

}
