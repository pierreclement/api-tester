package edu.umich.api.tester.domain;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class API implements Serializable {

    @NotNull
    private String url;

    public API() {
    }

    public API(String url) {
        this.url = url;
    }}
