package actions.Base;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.selectactions.SelectByValueFromBy;
import net.serenitybdd.screenplay.questions.JavaScript;
import net.serenitybdd.screenplay.targets.SearchableTarget;
import net.serenitybdd.screenplay.ui.Dropdown;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static util.Hooks.driver;

public class SelectValue {


    public static Performable ByIndex(int index, By locator) {
        return SelectFromOptions.byIndex(index).from(locator);
    }

    public static Performable ByValue(String value, By locator) {
        return SelectFromOptions.byValue(value).from(locator);

    }



}
