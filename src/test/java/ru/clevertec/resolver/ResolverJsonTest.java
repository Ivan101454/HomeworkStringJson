package ru.clevertec.resolver;

import org.junit.jupiter.api.Test;
import ru.clevertec.entity.Car;
import ru.clevertec.entity.Person;
import ru.clevertec.util.DataForTests;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.clevertec.resolver.ResolverJson.convertToFlatString;
import static ru.clevertec.resolver.ResolverJson.convertToMapCollection;

class ResolverJsonTest {



    @Test
    void shouldMapJsonToCollection() {
        String jsonString = DataForTests.getJsonAsStringForOneObject();

        Map<String, Map> expectMap = DataForTests.getMapOfJsonWithList;

        Map<String, Map> resultMap = convertToMapCollection(jsonString);
        Stream.of(resultMap).forEach(System.out::println);
        assertEquals(expectMap, resultMap);

    }

    @Test
    void shouldConvertJsonToString() {
        String jsonString = DataForTests.getJsonAsStringForOneObject();
        String expect = """
                {"name":"John","city":"Berlin","cars":["audi","bmw"],"job":"Teacher"}""";

        String result = convertToFlatString(jsonString);
        assertEquals(result, expect);
    }

//    @Test
//    void shouldTestRefactorClass() throws NoSuchFieldException {
//        Person expectPerson = Person.builder()
//                .name("John").city("Berlin").cars(List.of(
//                        Car.builder().name("audi").build(),
//                        Car.builder().name("bmw").build())).job("Teacher")
//                .build();
//        Class<? extends Person> aClass = expectPerson.getClass();
//        Field name = aClass.getField("name");
//        Field[] declaredFields = aClass.getDeclaredFields();
//
//        for (int i = 0; i < declaredFields.length; i++) {
//            System.out.println(declaredFields);
//        }
//    }
}