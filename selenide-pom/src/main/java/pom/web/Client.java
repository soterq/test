package pom.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import pom.logging.LogLevel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
//import pom.web.pages.HomePage;
//import pom.web.pages.LoginPage;

public class Client {
    private final Logger LOGGER = LogManager.getLogger(Client.class);

    private static final String URL = "http://demowebshop.tricentis.com/login";

//    private LoginPage loginPage;

//    public Client open() {
//        loginPage = Selenide.open(URL, LoginPage.class);
//        LOGGER.log(LogLevel.STEP, String.format("Open Login Page: '%s'", URL));
//        return this;
//    }

    public Client setConfig(String browser, int timeout) {
        LOGGER.log(LogLevel.INFO, String.format("BROWSER: '%s', TIMEOUT: '%d'", browser, timeout));

        DesiredCapabilities capabilities;
        switch (browser) {
            case "firefox":
                capabilities = DesiredCapabilities.firefox();
                break;
            case "chrome":
                capabilities = DesiredCapabilities.chrome();
                break;
            default:
                throw new IllegalStateException(String.format("Undefined browser type: '%s' -> [chrome, firefox]", browser));
        }

        capabilities.setAcceptInsecureCerts(true);

//        Configuration.baseUrl = URL;
        Configuration.browser = browser;// Browsers.CHROME;
        Configuration.browserCapabilities = capabilities;
        Configuration.pageLoadStrategy = "eager"; //return after DOMContentLoaded fires
        Configuration.timeout = timeout; // milliseconds
        Configuration.pollingInterval = 200;
        Configuration.startMaximized = true;
        Configuration.savePageSource = false;
        Configuration.screenshots = true;

        return this;
    }

//    private SelenideConfig getConfig(String browser, int timeout) {
//        DesiredCapabilities capabilities;
//        switch (browser) {
//            case "firefox":
//                capabilities = DesiredCapabilities.firefox();
//                break;
//            case "chrome":
//                capabilities = DesiredCapabilities.chrome();
//                break;
//            default:
//                throw new IllegalStateException(String.format("Undefined browser type: '%s' -> [chrome, firefox]", browser));
//        }
//        capabilities.setAcceptInsecureCerts(true);
//
//        SelenideConfig config = new SelenideConfig();
//        config.browser(browser);
//        config.browserCapabilities(capabilities);
//        config.pageLoadStrategy("eager");
//        config.timeout(timeout);
//        config.startMaximized(true);
//        config.savePageSource(false);
//        config.screenshots(false);
//        config.clickViaJs(true);
//
//        return config;
//    }

    public void close() {
        Selenide.closeWebDriver();
    }

//    public HomePage login(String username, String password) {
//        LOGGER.log(LogLevel.STEP, String.format("Login As: username='%s', password='%s'", username, password));
//        return loginPage.loginAsRegistered(username, password);
//    }
//
//    public LoginPage getLoginPage() {
//        return loginPage;
//    }
}
