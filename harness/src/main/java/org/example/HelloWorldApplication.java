package org.example;

import com.google.common.io.Resources;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.example.config.HelloWorldConfiguration;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);

    }
    @Override
    public void run(HelloWorldConfiguration configuration, Environment environment) throws Exception {
        JSch jsch = new JSch();
        JSch.setLogger(new com.jcraft.jsch.Logger() {
            @Override
            public boolean isEnabled(int level) {
                return true;
            }

            @Override
            public void log(int level, String message) {
                System.out.println("Debug purpose :"+ message);
            }
        });

        jsch.addIdentity(configuration.getFtpConfiguration().getPrivateKeyPath());
        Session session = jsch.getSession(
                configuration.getFtpConfiguration().getUserName(),
                configuration.getFtpConfiguration().getHostName(),
                configuration.getFtpConfiguration().getPort());
        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");

        session.setConfig(config);
        session.connect();

        ChannelSftp sftp = (ChannelSftp) session.openChannel("sftp");
        System.out.println("Connection Established");

    }
}
