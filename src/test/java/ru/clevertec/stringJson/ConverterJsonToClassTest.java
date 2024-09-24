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
    void shouldReturnObjectOfClassWithoutCollection() throws NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Map<String, Map> mapOfJson = DataForTests.getMapOfJsonWithoutList;
        Person expectPerson = DataForTests.getJavaObjectWithoutCollection();
        Map objectMap = mapOfJson.get("Map%d".formatted(mapOfJson.size() - 1));

        mapOfJson.entrySet().forEach(System.out::println);
        Person resultPerson = ConverterJsonToClass.converter(Person.class, mapOfJson);
        System.out.println(resultPerson.toString());
        assertEquals(expectPerson, resultPerson);
    }
}