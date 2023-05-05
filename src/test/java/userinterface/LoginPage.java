package userinterface;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {


    private static By usernameInput = By.id("username");
    private static By passwordInput = By.id("password");
    private static By loginButton = By.xpath("//button[@type='submit']");
    public static By getUsernameInput() {
        return usernameInput;
    }
    public static By getPasswordInput() {
        return passwordInput;
    }
    public static By getLoginButton() { return loginButton; }
    ///////////
    private static By alerta = By.xpath("//button[text()='Click for JS Alert']");

    private static By mensaje = By.xpath("//div[@class='example']/h3[text()='JavaScript Alerts']");

    public static  By username = By.id("userName");

    public static By getAlerta() {
        return alerta;
    }

    public static By getMensaje() {
        return mensaje;
    }

    //----------

    private static By navigatorEmailInput = By.id("userIdInput");

    private static By navigatorLoginButton = By.id("loadingTrigger");
    private static By adEmailInput = By.xpath("//input[@type='email']");
    private static By adNextButton = By.xpath("//input[@type='submit']");
    private static By adPasswordInput = By.id("passwordInput");
    private static By adSubmitButton = By.id("submitButton");

    private static By adDontRememberButton = By.id("idBtn_Back");

    public static By getAdEmailInput(){
        return adEmailInput;
    }

    public static By getAdNextButton(){
        return adNextButton;
    }

    public static By getAdPasswordInput() {return adPasswordInput;}

    public static By getNavigatorEmailInput() {
        return navigatorEmailInput;
    }

    public static By getNavigatorLoginButton() {
        return navigatorLoginButton;
    }

    public static By getAdSubmitButton() {
        return adSubmitButton;
    }

    public static By getAdDontRememberButton() {
        return adDontRememberButton;
    }
}
