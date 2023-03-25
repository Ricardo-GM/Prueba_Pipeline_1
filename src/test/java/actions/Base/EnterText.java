package actions.Base;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import org.junit.validator.PublicClassValidator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class  EnterText {
    public static Performable On(By locator, String text) {
        return Enter.theValue(text).into(locator);
    }

    public static Performable Onn(By locator, String text) {
        return SendKeys.of(text).into(locator);
    }

}
