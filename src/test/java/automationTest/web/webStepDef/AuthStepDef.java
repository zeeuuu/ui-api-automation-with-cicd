package automationTest.web.webStepDef;

import automationTest.web.webPages.AuthPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AuthStepDef {
    AuthPage authPage;

    public AuthStepDef() {
        this.authPage = new AuthPage();
    }

    @And("user input a random username")
    public void userInputARandomUsername() {
        authPage.generateRandomUsername();
    }

    @And("user input username {string}")
    public void userInputUsername(String username) {
        authPage.usernameSignup(username);
    }

    @And("user input password {string}")
    public void userInputPassword(String password) {
        authPage.passwordSignup(password);
    }

    @When("user click the sign up button")
    public void userClickTheSignUpButton() {
        authPage.clickButtonSignup();
    }

    @When("user input login username {string}")
    public void userInputLoginUsername(String username) {
        authPage.usernameLogin(username);
    }

    @And("user input login password {string}")
    public void userInputLoginPassword(String password) {
        authPage.passwordLogin(password);
    }

    @When("user click the log in button")
    public void userClickTheLogInButton() {
        authPage.clickLoginButton();
    }

    @Then("user sees alert message {string}")
    public void userSeesAlertMessage(String message) {
        authPage.alertMessage(message);
    }
}
