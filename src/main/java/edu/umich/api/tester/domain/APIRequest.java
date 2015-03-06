package edu.umich.api.tester.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class APIRequest implements Serializable {

    private List<Resource> resources;

    public APIRequest() {
    	resources = new ArrayList<>();
    }
}
