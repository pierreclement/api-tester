package edu.umich.api.tester.domain;

import java.util.ArrayList;
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
        APIRequest api = new APIRequest();
        List<EndpointRequest> endpointRequests = new ArrayList<>();
        api.setEndpointRequests(endpointRequests);
        apis.add(api);
        return apis;
    }
}
