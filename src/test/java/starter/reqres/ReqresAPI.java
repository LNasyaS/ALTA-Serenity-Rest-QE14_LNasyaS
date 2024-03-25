package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class ReqresAPI {

    public static String LIST_USERS = Constants.BASE_URL + "/api/users?page={page}";

    public static String CREATE_USER = Constants.BASE_URL + "/api/users";

    public static String UPDATE_USER = Constants.BASE_URL + "/api/users/{id}";

    public static String UPDATE_INVALID_USER = Constants.BASE_URL + "/api/users/";

    public static String DELETE_USER = Constants.BASE_URL + "/api/users/{id}";

    public static String LOGIN_USER = Constants.BASE_URL + "/api/login";

    public static String REGISTER_USER = Constants.BASE_URL + "/api/register";

    public static String GET_USER = Constants.BASE_URL + "/api/users/{id}";


    @Step("Get list user with valid parameter page")
    public void getListUsers(int page) {
        SerenityRest.given()
                .pathParam("page", page);
    }

    @Step("Post create user with valid json")
    public void postCreateUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Update user with valid json and user id")
    public void putUpdateUser(int id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete user with valid user id")
    public void deleteUser(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("User login with valid or invalid json")
    public void loginUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("User register with valid or invalid json")
    public void registerUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Get list users with invalid parameter page")
    public void getInvalidList(String page) {
        SerenityRest.given()
                .pathParam("page", page);
    }
    @Step("Get user with valid user id")
    public void getUser(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Get user with invalid user id")
    public void getInvalidUser(String id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Update user without user id path")
    public void putUpdateUserWithoutId(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete user with invalid user id")
    public void deleteUserWithInvalidId(String id) {
        SerenityRest.given()
                .pathParam("id", id);
    }
}



