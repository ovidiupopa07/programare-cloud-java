package com.example.personsserver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonsServerApplicationTests {

    //TODO configure discovery-server to be the Eureka's server (on port 3000) and persons-server to be the client server (on port 4001)
    // hint1: you need to add some configurations in resources -> .yml files
    // After you start your server and your client you need to create the endpoints from PersonsController, you have more details there
    // Use postman to test the endpoints. Create a new collection and add all 5 endpoints inside of it.
    @Test
    void contextLoads() {
    }

}
