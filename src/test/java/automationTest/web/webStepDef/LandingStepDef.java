package automationTest.web.webStepDef;

import automationTest.web.webPages.LandingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class LandingStepDef {
    LandingPage landingPage;

    public LandingStepDef() {
        this.landingPage = new LandingPage();
    }

    @Given("user open demoblaze website")
    public void userOpenDemoblazeWebsite() {
        landingPage.openWebsite();
    }

    @And("user select the sign up option")
    public void userSelectTheSignUpOption() {
        landingPage.clickSignupMenu();
    }

    @And("user select the log in option")
    public void userSelectTheLogInOption() {
        landingPage.clickLoginMenu();
    }
}
