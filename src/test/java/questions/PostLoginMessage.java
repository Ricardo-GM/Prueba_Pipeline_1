package questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import userinterface.SecurePage;

public class PostLoginMessage {

    public static Question<String> Text() {

        return actor -> actor.asksFor(Text.of(SecurePage.getFlashMessage()));
    }

}
