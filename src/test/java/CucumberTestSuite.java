import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import util.JiraXrayOperation;

import static util.Hooks.setXrayEnvironmentVariables;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin ={"json:target/build/cucumber.json"},
        stepNotifications = true,
        features = "src/test/resources/features",
        tags = "@Auditoria-Scenario"
)


public class CucumberTestSuite {
/*
    @BeforeClass
    public static void beforeAll() {
        setXrayEnvironmentVariables();
    }



    @AfterClass
    public static void afterAll() {
        JiraXrayOperation.importCucumberResult("/target/build/cucumber.json");
    }

*/



}
