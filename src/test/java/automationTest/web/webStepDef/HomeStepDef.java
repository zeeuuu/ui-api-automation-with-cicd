package automationTest.web.webStepDef;

import automationTest.web.webPages.AuthPage;
import automationTest.web.webPages.HomePage;
import automationTest.web.webPages.LandingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomeStepDef {
    HomePage homePage;
    LandingPage landingPage;
    AuthPage authPage;

    public HomeStepDef() {
        this.homePage = new HomePage();
    }

    @Then("user sees welcome message {string}")
    public void userSeesWelcomeMessage(String message) {
        homePage.validateHomepage(message);
    }

    @Given("user is successfully redirected to the homepage")
    public void userIsSuccessfullyRedirectedToTheHomepage() {
        String username = "zeeu94";
        String password = "secretmode";
        String message = "Welcome zeeu94";

        landingPage = new LandingPage();
        landingPage.openWebsite();
        landingPage.clickLoginMenu();
        authPage = new AuthPage();
        authPage.usernameLogin(username);
        authPage.passwordLogin(password);
        authPage.clickLoginButton();
        homePage.validateHomepage(message);
    }

    @And("user selects category {string}")
    public void userSelectsCategory(String category) {
        switch (category) {
            case "Phones":
                homePage.clickPhonesCategory();
                break;
            case "Laptops":
                homePage.clickLaptopsCategory();
                break;
            case "Monitors":
                homePage.clickMonitorsCategory();
                break;
            default:
                throw new IllegalArgumentException("'"+category+"' is not recognized");
        }
    }

    @And("user add product {string}")
    public void userAddProduct(String product) {
        homePage.openProductDetails(product);
        homePage.addToCartItem();
    }
}
