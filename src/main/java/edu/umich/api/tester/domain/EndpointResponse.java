package edu.umich.api.tester.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class EndpointResponse {

    private String url;
    @JsonProperty()
    private Date date;
    private String rawRequest;
    private String rawResponse;
    @JsonProperty("testCase")
    private List<TestCaseResponse> testCaseResponses;

    public List<TestCaseResponse> getTestCaseResponses() {
        if (testCaseResponses == null) {
            testCaseResponses = new ArrayList<>();
        }
        return testCaseResponses;
    }
}
