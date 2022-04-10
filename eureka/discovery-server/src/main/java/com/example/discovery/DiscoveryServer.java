package com.example.discovery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServer {

    private static Logger logger = LoggerFactory.getLogger(DiscoveryServer.class);

    public static void main(String... args) throws IOException {
        // Look for configuration in discovery-server.properties or discovery-server.yml
        System.setProperty("spring.config.name", "discovery-server");

        var ctx = SpringApplication.run(DiscoveryServer.class, args);
        assert (ctx != null);
        logger.info("Started ...");
        System.in.read();
        ctx.close();
    }
}
