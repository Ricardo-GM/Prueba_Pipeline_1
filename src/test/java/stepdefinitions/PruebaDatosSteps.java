package stepdefinitions;

import exceptions.ExceptionHandler;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;

public class PruebaDatosSteps {

    @Then("{actor} verifica si las palabras de csv existen")
    public void userVerificaSiLasPalabrasDeCsvExisten(Actor actor) throws Exception {
        try {
            actor.attemptsTo(
                    //VerificarMensajeFlash.Contiene(PostLoginMessage.Text().answeredBy(actor), mensaje)

            );
            Thread.sleep(10000);
        }catch (Throwable e) {
            ExceptionHandler.Error(e);
        }

    }
}
