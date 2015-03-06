package edu.umich.api.tester.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class APIResponses implements Serializable {

    @JsonProperty("api")
    private List<APIResponse> apiResponses;

    public APIResponses() {
    }

    public void add(APIResponse apiResponse) {
        if (apiResponses == null) {
            apiResponses = new ArrayList<>();
        }
        apiResponses.add(apiResponse);
    }

    public List<APIResponse> getApiResponses() {
        if (apiResponses == null) {
            apiResponses = new ArrayList<>();
        }
        return apiResponses;
    }
}
