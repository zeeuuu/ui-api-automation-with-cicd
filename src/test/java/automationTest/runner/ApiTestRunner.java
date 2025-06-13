package automationTest.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:build/reports/tests/apiTest/apiTest-report.html",
                "json:build/reports/tests/apiTest/apiTest-report.json"
        },
        glue = {"automationTest.api.apiStepDef"},
        features = "src/test/resources/features/api",
        monochrome = true,
        tags = "@api"
)

public class ApiTestRunner {
}
