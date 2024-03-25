package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class CreateUser {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Create user with valid json {string}")
    public void createUserWithValidJson(String json) {

        File jsonFile = new File(Constants.REQ_BODY + json);
        reqresAPI.postCreateUser(jsonFile);

    }

    @When("Send request create new user")
    public void sendRequestCreateNewUser() {
        SerenityRest.when()
                .post(ReqresAPI.CREATE_USER);
    }
}
