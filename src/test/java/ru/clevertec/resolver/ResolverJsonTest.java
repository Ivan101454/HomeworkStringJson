package ru.clevertec.resolver;

import org.junit.jupiter.api.Test;
import ru.clevertec.testclass.Car;
import ru.clevertec.testclass.Person;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.clevertec.resolver.ResolverJson.completeStackByLiteral;
import static ru.clevertec.resolver.ResolverJson.completeStackByPunctuation;
import static ru.clevertec.resolver.ResolverJson.convertToFlatString;

class ResolverJsonTest {
    final String jsonString = """
                {
                    "name":"John",
                    "city":"Berlin",
                    "cars":[
                        "audi",
                        "bmw"
                    ],
                    "job":"Teacher"
                }
                """;
    @Test
    void shouldMapJsonToCollection() {
        Person.PersonBuilder expectPerson = Person.builder()
                .name("John").city("Berlin").cars(List.of(
                        Car.builder().name("audi").build(),
                        Car.builder().name("bmw").build())).job("Teacher");

        Person resultPerson = ResolverJson.resolve(jsonString);
//        assertEquals(expectPerson, resultPerson);

    }
    @Test
    void shouldConvertJsonToChars() {

        String expect = """
                {"name":"John","city":"Berlin","cars":["audi","bmw"],"job":"Teacher"}""";

        String result = convertToFlatString(jsonString);
        assertEquals(result, expect);
    }
    @Test
    void shouldCompleteStackSymbols() {
        Deque<String> expectLiteral = new LinkedList<>(
                Arrays.asList("name", "John", "city", "Berlin", "cars", "audi", "bmw", "job", "Teacher").reversed()
        );
        String flatString = convertToFlatString(jsonString);
        Deque<String> resultLiteral = completeStackByLiteral(flatString);
        while (expectLiteral.iterator().hasNext()) {
            assertEquals(expectLiteral.pop(), resultLiteral.pop());
        }
    }
    @Test
    void shouldCompleteStackPunct () {
        Deque<String> expectPunctuation = new LinkedList<>(
                Arrays.asList("{", ":", ",", ":", ",", ":", "[", ",", "]", ",", ":", "}").reversed()
        );
        String flatString = convertToFlatString(jsonString);
        Deque<String> resultPunctuation = completeStackByPunctuation(flatString);
        while (expectPunctuation.iterator().hasNext()) {
            assertEquals(expectPunctuation.pop(), resultPunctuation.pop());
        }
    }

    
}