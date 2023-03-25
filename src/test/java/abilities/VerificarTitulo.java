package abilities;

import net.serenitybdd.screenplay.Ability;
import org.openqa.selenium.WebDriver;

public class VerificarTitulo implements Ability {

    private WebDriver driver;

    public VerificarTitulo(WebDriver driver) {
        this.driver = driver;
    }

    public static VerificarTitulo en(WebDriver driver) {
        return new VerificarTitulo(driver);
    }

    public String obtenerTitulo() {
        return driver.getTitle();
    }



}
