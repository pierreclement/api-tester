package edu.umich.api.tester.domain;

import javax.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class API {

    @Id
    private Long id;
    @NotNull
    private String url;

    public API() {
    }

    public API(String url) {
        this.url = url;
    }}
