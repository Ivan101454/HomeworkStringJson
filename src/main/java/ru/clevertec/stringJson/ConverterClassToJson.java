package ru.clevertec.stringJson;

import java.lang.reflect.Field;

public class ConverterClassToJson {
    public static String coverter(Object object) throws IllegalAccessException {
        Class<?> classOfObject = object.getClass();
        Field[] declaredFields = classOfObject.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        sb.append("{\n\r");
        for (int i = 0; i < declaredFields.length; i++) {
            String name = declaredFields[i].getName();
            declaredFields[i].setAccessible(true);
            Object o1 = declaredFields[i].get(object);
            sb.append("\""+name+"\""+"="+"\""+o1.toString()+"\"\n\r");
        }
        sb.append("}");
        return sb.toString();
    }
}
