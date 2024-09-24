package ru.clevertec.util;

import ru.clevertec.entity.Car;
import ru.clevertec.entity.Person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataForTests {
    public static String getJsonAsStringForOneObject() {
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
        return jsonString;
    }

    public static Person getJavaObject() {
        Person person = Person.builder()
                .name("John").city("Berlin").cars(List.of(
                        Car.builder().name("audi").build(),
                        Car.builder().name("bmw").build())).job("Teacher")
                .build();
        return person;
    }

    public static Map<String, Map> getMapOfJson = new HashMap<>(Map.of(
            "Map0",  Map.of("0", "audi", "1", "bmw"), "Map1", Map.of("name", "John",
                    "city", "Berlin", "cars", "Map0",   "job", "Teacher"))
    );

}
