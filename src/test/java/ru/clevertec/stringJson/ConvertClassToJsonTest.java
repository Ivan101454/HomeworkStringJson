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
        Class<?> classOfObject = person.getClass();
        Field[] declaredFields = classOfObject.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        sb.append("{\n\r");
        for (int i = 0; i < declaredFields.length; i++) {
            String name = declaredFields[i].getName();
            declaredFields[i].setAccessible(true);
            Object o1 = declaredFields[i].get(person);
            sb.append("\""+name+"\""+"="+"\""+o1.toString()+"\"\n\r");
        }
        sb.append("}");

//        String coverterString = ConvertClassToJson.coverter(person);
    }
}