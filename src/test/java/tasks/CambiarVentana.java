package tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import java.util.Set;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CambiarVentana implements Task {

    public static CambiarVentana a(String tituloVentana) {
        return instrumented(CambiarVentana.class, tituloVentana);
    }

    private String tituloVentana;

    public CambiarVentana(String tituloVentana) {
        this.tituloVentana = tituloVentana;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        String currentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
                if (driver.getTitle().equals(tituloVentana)) {
                    return;
                }
            }
        }
    }
}

