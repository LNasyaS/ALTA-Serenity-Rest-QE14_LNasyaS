package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class RegisterStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("User register with valid json {string}")
    public void userRegisterWithValidJson(String json) {

        File jsonFile = new File(Constants.REQ_BODY + json);
        reqresAPI.registerUser(jsonFile);

    }

    @When("Send request post user register")
    public void sendRequestPostUserRegister() {
        SerenityRest.when()
                .post(ReqresAPI.REGISTER_USER);
    }

}
