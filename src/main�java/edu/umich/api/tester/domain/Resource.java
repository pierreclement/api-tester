package edu.umich.api.tester.domain;

import java.net.URI;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Resource {

    @NotNull
    private URI url;
}
