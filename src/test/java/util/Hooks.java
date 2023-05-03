package util;


import abilities.VerificarTitulo;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.Scenario;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.SerenityReports;
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
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import net.serenitybdd.core.Serenity;

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
        /*
        WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(evidencia, "image/png", "evidencias");

        if(evidencia != null) {
            String evidenciaBase64 = Base64.getEncoder().encodeToString(evidencia);
            Serenity.recordReportData()
                    .withTitle("captura de pantalla")
                    .andContents(evidenciaBase64);
        }

         */


        WebDriver driver = ((WebDriverFacade) Serenity.getWebdriverManager().getCurrentDriver()).getProxiedDriver();
        // Tomar la captura de pantalla y guardarla como un archivo
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        //Adjuntar la captura de pantalla al informe
        scenario.attach(screenshot, "image/png", "evidencia");



    }

    public static byte[] takeScreenshot() throws AWTException, IOException {
        Robot robot = new Robot();
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
        ByteArrayOutputStream screenshot = new ByteArrayOutputStream();
        ImageIO.write(screenFullImage, "png", screenshot);
        return screenshot.toByteArray();
    }

    public static void setXrayEnvironmentVariables() {
        System.setProperty("jira.xray.client-id", Constantes.JIRA_XRAY_CLIENT_ID);
        System.setProperty("jira.xray.client-secret", Constantes.JIRA_XRAY_CLIENT_SECRET);
    }




}
