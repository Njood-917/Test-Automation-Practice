package API.Requests;

import com.shaft.api.RestActions;
import com.shaft.driver.SHAFT;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.core.IsEqual.equalTo;

public class testSingleUser {
    @Test
    public void getSingleUser() {
        // Initialize RequestBuilder with GET request type
        RequestBuilder requestBuilder =
                new RequestBuilder("https://reqres.in",
                        "/api/users/2",
                        RestActions.RequestType.GET);
        // Perform the request and get the response
        Response response = requestBuilder.performRequest();
        // Print and validate the response
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

// I have to fix this test
//    @Test
//    public void singleUserNotFound() {
//
//        RequestBuilder requestBuilder = new RequestBuilder("https://reqres.in",
//                "/api/users/23", RestActions.RequestType.GET)
//                .setExpectedStatusCode(404);
//
//
//        Response response = requestBuilder.performRequest();
//
//        // Print and assert the response status code
//        response.prettyPrint();
//        Assert.assertEquals(response.getStatusCode(), 404,
//                "Expected status code 404 but got " + response.getStatusCode());
//    }
}