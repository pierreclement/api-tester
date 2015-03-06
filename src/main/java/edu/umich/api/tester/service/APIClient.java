package edu.umich.api.tester.service;

import edu.umich.api.tester.domain.APIRequest;
import edu.umich.api.tester.domain.APIResponse;
import edu.umich.api.tester.domain.EndpointRequest;
import edu.umich.api.tester.domain.EndpointResponse;
import edu.umich.api.tester.domain.TestCaseRequest;
import edu.umich.api.tester.domain.TestCaseResponse;
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
        apiRequest.getEndpointRequests().stream().forEach((endpointRequest) -> {
            apiResponse.getEndpointResponses().add(assemble(endpointRequest));
        });
        return apiResponse;
    }

    private EndpointResponse assemble(EndpointRequest endpointRequest) {
        EndpointResponse response = new EndpointResponse();
        response.setDate(endpointRequest.getDate());
        response.setRawRequest(endpointRequest.getFullRequest());
        response.setUrl(endpointRequest.getUrl());
        endpointRequest.getTestCaseRequests().stream().map((tc) -> assemble(tc)).forEach((tcResponse) -> {
            response.getTestCaseResponses().add(tcResponse);
        });
        return response;
    }
    
    private TestCaseResponse assemble(TestCaseRequest tcRequest) {
        TestCaseResponse tcResponse = new TestCaseResponse();
        if (tcRequest.getTestCondition().equals("response=<Entries xmlns=\"http://ws.wso2.org/dataservice\"><Entry><Hello xmlns=\"http://ws.wso2.org/dataservice\">Hello World!</Hello></Entry></Entries>")) {
            tcResponse.setDetails("service gives us greetings.");
        } else {
            tcResponse.setDetails("service is available.");
        }
        tcResponse.setSuccess(true);
        tcResponse.setTestCondition(tcRequest.getTestCondition());
        return tcResponse;
    }
}
