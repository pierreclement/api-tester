package edu.umich.api.tester.domain;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class APIRequests {

    private List<APIRequest> apiRequests;

    public APIRequests() {
    }

    public APIRequests(List<APIRequest> apiRequests) {
        this.setApiRequests(apiRequests);
    }

    public List<APIRequest> getApiRequests() {
        if (apiRequests == null) {
            apiRequests = new ArrayList<>();
        }
        return apiRequests;
    }
}
