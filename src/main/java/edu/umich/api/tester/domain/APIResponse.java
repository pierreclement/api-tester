package edu.umich.api.tester.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class APIResponse implements Serializable {

    private List<Resource> resources;
    private int statusCode;
    private String statusMessage;

    public APIResponse() {
        resources = new ArrayList<>();
    }
}
