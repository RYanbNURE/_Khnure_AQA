package com.company.modulejava.lecture13.ex0;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TestAutomation seleniumTestAutomationForEPAM = new SeleniumTestAutomation();
        TestAutomation seleniumTestAutomationForGoogle = new SeleniumTestAutomation();
        TestAutomation seleniumTestAutomationForOracle = new SeleniumTestAutomation();

        TestAutomation backendAPITestAutomation = new BackendAPITestAutomation();

        List<TestAutomation> testAutomations = new ArrayList<>();
        testAutomations.add(seleniumTestAutomationForEPAM);
        testAutomations.add(seleniumTestAutomationForGoogle);
        testAutomations.add(seleniumTestAutomationForOracle);
        testAutomations.add(backendAPITestAutomation);

        for (TestAutomation test:
             testAutomations) {
            test.test();
        }

//        TestAutomation performanceTestAutomation = new TestAutomation() {
//            @Override
//            public void test() {
//                System.out.println("Performance testing via Gatling");
//            }
//        };

        TestAutomation performanceTestAutomation = () -> System.out.println("Performance testing via Gatling");

        ManualTester manualTester = new ManualTester() {
            @Override
            public void test() {

            }
        };
        performanceTestAutomation.test();
        System.out.println(1111);
        performanceTestAutomation.test();
        performanceTestAutomation.test();
        performanceTestAutomation.test();
        performanceTestAutomation.test();
        performanceTestAutomation.test();
        performanceTestAutomation.test();

        Developer javaDeveloper = new JavaDeveloper();

        Developer pythonDeveloper = new Developer() {
            @Override
            public void writeCode() {
                System.out.println("Write Python code");
            }

            @Override
            public void makeCodeReview() {
                System.out.println("Making Python code review");
            }
        };
    }
}
