package edu.umich.api.tester.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class APIResponse implements Serializable {

    private String name;
    private int statusCode;
    private String statusMessage;
    private List<EndpointResponse> endpointResponses;

    public APIResponse() {
        endpointResponses = new ArrayList<>();
    }
}
