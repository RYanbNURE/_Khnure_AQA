package com.example.webpagetest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class WebPageTestClient {
    private final String apiKey;
    private final OkHttpClient client;
    private final ObjectMapper objectMapper;

    public WebPageTestClient(String apiKey) {
        this.apiKey = apiKey;
        this.client = new OkHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public void runTest(String url) throws IOException {
        String apiUrl = String.format("https://www.webpagetest.org/runtest.php?url=%s&k=%s&f=json", url, apiKey);

        Request request = new Request.Builder()
                .url(apiUrl)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            String responseBody = response.body().string();
            JsonNode jsonNode = objectMapper.readTree(responseBody);

            String testId = jsonNode.path("data").path("testId").asText();
            System.out.println("Test started. Test ID: " + testId);

            // Wait for the test to complete
            waitForTestCompletion(testId);

            // Get and print the results
            printTestResults(testId);
        }
    }

    private void waitForTestCompletion(String testId) throws IOException {
        String statusUrl = String.format("https://www.webpagetest.org/testStatus.php?f=json&test=%s", testId);

        while (true) {
            Request request = new Request.Builder().url(statusUrl).build();

            try (Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                String responseBody = response.body().string();
                JsonNode jsonNode = objectMapper.readTree(responseBody);

                String statusText = jsonNode.path("statusText").asText();
                System.out.println("Test status: " + statusText);

                if ("Test Complete".equals(statusText)) {
                    break;
                }

                // Wait for 10 seconds before checking again
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IOException("Interrupted while waiting for test completion", e);
            }
        }
    }

    private void printTestResults(String testId) throws IOException {
        String resultsUrl = String.format("https://www.webpagetest.org/jsonResult.php?test=%s", testId);

        Request request = new Request.Builder().url(resultsUrl).build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            String responseBody = response.body().string();
            JsonNode jsonNode = objectMapper.readTree(responseBody);

            JsonNode firstView = jsonNode.path("data").path("runs").path("1").path("firstView");

            System.out.println("\nTest Results:");
            System.out.println("Load Time: " + firstView.path("loadTime").asText() + " ms");
            System.out.println("First Contentful Paint: " + firstView.path("firstContentfulPaint").asText() + " ms");
            System.out.println("Speed Index: " + firstView.path("SpeedIndex").asText());
            System.out.println("TTFB: " + firstView.path("TTFB").asText() + " ms");
        }
    }
}