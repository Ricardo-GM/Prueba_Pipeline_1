package userinterface;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class SecurePage extends PageObject {

    private static By flashMessage = By.id("flash");
    private static By cardNavigator = By.xpath("//div[@class='card__body']");
    private static By menuButton = By.id("dbaoc-header-button");
    private static By environmentButtonLocator = By.xpath("//button[@class='bx--list-box__field']");
    private static By adminConsoleButton = By.xpath("//a[@href='#/administration/test']");
    private static By cardConsole = By.id("test-DBA_acce-label");

    private static By environmentValueLocator = By.xpath("//li[@data-value='test']");
    private static By inicioButtonLocator = By.linkText("Inicio");

    private static By labelWelcomePortal = By.className("welcome__title");
    public static By getFlashMessage() {
        return flashMessage;
    }
    public static By getCardNavigator() { return cardNavigator; }
    public static By getEnvironmentButtonLocator() {
        return environmentButtonLocator;
    }
    public static By getAdminConsoleButton() { return adminConsoleButton; }
    public static By getMenuButton() { return menuButton; }
    public static By getCardConsole() {
        return cardConsole;
    }
    public static By getEnvironmentValueLocator() {
        return environmentValueLocator;
    }
    public static By getInicioButtonLocator() {
        return inicioButtonLocator;
    }
    public static By getLabelWelcomePortal() {
        return labelWelcomePortal;
    }
}
