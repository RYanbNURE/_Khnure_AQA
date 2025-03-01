package com.example.webpagetest;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String apiKey = "YOUR_API_KEY"; // Replace with your actual WebPageTest API key
        String url = "https://www.example.com"; // Replace with the URL you want to test

        WebPageTestClient client = new WebPageTestClient(apiKey);

        try {
            client.runTest(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}