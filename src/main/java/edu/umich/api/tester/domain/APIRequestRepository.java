package edu.umich.api.tester.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//public interface APIRequestRepository extends CrudRepository<API, Long> {
@Component
public class APIRequestRepository {

    private static final Logger logger = LoggerFactory.getLogger("edu.umich.api.tester");

    public List<APIRequest> findAll() {
        List<APIRequest> apis = new ArrayList<>();

        APIRequest api = new APIRequest("Buildings");
        apis.add(api);
        EndpointRequest request = new EndpointRequest();
        api.getEndpointRequests().add(request);
        request.setDate(new Date());
        request.setExpectedResponse("OK");
        request.setFullRequest("https://example.com/Buildings");
        request.setUrl("https://example.com/Buildings");
        request.setVerb("GET");
        TestCaseRequest tcRequest = new TestCaseRequest();
        tcRequest.setTestCondition("is available");
        request.getTestCaseRequests().add(tcRequest);

        api = new APIRequest("Cookies");
        apis.add(api);
        request = new EndpointRequest();
        api.getEndpointRequests().add(request);
        request.setDate(new Date());
        request.setExpectedResponse("OK");
        request.setFullRequest("https://example.com/Cookies");
        request.setUrl("https://example.com/Cookies");
        request.setVerb("GET");
        tcRequest = new TestCaseRequest();
        tcRequest.setTestCondition("is available");
        request.getTestCaseRequests().add(tcRequest);

        api = new APIRequest("Hello World");
        apis.add(api);
        request = new EndpointRequest();
        api.getEndpointRequests().add(request);
        request.setDate(new Date());
        request.setExpectedResponse("OK");
        request.setFullRequest("https://api-qa-gw.its.umich.edu/HelloWorld/v1/oHelloWorld");
        request.setUrl("https://api-qa-gw.its.umich.edu/HelloWorld/v1/oHelloWorld");
        request.setVerb("GET");
        tcRequest = new TestCaseRequest();
        tcRequest.setTestCondition("is available");
        request.getTestCaseRequests().add(tcRequest);
        tcRequest = new TestCaseRequest();
        tcRequest.setTestCondition("response=<Entries xmlns=\"http://ws.wso2.org/dataservice\"><Entry><Hello xmlns=\"http://ws.wso2.org/dataservice\">Hello World!</Hello></Entry></Entries>");
        request.getTestCaseRequests().add(tcRequest);

        return apis;
    }
}
