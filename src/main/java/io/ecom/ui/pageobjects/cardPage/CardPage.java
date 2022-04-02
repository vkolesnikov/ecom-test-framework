package io.ecom.ui.pageobjects.cardPage;

import io.ecom.ui.pageobjects.basePage.BasePage;
import io.ecom.ui.pageobjects.cardPage.widget.CardTotalPriceWidget;
import org.springframework.stereotype.Component;

@Component
public class CardPage extends BasePage {

    public CardTotalPriceWidget cardTotalPriceWidget = new CardTotalPriceWidget();

}
