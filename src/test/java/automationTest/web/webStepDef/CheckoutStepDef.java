package automationTest.web.webStepDef;

import automationTest.web.webPages.AuthPage;
import automationTest.web.webPages.CheckoutPage;
import automationTest.web.webPages.HomePage;
import automationTest.web.webPages.LandingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutStepDef {
    CheckoutPage checkoutPage;
    LandingPage landingPage;
    AuthPage authPage;
    HomePage homePage;

    public CheckoutStepDef() {
        this.checkoutPage = new CheckoutPage();
    }

    @Then("user navigates to the cart")
    public void userNavigatesToTheCart() {
        checkoutPage.clickCartMenu();
    }

    @Given("user has added products to the cart")
    public void userHasAddedProductsToTheCart() {
        String username = "zeeu94";
        String password = "secretmode";
        String message = "Welcome zeeu94";
        String product = "Nexus 6";

        landingPage = new LandingPage();
        landingPage.openWebsite();
        landingPage.clickLoginMenu();
        authPage = new AuthPage();
        authPage.usernameLogin(username);
        authPage.passwordLogin(password);
        authPage.clickLoginButton();
        homePage = new HomePage();
        homePage.validateHomepage(message);
        homePage.openProductDetails(product);
        homePage.addToCartItem();
        checkoutPage.clickCartMenu();
    }

    @When("user submits the order")
    public void userSubmitsTheOrder() {
        checkoutPage.clickPlaceOrder();
    }

    @And("user input the {string} {string}")
    public void userInputThe(String field, String value) {
        checkoutPage.inputData(field, value);
    }

    @And("user completes the purchase")
    public void userCompletesThePurchase() {
        checkoutPage.clickPurchaseButton();
    }

    @Then("user sees a confirmation message {string}")
    public void userSeesAConfirmationMessage(String message) {
        checkoutPage.validateMessage(message);
    }
}
