package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class UpdateUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Update user with valid json {string} and user id {int}")
    public void updateUserWithValidJsonAndUserId(String json, int id) {

        File jsonFile = new File(Constants.REQ_BODY + json);
        reqresAPI.putUpdateUser(id, jsonFile);
    }

    @When("Send request update user")
    public void sendRequestUpdateUser() {
        SerenityRest.when()
                .put(ReqresAPI.UPDATE_USER);
    }

    @Given("Update user with json {string} without user id")
    public void updateUserWithJsonWithoutUserId(String json) {

        File jsonFile = new File(Constants.REQ_BODY + json);
        reqresAPI.putUpdateUserWithoutId(jsonFile);
    }

    @When("Send request update invalid id path")
    public void sendRequestUpdateInvalidIdPath() {
        SerenityRest.when()
                .put(ReqresAPI.UPDATE_INVALID_USER);
    }
}
