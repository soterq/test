package features.steps;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Given;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;
import pom.web.Client;
import pom.web.pages.LoginPage;

public class BaseSteps {
    @Managed(uniqueSession = true)
    private WebDriver webDriver;

    private Client client = new Client();

    public static LoginPage loginPage;

    @Given("Navigate to Login page")
    public void navigateToLoginPage() {
        if (webDriver == null) {
            throw new IllegalStateException("WebDriver not initialized");
        }
        String driver = ((WebDriverFacade) webDriver).getDriverName();
        loginPage = client.setConfig(driver, 15000).open().getLoginPage();
        webDriver = WebDriverRunner.getAndCheckWebDriver();
    }
}
