package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class LoginStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Login user with valid json {string}")
    public void loginUserWithValidJson(String json) {

        File jsonFile = new File(Constants.REQ_BODY + json);
        reqresAPI.loginUser(jsonFile);

    }

    @When("Send request post user login")
    public void sendRequestPostUserLogin() {
        SerenityRest.when()
                .post(ReqresAPI.LOGIN_USER);
    }


}
