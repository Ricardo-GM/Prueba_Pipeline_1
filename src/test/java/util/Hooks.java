package util;


import abilities.VerificarTitulo;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.Scenario;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.environment.ConfiguredEnvironment;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.util.Arrays;
import java.util.List;

public class Hooks extends ConfiguredEnvironment {
    public static WebDriver driver;
    private static Scenario scenario;

    @Before
    public void setScenario (Scenario scenario) {
        this.scenario = scenario;
    }


    @ParameterType("user|admin")
    public Actor actor(String name) {
        return OnStage.theActorCalled(name);
    }

    @Before
    public void setUp() {
    BrowseTheWeb browseTheWeb = BrowseTheWeb.with(driver);

    List<Ability> userAbilities = Arrays.asList(browseTheWeb, VerificarTitulo.en(driver));


    OnStage.setTheStage(new OnlineCast());
    ActorFactory.crearYRegistrarActor("user", "Usuario de prueba", userAbilities);

    }


    //Método para tomar screenshots

    public static void tomarCapturaDePantalla(){

        WebDriver driver = ((WebDriverFacade) Serenity.getWebdriverManager().getCurrentDriver()).getProxiedDriver();
        // Tomar la captura de pantalla y guardarla como un archivo
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        //Adjuntar la captura de pantalla al informe
        scenario.attach(screenshot, "image/png", "evidencia");
    }


    public static void setXrayEnvironmentVariables() {
        System.setProperty("jira.xray.client-id", Constantes.JIRA_XRAY_CLIENT_ID);
        System.setProperty("jira.xray.client-secret", Constantes.JIRA_XRAY_CLIENT_SECRET);
    }




}
