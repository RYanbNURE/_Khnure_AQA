package org.examples;

import com.intuit.karate.junit5.Karate;

class ExamplesTest {
    @Karate.Test
    Karate testUsers() {
        return Karate.run("users").relativeTo(getClass());
    }
}