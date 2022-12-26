package org.example.config;

import io.dropwizard.Configuration;

import javax.validation.constraints.NotNull;

public class HelloWorldConfiguration extends Configuration {

    @NotNull
    private String greeting;

    public String getGreeting() {
        return greeting;
    }
}
