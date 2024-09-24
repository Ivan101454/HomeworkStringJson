package ru.clevertec.stringJson;

import org.junit.jupiter.api.Test;
import ru.clevertec.entity.Person;
import ru.clevertec.util.DataForTests;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class ConvertClassToJsonTest {

    @Test
    void schouldConvertClassToString() throws IllegalAccessException {
        Person person = DataForTests.getJavaObjectWithoutCollection();
        String result =  ConverterClassToJson.coverter(person);
        String expect = DataForTests.getJsonAsStringWithoutCollect();
        System.out.println(result);
        assertEquals(expect, result);
    }
}