package automationTest.web.webStepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static automationTest.helper.Utility.stopDriver;
import static automationTest.helper.Utility.startDriver;

public class Hooks {
    @Before
    public static void beforeTest() {
        startDriver();
    }

    @After
    public static void afterTest() {
        stopDriver();
    }
}