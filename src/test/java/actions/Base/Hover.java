package actions.Base;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.MoveMouseToBy;
import org.openqa.selenium.By;

public class Hover {

    public static Performable On(By locator) {
        return new MoveMouseToBy(locator);
    }
}
