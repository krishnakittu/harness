package org.example;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;
import org.example.config.HelloWorldConfiguration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);

    }
    @Override
    public void run(HelloWorldConfiguration configuration, Environment environment) throws Exception {
        File directory = new File("/app/files");
        File directory1 =  new File(directory.getPath()+File.separator+"files");
        System.out.println("Hello World:-->" +directory.exists());
        System.out.println("Hello World:-->" +directory1.exists());
        System.out.println("Hello World:-->" +directory1.mkdirs());
        System.out.println("Hello World:-->" +directory1.getPath());

            FileOutputStream fileOut = new FileOutputStream(directory1+"/hello.ser", true);
            OutputStreamWriter out = new OutputStreamWriter(fileOut, StandardCharsets.UTF_8);
            StringBuilder builder = new StringBuilder();
            String sequenceNo = "hello";

            out.write(builder.toString());
            out.close();
        System.out.println("Hello World:-->" +configuration.getGreeting());
    }
}
