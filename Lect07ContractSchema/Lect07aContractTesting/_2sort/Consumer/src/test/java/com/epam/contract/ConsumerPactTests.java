package com.epam.contract;


import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.HttpResponse;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.V4Interaction;
import au.com.dius.pact.core.model.V4Pact;
import au.com.dius.pact.core.model.annotations.Pact;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static io.pact.plugin.Plugin.GenerateContentRequest.ContentFor.Request;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerPactTests {

//    @Autowired
//    private RestTemplate restTemplate;


    @Pact(consumer = "ExampleConsumer")
    public V4Pact createPact(PactDslWithProvider builder) {
        return builder
                .given("User data for user ID 1 exists")
                .uponReceiving("A request for user data for ID 1")
                .path("/user-data/1")
                .method("GET")
                .willRespondWith()
                .status(200)
                .body("{\"userId\":1, \"userName\":\"John Doe\"}")
                .toPact(V4Pact.class);
    }

    @Test
    @PactTestFor(pactMethod = "createPact")
    void testGetUserData(MockServer mockServer) {
        RestTemplate restTemplate = new RestTemplate();
        String url = mockServer.getUrl() + "/user-data/1";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("{\"userId\":1, \"userName\":\"John Doe\"}", response.getBody());
    }
//
//    @Test
//    void test(MockServer mockServer) throws IOException {
//        HttpResponse httpResponse = Request.Get(mockServer.getUrl() + "/articles.json").execute().returnResponse();
//        assertThat(httpResponse.getStatusLine().getStatusCode(), is(equalTo(200)));
//    }
}
