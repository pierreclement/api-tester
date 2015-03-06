package edu.umich.api.tester.domain;

import java.net.URL;
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
        api.setEndpointRequests(new ArrayList<>());
        EndpointRequest request = new EndpointRequest();
        api.getEndpointRequests().add(request);
        request.setDate(new Date());
        request.setExpectedResponse("OK");
        request.setFullRequest("https://example.com/Buildings");
        request.setTestCases(new ArrayList<>());
        request.setUrl("https://example.com/Buildings");
        request.setVerb("GET");

        api = new APIRequest("Cookies");
        apis.add(api);
        api.setEndpointRequests(new ArrayList<>());
        request = new EndpointRequest();
        api.getEndpointRequests().add(request);
        request.setDate(new Date());
        request.setExpectedResponse("OK");
        request.setFullRequest("https://example.com/Cookies");
        request.setTestCases(new ArrayList<>());
        request.setUrl("https://example.com/Cookies");
        request.setVerb("GET");

        return apis;
    }
}
