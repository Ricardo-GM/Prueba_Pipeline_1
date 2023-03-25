package stepdefinitions;

import actions.Base.EnterText;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Switch;
import org.openqa.selenium.By;
import tasks.CambiarVentana;
import userinterface.LoginPage;

import java.util.Set;

import static util.Hooks.driver;

public class PruebaSteps {
    String tituloPagina;

    @Given("{actor} se encuentra en la página de select")
    public void userSeEncentraEnLaPáginaDeSelect(Actor actor) throws InterruptedException {
        driver.get("https://beta.ca.collections.equifax.com/cyberconsole/cflogin?redirect_uri=https:%2F%2Fbeta.ca.collections.equifax.com%2Fcfv9%2Flogin%2Flogin");
        /*
        Set<String> numeroWindows = driver.getWindowHandles();
        for (String window : numeroWindows) {
            driver.switchTo().window(window);
            if (driver.getTitle().equals("Chrome Issues | Authenticator")) {
                driver.close();
            }
        }

        */
        actor.attemptsTo(
                //Open.url("chrome-extension://bhghoamapcdpbohphigoooaddinpkbai/view/popup.html")






        );
        //driver.close();


    }


    @When("{actor} selecciona un valor")
    public void seleccionaUnValor(Actor actor) throws InterruptedException {


        actor.attemptsTo();

    }

    @Then("{actor} no aparece ningun error")
    public void noApareceNingunError(Actor actor) throws InterruptedException {

        actor.attemptsTo(


        );
    }
}
