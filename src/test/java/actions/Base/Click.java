package actions.Base;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.ClickOnBy;
import net.serenitybdd.screenplay.actions.ClickOnElement;
import org.openqa.selenium.By;

public class Click {
    public static Performable On(By locator) {

        return net.serenitybdd.screenplay.actions.Click.on(locator);
    }


}
