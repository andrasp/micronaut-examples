/*
 * Copyright 2017 original authors
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.validation.Validated;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author Graeme Rocher
 * @since 1.0
 */
@Controller("/")
@Validated
@RequiredArgsConstructor
public class HelloController {

    private final ObjectMapper jsonMapper;

    @Get(uri = "/hello/{greetingWord}/{name}", produces = MediaType.TEXT_PLAIN)
    public Single<String> hello(@NotBlank final String greetingWord, @NotBlank final String name) throws JsonProcessingException {
        final Greeting greeting = Greeting.builder()
                                          .greetingWord(greetingWord)
                                          .name(name)
                                          .build();
        return Single.just(jsonMapper.writeValueAsString(greeting));
    }
}
