package actions.Base;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.DoubleClick;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Hooks;

import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class WaitUntil {

    public static Performable ElementVisible(By localizador) {
        Target elemento = Target.the("elemento").located(localizador);
        return net.serenitybdd.screenplay.waits.WaitUntil.the(elemento, isVisible());
    }

    public static Performable ElementNotVisible(By localizador) {
        Target elemento = Target.the("elementoNoVisible").located(localizador);
        return net.serenitybdd.screenplay.waits.WaitUntil.the(elemento, isNotPresent());
    }

    public static Performable ElementInteractable(By localizador) {
        Target elemento = Target.the("elemento").located(localizador);
        return net.serenitybdd.screenplay.waits.WaitUntil.the(elemento, isClickable()).forNoMoreThan(Duration.ofSeconds(10000));
    }






}
