package org.khnure.ex4assertj;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ExampleTest {

    @Test
    public void testString() {
        String str = "Hello, world!";
        assertThat(str).startsWith("Hello")
                .contains("world")
                .endsWith("!");
    }
}
