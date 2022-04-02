package io.ecom.ui.steps;

import com.codeborne.selenide.Condition;
import io.ecom.ui.pageobjects.cardPage.CardPage;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

@Service
public class CardSteps extends GeneralUiSteps {

    private static final String RUBLE_SYMBOL = "₽";

    @Autowired
    private CardPage cardPage;

    public CardSteps waitCardPageLoading() {
        cardPage.cardTotalPriceWidget.cardTotalPriceWidget.should(Condition.visible, Duration.ofMillis(10000));
        return this;
    }

    @Step("Check total price card equals {0}")
    public CardSteps checkTotalCardPrice(String expectedPrice) {
        assertThat(plainDigit(cardPage.cardTotalPriceWidget.cardFinalPrice.text())).isEqualTo(plainDigit(expectedPrice));
        return this;
    }

}
