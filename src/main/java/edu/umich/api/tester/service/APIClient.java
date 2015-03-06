package edu.umich.api.tester.service;

import edu.umich.api.tester.domain.APIRequest;
import edu.umich.api.tester.domain.APIResponse;
import edu.umich.api.tester.domain.EndpointRequest;
import edu.umich.api.tester.domain.EndpointResponse;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class APIClient {

    private static final Logger logger = LoggerFactory.getLogger("edu.umich.api.tester");

    //@Autowired
    //private RestTemplate restTemplate;
    public APIResponse invoke(APIRequest apiRequest) {
        APIResponse apiResponse = assemble(apiRequest);
        //restTemplate...
        return apiResponse;
    }

    private APIResponse assemble(APIRequest apiRequest) {
        APIResponse apiResponse = new APIResponse();
        apiResponse.setName(apiRequest.getName());
        if (apiResponse.getName().equals("Cookies")) {
            apiResponse.setStatusCode(301);
            apiResponse.setStatusMessage("Moved Permanently. Cookies are all gone. Come back tomorrow.");
        } else {
            apiResponse.setStatusCode(200);
            apiResponse.setStatusMessage("OK");
        }
        apiResponse.setEndpointResponses(new ArrayList<>());
        apiRequest.getEndpointRequests().stream().forEach((endpointRequest) -> {
            apiResponse.getEndpointResponses().add(assemble(endpointRequest));
        });
        return apiResponse;
    }

    private EndpointResponse assemble(EndpointRequest endpointRequest) {
        System.err.println("yikes");
        EndpointResponse response = new EndpointResponse();
        response.setRawRequest(endpointRequest.getFullRequest());
        response.setRawResponse("hello");
        response.setUrl(endpointRequest.getUrl());
        return response;
    }
}
