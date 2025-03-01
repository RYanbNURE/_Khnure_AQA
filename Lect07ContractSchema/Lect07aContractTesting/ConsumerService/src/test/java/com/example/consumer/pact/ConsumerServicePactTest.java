package com.example.consumer.pact;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.PactSpecVersion;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(PactConsumerTestExt.class)
@PactTestFor(providerName = "HelloWorldProvider", pactVersion = PactSpecVersion.V3)
public class ConsumerServicePactTest {

    @Pact(consumer = "ConsumerService")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        return builder
                .given("Provider has data")
                .uponReceiving("A request for data")
                .path("/provider/data")
                .method("GET")
                .willRespondWith()
                .status(200)
                .body("Hello from Provider!")
                .toPact();
    }

    @Test
    void testFetchData(MockServer mockServer) {
        RestTemplate restTemplate = new RestTemplate();
        String url = mockServer.getUrl() + "/provider/data";

        String response = restTemplate.getForObject(url, String.class);

        assertThat(response).isEqualTo("Hello from Provider!");
    }

}
