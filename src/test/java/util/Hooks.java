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
import java.util.Base64;
import java.util.List;

import static net.serenitybdd.core.Serenity.getDriver;


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
        /*
    //Obtener variables del archivo serenity.conf
    EnvironmentVariables variablesEntorno = ConfiguredEnvironment.getConfiguration().getEnvironmentVariables();
    //Obtener la url BASE
    String baseUrl = ConfiguredEnvironment.getConfiguration().getBaseUrl();
    //Driver
    String driverType = variablesEntorno.getProperty("webdriver.driver");
    //Modo de cabecera
    Boolean headlessMode = Boolean.valueOf(variablesEntorno.getProperty("headless.mode"));

        switch (driverType) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/windows/chromedriver.exe");
                //Crear opciones de Chrome
                ChromeOptions chromeOptions = new ChromeOptions();

                String driverChromeSwitches = variablesEntorno.getProperty("chrome.switches");
                if(driverChromeSwitches != null && !driverChromeSwitches.isEmpty()) {
                    chromeOptions.addArguments(driverChromeSwitches.split(";"));
                }
                if(headlessMode) {
                    chromeOptions.addArguments("--headless");
                }

                chromeOptions.addArguments("--remote-allow-origins=*");


                driver = new ChromeDriver(chromeOptions);

                break;

            case "edge":

                System.setProperty("webdriver.edge.driver", "src/test/resources/webdriver/windows/msedgedriver.exe");
                EdgeOptions edgeOptions = new EdgeOptions();

                String driverEdgeSwitches = variablesEntorno.getProperty("edge.switches");
                if(driverEdgeSwitches != null && !driverEdgeSwitches.isEmpty()) {
                    edgeOptions.addArguments(driverEdgeSwitches.split(";"));
                }
                if(headlessMode) {
                    edgeOptions.addArguments("--headless");
                }


                driver = new EdgeDriver(edgeOptions);


                break;

            case "ie":
                System.setProperty("webdriver.ie.driver", "src/test/resources/webdriver/windows/IEDriverServer32.exe");
                InternetExplorerOptions ieOptions = new InternetExplorerOptions();

                String driverIeSwitches = variablesEntorno.getProperty("ie.switches");
                if(driverIeSwitches != null && !driverIeSwitches.isEmpty()) {
                    ieOptions.addCommandSwitches(driverIeSwitches.split(";"));
                }
                if(headlessMode) {
                    ieOptions.addCommandSwitches("--headless");
                }
                ieOptions.introduceFlakinessByIgnoringSecurityDomains();
                ieOptions.ignoreZoomSettings();



                driver = new InternetExplorerDriver(ieOptions);


                break;

        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
*/
    BrowseTheWeb browseTheWeb = BrowseTheWeb.with(driver);

    List<Ability> userAbilities = Arrays.asList(browseTheWeb, VerificarTitulo.en(driver));


    OnStage.setTheStage(new OnlineCast());
    ActorFactory.crearYRegistrarActor("user", "Usuario de prueba", userAbilities);

    }

/*
    @After
    public void tearDown() {
        driver.quit();

    }

*/

    //Método para tomar screenshots

    public static void tomarCapturaDePantalla(){
        //WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
        //WebDriverFacade facade = (WebDriverFacade) driver;
            //byte[] evidencia = ((TakesScreenshot) Serenity.getDriver()).getScreenshotAs(OutputType.BYTES);
        //scenario.attach(evidencia, "image/png", "evidencias");
        /*
        if(evidencia != null) {
            String evidenciaBase64 = Base64.getEncoder().encodeToString(evidencia);
            Serenity.recordReportData()
                    .withTitle("captura de pantalla")
                    .andContents(evidenciaBase64);
        }

         */


    }

    public static void setXrayEnvironmentVariables() {
        System.setProperty("jira.xray.client-id", Constantes.JIRA_XRAY_CLIENT_ID);
        System.setProperty("jira.xray.client-secret", Constantes.JIRA_XRAY_CLIENT_SECRET);
    }




}
