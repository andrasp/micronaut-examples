package example;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Greeting {
    String greetingWord;
    String name;
}
