package stepdefinitions;

import actions.Base.Click;
import actions.Base.ScrollTo;
import actions.Base.WaitUntil;
import exceptions.ExceptionHandler;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.targets.Target;
import tasks.CambiarVentana;
import tasks.CargarArchivoAuditoria;
import tasks.RealizarLogin;
import userinterface.ConsoleHomePage;
import userinterface.SecurePage;
import util.Constantes;
import util.Hooks;
import util.LoginUser;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AuditoriaSteps {

    @Given("{actor} carga el archivo CSV para validar las opciones de seguridad")
    public void CargaElArchivoCSVParaValidarLasOpcionesDeSeguridad(Actor actor) throws Exception {
        try {
            actor.attemptsTo(
                    //Se carga en la memoria el archivo .csv para la validación de etiquetas
                    CargarArchivoAuditoria.conNombre("src/test/resources/data/accesosCategoria.csv")
            );
            Hooks.tomarCapturaDePantalla();
        } catch (Throwable e) {
            ExceptionHandler.Error(e);
        }
    }
    @Given("{actor} ha iniciado sesion correctamente")
    public void ha_iniciado_sesion_correctamente(Actor actor) throws Exception {

        try {
            actor.attemptsTo(

                    Open.url("https://interbank.automationcloud.ibm.com/dbaoc/portal/index.jsp#/"),
                    RealizarLogin.Comoo(LoginUser.VALIDD_USER),
                    net.serenitybdd.screenplay.waits.WaitUntil.the(Target.the("elemento").located(SecurePage.getCardNavigator()), isVisible())
                            .forNoMoreThan(15).seconds()
            );
            Hooks.tomarCapturaDePantalla();
        }catch (Throwable e) {
            ExceptionHandler.Error(e);
        }
    }

    @And("{actor} ingresa al Consola Administrativa")
    public void IngresaAlConsolaAdministrativa(Actor actor) throws Exception {

        try {
            actor.attemptsTo(
                    Click.On(SecurePage.getMenuButton()),
                    Click.On(SecurePage.getEnvironmentButtonLocator()),
                    Click.On(SecurePage.getEnvironmentValueLocator()),
                    Click.On(SecurePage.getAdminConsoleButton()),
                    Click.On(SecurePage.getCardConsole()),
                    CambiarVentana.a(Constantes.TITULO_PAGINA_CONSOLA),
                    WaitUntil.ElementVisible(ConsoleHomePage.getNombreProducto())

            );

        } catch (Throwable e) {
            ExceptionHandler.Error(e);
        }

    }

    @When("{actor} despliega la opcion de Almacenes de Objetos")
    public void despliegaLaOpcionDeAlmacenesDeObjetos(Actor actor) throws Exception {
        try {
            actor.attemptsTo(Click.On(ConsoleHomePage.getItemTreeAlmacenesObjeto()));
        } catch (Throwable e) {
            ExceptionHandler.Error(e);
        }
    }

    @And("{actor} selecciono la opcion OS1")
    public void seleccionoLaOpcionOS(Actor actor) throws Exception {
        try {

            actor.attemptsTo(Click.On(ConsoleHomePage.getItemTreeStorageMain()));
        } catch (Throwable e) {
            ExceptionHandler.Error(e);
        }
    }

    @Then("{actor} visualiza la pantalla principal de Almacen de objetos OS1")
    public void visualizaLaPantallaPrincipalDeAlmacenDeObjetosOS(Actor actor) throws Exception {
        try {
            actor.attemptsTo(WaitUntil.ElementVisible(ConsoleHomePage.getTabStorageMain()));
        } catch (Throwable e) {
            ExceptionHandler.Error(e);
        }
    }

    @And("{actor} despliega la opcion Diseno de Datos")
    public void despliegaLaOpcionDisenoDeDatos(Actor actor) throws Exception {
        try {
            actor.attemptsTo(WaitUntil.ElementVisible(ConsoleHomePage.getItemTreeDisenoDeDatos()), Click.On(ConsoleHomePage.getItemTreeDisenoDeDatos()));
        } catch (Throwable e) {
            ExceptionHandler.Error(e);
        }
    }

    @And("{actor} despliega la opcion Clases")
    public void despliegaLaOpcionClases(Actor actor) throws Exception {
        try {
            actor.attemptsTo(WaitUntil.ElementVisible(ConsoleHomePage.getItemTreeClases()), Click.On(ConsoleHomePage.getItemTreeClases()));
        } catch (Throwable e) {
            ExceptionHandler.Error(e);
        }
    }

    @And("{actor} despliega la opcion Documentos")
    public void despliegaLaOpcionDocumentos(Actor actor) throws Exception {
        try {
            actor.attemptsTo(WaitUntil.ElementVisible(ConsoleHomePage.getItemTreeDocumento()), Click.On(ConsoleHomePage.getItemTreeDocumento()));
        } catch (Throwable e) {
            ExceptionHandler.Error(e);
        }
    }

    @And("{actor} despliega la opcion Documentos IBK")
    public void despliegaLaOpcionDocumentosIBK(Actor actor) throws Exception {
        try {
            actor.attemptsTo(WaitUntil.ElementVisible(ConsoleHomePage.getItemTreeDocumentoIbk()), Click.On(ConsoleHomePage.getItemTreeDocumentoIbk()));
        } catch (Throwable e) {
            ExceptionHandler.Error(e);
        }
    }
    @Then("{actor} verificar que exista la {string} correspondiente")
    public void verificarQueExistaLaClaseDocumentalCorrespondiente(Actor actor, String claseDocumental) throws Exception {
        try {
            actor.attemptsTo(WaitUntil.ElementVisible(ConsoleHomePage.getItemTreeClaseDocumental(claseDocumental)));
        } catch (Throwable e) {
            ExceptionHandler.Error(e);
        }
    }

    @And("{actor} seleccionar la {string} correspondiente")
    public void seleccionarLaClaseDocumentalCorrespondiente(Actor actor, String claseDocumental) throws Exception {
        try {
            actor.attemptsTo(Click.On(ConsoleHomePage.getItemTreeClaseDocumental(claseDocumental)));
        } catch (Throwable e) {
            ExceptionHandler.Error(e);
        }
    }

    @Then("{actor} visualiza la pantalla con informacion de la {string}")
    public void visualizaLaPantallaConInformacionDeLaClaseDocumental(Actor actor, String claseDocumental) throws Exception {
        try {
            actor.attemptsTo(
                    WaitUntil.ElementVisible(ConsoleHomePage.getTabClaseDocumental(claseDocumental)),
                    Click.On(ConsoleHomePage.getTabClaseDocumental(claseDocumental))
                    /*,
                    CambiarVentana.a("Expediente de Convenios")*/

            );
        } catch (Throwable e) {
            ExceptionHandler.Error(e);
        }
    }
    @And("{actor} selecciona la pestaña de Definiciones de Auditoria")
    public void seleccionaLaPestanaDeDefinicionesDeAuditoria(Actor actor) throws Exception {
        try {
            actor.attemptsTo(
                    WaitUntil.ElementVisible(ConsoleHomePage.getBtnOpcionesClase()),
                    //Click.On(ConsolaPage.getBtnOpcionesClase()),
                    // EsperaHasta.Espera(ConsolaPage.getTabAuditoria()),
                    Click.On(ConsoleHomePage.getTabAuditoria())
            );
        } catch (Throwable e) {
            ExceptionHandler.Error(e);
        }
    }

    @Then("{actor} visualiza las opciones correspondientes de auditoria")
    public void visualizaLasOpcionesCorrespondientesDeAuditoria(Actor actor) throws Exception {
        try {
            actor.attemptsTo(
                    WaitUntil.ElementVisible(ConsoleHomePage.getLabelAuditCrear()),
                    WaitUntil.ElementVisible(ConsoleHomePage.getLabelAuditObtener()),
                    WaitUntil.ElementVisible(ConsoleHomePage.getLabelAuditConsultar()),
                    WaitUntil.ElementVisible(ConsoleHomePage.getLabelAuditEliminar())

            );
        } catch (Throwable e) {
            ExceptionHandler.Error(e);
        }
    }


    @And("{actor} selecciona idioma spanish en la aplicacion Navigator")
    public void userSeleccionaIdiomaSpanishEnLaAplicacionNavigator(Actor actor) throws Exception {
        try {
            actor.attemptsTo(
                    Click.On(ConsoleHomePage.getProfileButtonlocator()),
                    Click.On(ConsoleHomePage.getPreferenciasUsuarioButtonLocator()),
                    Click.On(ConsoleHomePage.getIdiomaAplicacionLocator()),
                    ScrollTo.element(ConsoleHomePage.getIdiomaAplicacionEspañolLocator()),
                    Click.On(ConsoleHomePage.getIdiomaAplicacionEspañolLocator()),
                    /*
                    Click.On(ConsoleHomePage.getEntornoLocalAplicacionLocator()),
                    ScrollTo.element(ConsoleHomePage.getIdiomaEspañolEntornoLocalAplicacionLocator()),
                    Click.On(ConsoleHomePage.getIdiomaEspañolEntornoLocalAplicacionLocator()),
                    */
                    Click.On(ConsoleHomePage.getGuardarPreferenciasUsuarioLocator())
            );
        }catch (Throwable e){
            ExceptionHandler.Error(e);
        }
    }
}
