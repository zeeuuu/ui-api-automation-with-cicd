package automationTest.api.apiStepDef;

import automationTest.api.apiPages.ApiPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApiStepDef {
    ApiPage apiPage;

    public ApiStepDef() {
        this.apiPage = new ApiPage();
    }
    @Given("prepare url for {string}")
    public void prepareUrlFor(String url) {
        apiPage.prepareUrlFor(url);
    }

    @When("hit api to post create a new user")
    public void hitApiToPostCreateANewUser() {
        apiPage.hitApiPostCreate();
    }

    @When("hit api to get user by ID")
    public void hitApiToGetUserById() {
        apiPage.hitApiGetUser();
    }

    @When("hit api put request update data")
    public void hitApiPutRequestUpdateData() {
        apiPage.hitApiPutUpdate();
    }

    @When("hit api delete user")
    public void hitApiDeleteUser() {
        apiPage.hitApiDeleteUser();
    }

    @When("hit api to get list")
    public void hitApiToGetList() {
        apiPage.hitApiGetList();
    }

    @Then("validate that the status code is {int}")
    public void validateThatTheStatusCodeIs(int status_code) {
        apiPage.validateStatusCode(status_code);
    }

    @Then("validate response JSON using JSON Schema {string}")
    public void validateResponseJSONUsingJSONSchema(String file_name) {
        apiPage.validateResponseJSON(file_name);
    }

    @And("validate response body contains correct user data")
    public void validateResponseBodyContainsCorrectUserData() {
        apiPage.validateResponseBodyContainsCorrectUser();
    }

    @Then("validation response body contains error message {string}")
    public void validationResponseBodyContainsErrorMessage(String message) {
        apiPage.validationResponseBodyContainsErrorMessage(message);
    }

    @When("hit api to get user with non-existent ID {string}")
    public void hitApiToGetUserWithNonExistentID(String userID) {
        apiPage.hitApiGetNonExistentID(userID);
    }

    @When("hit api to delete user with invalid ID {string}")
    public void hitApiToDeleteUserWithInvalidID(String userID) {
        apiPage.hitApiDeleteInvalidID(userID);
    }
}
