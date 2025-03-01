package org.example.ex3cdp.ex1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v85.performance.Performance;
import org.openqa.selenium.devtools.v85.profiler.Profiler;
import org.openqa.selenium.devtools.v85.tracing.Tracing;
import org.openqa.selenium.devtools.v85.tracing.model.BufferUsage;

import java.util.Optional;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ChromePerformanceTraceExample {

    public static void main(String[] args) {
        // Set ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\Tutorial\\AQA\\Frontend\\WebdriverProtocols\\src\\main\\resources\\drivers\\chrome\\chromedriver.exe");

        // Setup ChromeDriver
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        // Obtain DevTools interface
        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();

        // Enable performance tracing
        enablePerformanceTracing(devTools);

        // Start tracing
        devTools.send(Tracing.start(
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty()
        ));

        // Navigate to a website
        driver.get("https://example.com");

        // Simulate some actions
        driver.navigate().refresh();

        // Stop tracing and save trace data to file
        devTools.send(Tracing.end());

        // Fetch trace data and save to file
        devTools.addListener(Tracing.tracingComplete(), traceFinished -> {
            traceFinished.getStream().ifPresent(stream -> {
                String traceJson = stream.toString();
                try {
                    Files.write(Paths.get("trace.json"), traceJson.getBytes());
                    System.out.println("Performance trace saved to trace.json");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        });

        // Cleanup
        driver.quit();
    }

    private static void enablePerformanceTracing(DevTools devTools) {
        devTools.send(Performance.enable(Optional.empty()));
        devTools.send(Profiler.enable());
        devTools.send(Tracing.start(
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty()
        ));
    }
}