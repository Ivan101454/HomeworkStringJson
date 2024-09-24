package ru.clevertec;


import ru.clevertec.entity.Person;
import ru.clevertec.reader.ReaderOfFileWithJson;
import ru.clevertec.resolver.ResolverJson;
import ru.clevertec.stringJson.ConverterJsonToClass;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchFieldException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // Указать путь к файлу с json
        String jsonFromTxtFile = ReaderOfFileWithJson.getJsonFromTxtFile("input.txt");
        Map<String, Map> jsonInMap = ResolverJson.convertToMapCollection(jsonFromTxtFile);
        Person personFromJson = ConverterJsonToClass.converter(Person.class, jsonInMap);
        System.out.println(personFromJson.toString());
    }
}
