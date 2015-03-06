package edu.umich.api.tester.domain;

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
}
