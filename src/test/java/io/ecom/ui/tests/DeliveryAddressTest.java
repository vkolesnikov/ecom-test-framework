package io.ecom.ui.tests;

import com.codeborne.selenide.Selenide;
import io.ecom.ui.BaseUiTest;
import io.ecom.ui.steps.GeneralUiSteps;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(testName = "Delivery address test", groups = "ui")
public class DeliveryAddressTest extends BaseUiTest {

    private final String DEFAULT_DELIVERY_ADDRESS = "Москва";

    private final Object[][] DELIVERY_ADDRESSES = new String[][] {
            { "Москва, Пресненская набережная, 4с1", "Пресненская набережная, д. 4с1" },
            { "Москва, улица Покровка, 12с3", "улица Покровка, д. 12с3"},
            { "Москва, улица Щепкина, 61/2с17", "улица Щепкина, д. 61/2с17" }
            };

    private final String NEW_DELIVERY_ADDRESS = "Саратов, Одесская улица, 12А";
    private final String EXPECTED_NEW_DELIVERY_ADDRESS = "Одесская улица, \nд. 12А";

    @Autowired
    private GeneralUiSteps generalUiSteps;


    @Test(testName = "Change delivery address test")
    public void editDeliveryAddressTest() {
        generalUiSteps.openGeneralPage()
                .checkDeliveryAddress(DEFAULT_DELIVERY_ADDRESS)
                .openSelectDeliveryAddressModal()
                .fillNewDeliveryAddress(NEW_DELIVERY_ADDRESS)
                .checkDeliveryAddress(EXPECTED_NEW_DELIVERY_ADDRESS);

        generalUiSteps.openSelectDeliveryAddressModal()
                .checkSelectDeliveryAddresses(EXPECTED_NEW_DELIVERY_ADDRESS)
                .closeSelectAddressModal();
    }

    @Test(dependsOnMethods = "editDeliveryAddressTest", dataProvider = "correctDeliveryAddresses")
    public void multipleDeliveryAddressChange(String filledAddress, String expectedAddress) {
        generalUiSteps.openSelectDeliveryAddressModal()
                .openAddNewAddressModal()
                .fillNewDeliveryAddress(filledAddress)
                .checkDeliveryAddress(expectedAddress)
                .openSelectDeliveryAddressModal()
                .checkSelectDeliveryAddresses(expectedAddress)
                .closeSelectAddressModal();
    }

    @DataProvider(name = "correctDeliveryAddresses")
    private Object[][] correctDeliveryAddresses() {
        return DELIVERY_ADDRESSES;
    }

    @AfterClass(alwaysRun = true)
    private void clearCookies() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

}
