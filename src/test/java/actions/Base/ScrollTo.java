package actions.Base;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class ScrollTo implements Performable {
    private final By locator;

    public ScrollTo(By locator) {
        this.locator = locator;
    }

    public static ScrollTo element(By locator) {
        return new ScrollTo(locator);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElementFacade element = Target.the("scroll-to-element").located(locator).resolveFor(actor);
        actor.attemptsTo(Scroll.to(element));
    }

}