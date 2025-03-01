package com.example.soapservice;

import com.example.greeting.GetGreetingRequest;
import com.example.greeting.GetGreetingResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class GreetingEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/greeting";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getGreetingRequest")
    @ResponsePayload
    public GetGreetingResponse getGreeting(@RequestPayload GetGreetingRequest request) {
        GetGreetingResponse response = new GetGreetingResponse();
        response.setGreeting("Hello, " + request.getName() + "!");
        return response;
    }
}