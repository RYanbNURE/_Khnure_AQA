package org.khnure.ex3hamcrest;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ExampleTest {

    @Test
    public void testString() {
        String str = "Hello, world!";
        assertThat(str, startsWith("Hello"));
        assertThat(str, containsString("world"));
        assertThat(str, endsWith("!"));
    }
}
