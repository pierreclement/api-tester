package edu.umich.api.tester.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class API implements Serializable {

    private List<Resource> resources;

    public API() {
    	resources = new ArrayList<Resource>();
    }

}
