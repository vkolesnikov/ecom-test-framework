package io.ecom.ui;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;


@ContextConfiguration(classes = GeneralUiConfiguration.class)
public class BaseUiTest extends AbstractTestNGSpringContextTests {

    private final static String windowsChromeDriverPath = "src/test/resources/webdrivers/windows/chromedriver.exe";

    @BeforeSuite(alwaysRun = true)
    private void prepareDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        System.setProperty("webdriver.chrome.driver", windowsChromeDriverPath);
        setWebDriver(new ChromeDriver(chromeOptions));
        WebDriverRunner.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterSuite(alwaysRun = true)
    private void closeDriver() {
        Selenide.closeWebDriver();
    }

}
