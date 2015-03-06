package edu.umich.api.tester.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class APIResponse implements Serializable {

    private String name;
    private int statusCode;
    private String statusMessage;
    @JsonProperty("endpointResponse")
    private List<EndpointResponse> endpointResponses;

    public List<EndpointResponse> getEndpointResponses() {
        if (endpointResponses == null) {
            endpointResponses = new ArrayList<>();
        }
        return endpointResponses;
    }
}
