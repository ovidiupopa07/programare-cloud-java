package com.eureka.persons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.IOException;

@EntityScan(basePackages = "com.eureka.persons")
@SpringBootApplication
public class PersonsServer {

    private static Logger logger = LoggerFactory.getLogger(PersonsServer.class);

    public static void main(String... args) throws IOException {
        // Look for configuration in persons-server.properties or persons-server.yml
        System.setProperty("spring.config.name", "persons-server");

        var ctx = SpringApplication.run(PersonsServer.class, args);
        assert (ctx != null);
        logger.info("Started ...");
        System.in.read();
        ctx.close();
    }
}
