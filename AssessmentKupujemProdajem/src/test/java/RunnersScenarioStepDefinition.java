import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"json:target/cucumber.json",
                "html:target/site/cucumber-pretty",
                "pretty"
        },

        features = {"src/test/java/resources/"},

        glue = "steps",

        tags = {"~@disable_this_scenario"},

        monochrome = false

)

public class RunnersScenarioStepDefinition {

}
