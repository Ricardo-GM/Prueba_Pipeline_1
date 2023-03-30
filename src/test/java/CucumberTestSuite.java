import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin ={"json:target/build/cucumber.json"},
        stepNotifications = true,
        features = "src/test/resources/features",
        tags = "@ValidLogin"
)


public class CucumberTestSuite {
}
