package io.ecom.ui.utils;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;

public final class AllureAttachmentUtils {

    private static final Logger LOG = LoggerFactory.getLogger(AllureAttachmentUtils.class);

    public static void screenshotForAllure() {
        String attachmentTitle = "Screenshot " + RandomStringUtils.randomAlphabetic(8);
        Allure.addAttachment(attachmentTitle, new ByteArrayInputStream(((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES)));
    }

}
