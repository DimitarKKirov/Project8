package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = {"src/test/resources/ExciteFeatures"},
//        tags = "@Login @CreateAccount",
        plugin = {"pretty"},
        glue = "Steps",
        dryRun= false
)

public class HookedRunner {
}
