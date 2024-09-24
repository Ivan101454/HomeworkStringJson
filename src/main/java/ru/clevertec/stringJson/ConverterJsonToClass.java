package ru.clevertec.stringJson;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ConverterJsonToClass {
    public static  <T> T converter(Class<T> clazz, Map<String, Map> mapOfJson) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        Map<String, String> objectMap = mapOfJson.get("Map%d".formatted(mapOfJson.size() - 1));
        Field[] fields = clazz.getDeclaredFields();
        T object = clazz.getDeclaredConstructor().newInstance();
        for (Field field: fields) {
            String nameOfField = field.getName();
            Class<?> type = field.getType();

//            methodParsingCollection(clazz, mapOfJson, type, nameOfField, objectMap, object);
            if (objectMap.containsKey(nameOfField)) {
                Field fieldFromJson = clazz.getDeclaredField(nameOfField);
                fieldFromJson.setAccessible(true);
                fieldFromJson.set(object, objectMap.get(nameOfField));
            }
        }
        return object;
    }

//    private static <T> void methodParsingCollection(Class<T> clazz, Map<String, Map> mapOfJson, Class<?> type, String nameOfField, Map<String, String> objectMap, T object) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException, NoSuchFieldException {
//        if (type.isInstance(Collection.class)) {
//            //создаем полное имя класс из папки entity
//            String genericOfCollection = nameOfField;
//            String stringWithoutStartAndEndSymbol = genericOfCollection.substring(1, nameOfField.length() - 2);
//            String upperCaseFirstSymbol = genericOfCollection.substring(0, 1).toUpperCase();
//            StringBuilder genericTypeOfCollection = new StringBuilder(genericOfCollection);
//            genericTypeOfCollection.append("ru.clevertec.entity");
//            genericTypeOfCollection.append(upperCaseFirstSymbol);
//            genericTypeOfCollection.append(stringWithoutStartAndEndSymbol);
//            String typeDone = genericTypeOfCollection.toString();
//
//
//            //создаем полное имя класс из папки entity
//            Collection<?> collection = Collections.singleton(type.getDeclaredConstructor().newInstance());
//
//            String nameOfMapCollection = objectMap.get(nameOfField);
//            Map<String, String> mapOfCollection = mapOfJson.get(nameOfMapCollection);
//
//
//            Class<?> classGenericOfCollection = Class.forName(typeDone);
//                classGenericOfCollection.getDeclaredFields()
//            mapOfCollection.forEach(collection.add(classGenericOfCollection));
//
//            Field fieldFromJson = clazz.getDeclaredField(nameOfField);
//            fieldFromJson.setAccessible(true);
//            fieldFromJson.set(object, collection);
//        }
//    }
}
