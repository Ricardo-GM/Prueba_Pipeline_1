package exceptions;

import net.serenitybdd.core.exceptions.SerenityManagedException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;


public class ExceptionHandler_old implements Task {

    private Performable tarea;

    public ExceptionHandler_old(Performable tarea) {
        this.tarea = tarea;
    }

    public static ExceptionHandler_old to(Performable tarea) {
        return Tasks.instrumented(ExceptionHandler_old.class, tarea);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(tarea);
        } catch (SerenityManagedException sme) {
            // Manejo de excepciones de Serenity
            String mensajeError = "Se produjo una excepción de Serenity: " + sme.getMessage();
            System.out.println(mensajeError);
            sme.printStackTrace();

            throw new SerenityManagedException(mensajeError, new Exception(mensajeError, sme));

        } catch (NoSuchElementException e) {
            String mensajeError = "Algún elemento no se ha podido localizar: " + e.getMessage();
            System.out.println(mensajeError);
            e.printStackTrace();

            throw new NoSuchElementException(mensajeError, new Exception(mensajeError, e));
        } catch (NullPointerException e) {
            String mensajeError = "Se intenta acceder a un elemento nulo: " + e.getMessage();
            System.out.println(mensajeError);
            e.printStackTrace();

            throw new NullPointerException(mensajeError);
        } catch (TimeoutException e) {
            String mensajeError = "Se ha excedido el tiempo de espera: " + e.getMessage();
            System.out.println(mensajeError);
            e.printStackTrace();

            throw new TimeoutException(mensajeError, new Exception(mensajeError, e));

        } catch (NoSuchWindowException e) {
            String mensajeError = "Se quiere acceder a una ventana no disponbile: " + e.getMessage();
            System.out.println(mensajeError);
            e.printStackTrace();

            throw new NoSuchElementException(mensajeError, new Exception(mensajeError, e));
        } catch (UnhandledAlertException e) {
            String mensajeError = "Se quiere acceder a una alerta no disponbile: " + e.getMessage();
            System.out.println(mensajeError);
            e.printStackTrace();

            throw new UnhandledAlertException(mensajeError);
        } catch (Exception e) {
            // Manejo de excepciones generales
            String mensajeError = "Se produjo una excepción: " + e.getMessage();
            System.out.println(mensajeError);
            e.printStackTrace();

            throw new RuntimeException(mensajeError, new Exception(mensajeError, e) );
        }
    }


}
