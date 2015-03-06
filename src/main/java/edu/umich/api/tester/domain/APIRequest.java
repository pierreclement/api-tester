package edu.umich.api.tester.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class APIRequest implements Serializable {

    private String name;
    private List<EndpointRequest> endpointRequests;

    public APIRequest() {
    }

    public APIRequest(String name) {
        this.name = name;
        endpointRequests = new ArrayList<>();
    }

    public List<EndpointRequest> getEndpointRequests() {
        if (endpointRequests == null) {
            endpointRequests = new ArrayList<>();
        }
        return endpointRequests;
    }
}
