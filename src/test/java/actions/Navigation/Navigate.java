package actions.Navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;
import util.Constantes;

public class Navigate {

    public static Performable toLoginPage(){
        return Open.url(Constantes.PAGINA_LOGIN);
    }

    public static Performable toSelectPage() {
        return Open.url("https://the-internet.herokuapp.com/dropdown");
    }


}
