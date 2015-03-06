package edu.umich.api.tester.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class APIResponses implements Serializable {

    private List<APIResponse> apiResponses;

    public APIResponses() {
    	apiResponses = new ArrayList<>();
    }

    public void add(APIResponse apiResponse) {
        if (apiResponses==null) {
            apiResponses = new ArrayList<>();
        }
        apiResponses.add(apiResponse);
    }
}
