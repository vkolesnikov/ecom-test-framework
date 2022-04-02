package io.ecom.ui.pageobjects.basePage;
import io.ecom.ui.pageobjects.basePage.widgets.EditDeliveryAddressModal;
import io.ecom.ui.pageobjects.basePage.widgets.HeaderMenu;
import io.ecom.ui.pageobjects.basePage.widgets.SelectDeliveryAddressModal;
import org.springframework.stereotype.Component;

@Component
public class BasePage {

    public HeaderMenu headerMenu = new HeaderMenu();

    public EditDeliveryAddressModal editDeliveryAddressModal = new EditDeliveryAddressModal();

    public SelectDeliveryAddressModal selectDeliveryAddressModal = new SelectDeliveryAddressModal();

    protected String PAGE_URL = "";

    public String getPageUrl() {
        return PAGE_URL;
    }

}
