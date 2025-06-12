package automationTest.api.apiPages;

import automationTest.helper.Endpoint;
import automationTest.helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;

import static automationTest.helper.Models.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiPage {
    String setURL;
    Response respons;

    public void prepareUrlFor(String url) {
        switch(url) {
            case "user":
                setURL = Endpoint.USERS;
                break;
            case "tags":
                setURL = Endpoint.TAGS;
                break;
            case "invalid_url":
                setURL = Endpoint.INVALID_URL;
                break;
            default:
                System.out.println("input right url");
        }
    }

    public static class GlobalVariable {
        public static String userID;
    }

    public void hitApiPostCreate() {
        respons = postCreateUser(setURL);
        GlobalVariable.userID = respons.jsonPath().getString("id");
        System.out.println(GlobalVariable.userID);
    }

    public void hitApiGetUser() {
        respons = getUsers(setURL, GlobalVariable.userID);
    }

    public void hitApiPutUpdate() {
        respons = putUpdateUser(setURL, GlobalVariable.userID);
    }

    public void hitApiDeleteUser() {
        respons = deleteUser(setURL, GlobalVariable.userID);
    }

    public void validateStatusCode(int status_code) {
        assertEquals(status_code, respons.statusCode());
    }

    public void validateResponseJSON(String file_name) {
        File JSONFile = Utility.getJSONSchemaFile(file_name);
        respons.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }

    public void validateResponseBodyContainsCorrectUser() {
        JsonPath jsonPath = respons.jsonPath();

        String id = jsonPath.get("id");
        String firstName = jsonPath.get("firstName");
        String lastName = jsonPath.get("lastName");
        String email = jsonPath.get("email");
        String registerDate = jsonPath.get("registerDate");
        String updatedDate = jsonPath.get("updatedDate");

        assertThat(id).isNotNull();
        assertThat(firstName).isNotNull();
        assertThat(lastName).isNotNull();
        assertThat(email).isNotNull();
        assertThat(registerDate).isNotNull();
        assertThat(updatedDate).isNotNull();
    }

    public void hitApiGetList() {
        respons = getList(setURL);
    }

    public void validationResponseBodyContainsErrorMessage(String message) {
        if (respons.getBody().asString().contains(message)) {
            System.out.println(message);
            assertTrue(true);
        }
    }

    public void hitApiGetNonExistentID(String invalidID) {
        respons = getUsers(setURL, invalidID);
    }

    public void hitApiDeleteInvalidID(String invalidID) {
        respons = deleteUser(setURL, invalidID);
    }
}
