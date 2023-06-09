package tasks;

import actions.Base.Click;
import actions.Base.EnterText;
import actions.Base.WaitUntil;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import org.openqa.selenium.Keys;
import userinterface.LoginPage;
import util.LoginUser;

public class RealizarLogin implements Task {

    @Override
    public <T extends Actor> void performAs(T t) {

    }


    public static Performable Como(LoginUser loginUser){
        return Task.where("{0} inicia sesion como " + loginUser,
                EnterText.On(LoginPage.getUsernameInput(), loginUser.username),
                EnterText.On(LoginPage.getPasswordInput(), loginUser.password),
                Click.On(LoginPage.getLoginButton())
        );

    }

    public static  Performable Con(String username, String password) {
        return  Task.where( "{0} inicia sesion con usuario: " + username + " y password: " + password,
                EnterText.On(LoginPage.getUsernameInput(), username),
                EnterText.On(LoginPage.getPasswordInput(), password + String.valueOf(Keys.ENTER))
                //Click.On(LoginPage.getLoginButton())

        );
    }

    public static Performable Comoo(LoginUser loginUser) throws Exception {
        return Task.where("{0} inicia sesion como " + loginUser,
                WaitUntil.ElementVisible(LoginPage.getNavigatorEmailInput()),
                EnterText.On(LoginPage.getNavigatorEmailInput(), loginUser.username),
                Click.On(LoginPage.getNavigatorLoginButton()),
                WaitUntil.ElementVisible(LoginPage.getAdEmailInput()),
                EnterText.On(LoginPage.getAdEmailInput(), loginUser.username),
                Click.On(LoginPage.getAdNextButton()),
                WaitUntil.ElementVisible(LoginPage.getAdPasswordInput()),
                EnterText.On(LoginPage.getAdPasswordInput(), loginUser.password),
                Click.On(LoginPage.getAdSubmitButton()),
                WaitUntil.ElementVisible(LoginPage.getAdDontRememberButton()),
                Click.On(LoginPage.getAdDontRememberButton())

        );
    }
}
