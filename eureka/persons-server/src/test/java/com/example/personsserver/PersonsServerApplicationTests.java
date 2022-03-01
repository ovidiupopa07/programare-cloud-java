package com.example.personsserver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonsServerApplicationTests {

    //TODO configure discovery-server to be the Eureka's server and persons-server to be the client server
    // hint1: If discovery-server was configured correctly it can be accessed on localhost:3000
    // hint2: If persons-server was configured correctly it should appear on localhost:3000 under DS Replicas section
    @Test
    void contextLoads() {
    }

}
