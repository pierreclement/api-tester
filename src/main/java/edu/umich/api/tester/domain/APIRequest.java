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
    	endpointRequests = new ArrayList<>();
    }
}
