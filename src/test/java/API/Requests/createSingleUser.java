package API.Requests;

import Pojos.UserResponse;
import com.shaft.api.RestActions;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class createSingleUser {
    @Test

    public void postSingleUser() {
        // Initialize RequestBuilder
        RequestBuilder requestBuilder = new RequestBuilder("https://reqres.in",
                "/api/users",
                RestActions.RequestType.POST);

        // Perform the request with the request body
        Response response = requestBuilder.performRequestWithBody("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}");
        response.prettyPrint();

        // Assert that the status code is 201
        response.then().statusCode(201);

        // Deserialize JSON response to POJO
        UserResponse userResponse = response.as(UserResponse.class);

        // Initialize SoftAssert for multiple checks
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(userResponse.getName(), "morpheus");
        softAssert.assertEquals(userResponse.getJob(), "leader");

        // Invoke assertAll to report any failures
        softAssert.assertAll();


    }
}
