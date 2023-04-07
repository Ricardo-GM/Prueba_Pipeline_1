package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class CargarDatos implements Task {

    @Override
    public <T extends Actor> void performAs(T t) {

    }

    /*
    public static Performable Como(LoginUser loginUser){
        return Task.where("{0} inicia sesion como " + loginUser,
                EnterText.On(LoginPage.getUsernameInput(), loginUser.username),
                EnterText.On(LoginPage.getPasswordInput(), loginUser.password),
                Click.On(LoginPage.getLoginButton())
        );

    }*/

    public static String Hola(){
        return "Hola";
    }


}
