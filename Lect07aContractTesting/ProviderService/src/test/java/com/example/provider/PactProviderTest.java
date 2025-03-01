package com.example.provider;

import au.com.dius.pact.core.model.annotations.PactFolder;
import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.spring.junit5.PactVerificationSpringProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@Provider("UserProvider")
//@PactFolder("pacts")
public class PactProviderTest {

//    @LocalServerPort
//    private int port;
//
//    @BeforeEach
//    void setUp(PactVerificationContext context) {
//        context.setTarget(new HttpTestTarget("localhost", port));
//    }
//
//    @TestTemplate
//    @ExtendWith(PactVerificationSpringProvider.class)
//    void pactVerificationTestTemplate(PactVerificationContext context) {
//        context.verifyInteraction();
//    }
}