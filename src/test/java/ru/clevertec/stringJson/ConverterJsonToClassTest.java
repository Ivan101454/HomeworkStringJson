package ru.clevertec.stringJson;

import org.junit.jupiter.api.Test;
import ru.clevertec.entity.Person;
import ru.clevertec.util.DataForTests;

import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ConverterJsonToClassTest {

    @Test
    void shouldReturnObjectOfClass() {
        Map<String, Map> mapOfJson = DataForTests.getMapOfJson;
        Person expectPerson = DataForTests.getJavaObject();
        Person resultPerson = ConverterJsonToClass.converter(Person.class, mapOfJson);
        assertEquals(expectPerson, resultPerson);
    }
}