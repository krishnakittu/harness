package org.example.config;

import io.dropwizard.Configuration;
import org.example.FTPConfiguration;

import javax.validation.constraints.NotNull;

public class HelloWorldConfiguration extends Configuration {

    @NotNull
    private String greeting;

    private FTPConfiguration ftpConfiguration;

    public String getGreeting() {
        return greeting;
    }

    public FTPConfiguration getFtpConfiguration() {
        return ftpConfiguration;
    }
}
