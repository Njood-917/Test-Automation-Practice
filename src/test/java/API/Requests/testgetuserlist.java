package API.Requests;

import com.shaft.api.RestActions;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class testgetuserlist {
    @Test
    public void TC01() {
        // Initialize RequestBuilder with GET request type
        RequestBuilder requestBuilder =
                new RequestBuilder("https://reqres.in",
                        "/api/users?page=2",
                        RestActions.RequestType.GET);
        // Perform the request and get the response
        Response response = requestBuilder.performRequest();
        // Print and validate the response
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }
}