package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;

import static org.hamcrest.Matchers.equalTo;

public class SingleUserStepDef {

    @Steps
    ReqresAPI reqresAPI;


    @Given("Get user with valid user {int}")
    public void getUserWithValidUser(int id) {
        reqresAPI.getUser(id);
    }

    @When("Send request get user")
    public void sendRequestGetUser() {
        SerenityRest.when()
                .get(ReqresAPI.GET_USER);
    }

    @And("Response body name should be {int} and {string}")
    public void responseBodyNameShouldBeAnd(int id, String email) {
        SerenityRest.and()
                .body(ReqresResponses.DATA_ID, equalTo(id))
                .body(ReqresResponses.DATA_EMAIL, equalTo(email));
    }

    @Given("Get user with invalid {string}")
    public void getUserWithInvalid(String id) {
        reqresAPI.getInvalidUser(id);
    }



}
