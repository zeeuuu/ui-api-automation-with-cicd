package automationTest.helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static automationTest.helper.Utility.generateRandomEmail;

public class Models {
    private static RequestSpecification request;

    public static void setupHeaders() {
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("app-id", "63a804408eb0cb069b57e43a");
    }

    public static Response postCreateUser(String endpoint) {
        setupHeaders();

        String firstName = "zeeu";
        String lastName = "kayle";
        String email = generateRandomEmail();

        JSONObject payload = new JSONObject();
        payload.put("firstName", firstName);
        payload.put("lastName", lastName);
        payload.put("email", email);

        String finalEndpoint = endpoint + "/" + "create";
        return request.body(payload.toString()).when().post(finalEndpoint);
    }

    public static Response getUsers(String endpoint, String userID) {
        setupHeaders();
        String finalEndpoint = endpoint + "/" + userID;
        System.out.println(finalEndpoint);
        return request.when().get(finalEndpoint);
    }

    public static Response putUpdateUser(String endpoint, String userID) {
        setupHeaders();

        String lastName = "lee";

        JSONObject payload = new JSONObject();
        payload.put("last name", lastName);

        String finalEndpoint = endpoint + "/" + userID;
        return request.body(payload.toString()).when().put(finalEndpoint);
    }

    public static Response deleteUser(String endpoint, String userID) {
        setupHeaders();
        String finalEndpoint = endpoint + "/" + userID;
        return request.when().delete(finalEndpoint);
    }

    public static Response getList(String endpoint) {
        setupHeaders();
        return request.when().get(endpoint);
    }
}
