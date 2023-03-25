package userinterface;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class SecurePage extends PageObject {

    private static By flashMessage = By.id("flash");

    public static By getFlashMessage() {
        return flashMessage;
    }
}
