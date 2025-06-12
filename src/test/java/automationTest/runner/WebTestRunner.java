package automationTest.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "summary",
                "html:reports/webTest-report.html",
                "json:reports/webTest-report.json"
        },
        glue = {"automationTest.web.webStepDef"},
        features = "src/test/resources/features/web",
        monochrome = true,
        tags = "@web"
)

public class WebTestRunner {
}

