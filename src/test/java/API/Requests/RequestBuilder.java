package API.Requests;

import com.shaft.api.RestActions;
import io.restassured.response.Response;

public class RequestBuilder {
    private RestActions api; // RestActions object to handle API requests
    private String serviceName; // The specific service endpoint
    private RestActions.RequestType requestType; // The type of the request (GET, POST, etc.)
    private int expectedStatusCode = 200;



    /**
     * Constructor to initialize RequestBuilder with necessary parameters.
     *
     * @param serviceURI  the base URI of the web service
     * @param serviceName the path/name of the web service {/servicePATH/serviceNAME}
     * @param requestType the type of your API request {POST, GET, PATCH, DELETE, PUT}
     */
    public RequestBuilder(String serviceURI, String serviceName, RestActions.RequestType requestType) {
        initializeVariables(new RestActions(serviceURI), serviceName, requestType);
    }

    /**
     * Initialize variables for the request.
     *
     * @param api         the RestActions object initialized with the base URI
     * @param serviceName the specific service endpoint to hit
     * @param requestType the type of the API request
     */
    private void initializeVariables(RestActions api, String serviceName, RestActions.RequestType requestType) {
        this.api = api;
        this.serviceName = serviceName;
        this.requestType = requestType;
    }
    // Method to set the expected status code
    public RequestBuilder setExpectedStatusCode(int statusCode) {
        this.expectedStatusCode = statusCode;
        return this;
    }
    /**
     * Perform the API request with the specified request type and return the response.
     *
     * @return Response object containing the response data
     */
    public Response performRequest() {
       return api.buildNewRequest(serviceName, requestType)
               .performRequest();


    }


    /**
     * Perform the API request with a request body (for POST, PUT, etc.) and return the response.
     *
     * @param requestBody the body of the request (JSON format)
     * @return Response object containing the response data
     */
    public Response performRequestWithBody(String requestBody) {
        // Build the request, set the body, and perform the request
        return api.buildNewRequest(serviceName, requestType)
                .setRequestBody(requestBody)
                .addHeader("Content-Type", "application/json")
                .performRequest();
    }


}
