package example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
public class HelloControllerTest {

    @Inject
    HelloClient helloClient;

    @Test
    void testHello() {
        assertEquals(
                "{\"greetingWord\":\"Szia\",\"name\":\"Karoly\"}",
                helloClient.hello("Szia", "Karoly").blockingGet()
        );
    }
}
