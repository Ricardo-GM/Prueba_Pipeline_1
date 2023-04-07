import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import util.JiraXrayOperation;

import java.util.logging.Logger;

import static util.Hooks.setXrayEnvironmentVariables;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin ={"json:target/build/cucumber.json"},
        stepNotifications = true,
        features = "src/test/resources/features",
        tags = "@IJX1-2"
)


public class CucumberTestSuite {

    @BeforeClass
    public static void beforeAll() {
        setXrayEnvironmentVariables();
    }



    @AfterClass
    public static void afterAll() {
        JiraXrayOperation.importCucumberResult("/target/build/cucumber.json");
    }

}
