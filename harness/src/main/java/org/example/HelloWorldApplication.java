package org.example;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;
import org.example.config.HelloWorldConfiguration;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }
    @Override
    public void run(HelloWorldConfiguration configuration, Environment environment) throws Exception {
        System.out.println("Hello World:-->" +configuration.getGreeting());
    }
}
