package ru.clevertec.stringJson;

import org.junit.jupiter.api.Test;
import ru.clevertec.entity.Person;
import ru.clevertec.util.DataForTests;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConverterJsonToClassTest {

    @Test
    void shouldReturnObjectOfClass() throws NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Map<String, Map> mapOfJson = DataForTests.getMapOfJson;
        Person expectPerson = DataForTests.getJavaObject();
        Map objectMap = mapOfJson.get("Map%d".formatted(mapOfJson.size() - 1));

        mapOfJson.entrySet().forEach(System.out::println);
        Person resultPerson = ConverterJsonToClass.converter(Person.class, mapOfJson);
//        assertEquals(expectPerson, resultPerson);
    }
}