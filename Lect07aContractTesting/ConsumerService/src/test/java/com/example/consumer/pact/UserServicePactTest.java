package com.example.consumer.pact;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.PactSpecVersion;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import com.example.consumer.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(PactConsumerTestExt.class)
@PactTestFor(providerName = "UserProvider", pactVersion = PactSpecVersion.V3)
public class UserServicePactTest {

    @Pact(consumer = "ConsumerService")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        return builder
                .given("Provider has data")
                .uponReceiving("A request for User 1")
                .path("/users/1")
                .method("GET")
                .willRespondWith()
                .status(200)
                .body("{\"id\":1,\"name\":\"John Doe\"}")
                .toPact();
    }

    @Test
    void testFetchData(MockServer mockServer) {
        RestTemplate restTemplate = new RestTemplate();
        String url = mockServer.getUrl() + "/users/1";
        String response = restTemplate.getForObject(url, String.class);;
        assertEquals("{\"id\":1,\"name\":\"John Doe\"}", response);    }

}
