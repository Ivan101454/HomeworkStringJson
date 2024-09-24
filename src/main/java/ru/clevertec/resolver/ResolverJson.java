package ru.clevertec.resolver;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResolverJson {

// Этот метод преобразовывает строковое представление json в коллекцию Map
    public static Map<String, Map> convertToMapCollection(String input) {
        String workstring = convertToFlatString(convertToFlatString(input));
        String workWithoutQuot = workstring.replace("\"", "");

        String[] split = workWithoutQuot.split("");
        LinkedList<String> stringsLinked = new LinkedList<>(List.of(split));
        String result = null;


        Map<String, Map> stringMap = new HashMap<>();
        int x = 0;
        int y = 0;
        int counter = 0;
        for (int i = 0; i < stringsLinked.size(); i++) {

            if (stringsLinked.get(i).equals("}") || stringsLinked.get(i).equals("]")) {
                y = i;
                for (int j = i; j >= 0; j--) {
                    if (stringsLinked.get(j).equals("{") || stringsLinked.get(j).equals("[")) {
                        x = j;
                        break;
                    }
                }
                StringBuilder sb = new StringBuilder();
                for (int z = x + 1; z < y; z++) {
                    sb.append(stringsLinked.get(z));
                }
                result = sb.toString();
                String[] splitByComma = result.split(",");
                HashMap<String, String> mapOfObject = new HashMap<>();
                if (result.contains(":")) {
                    for (int q = 0; q < splitByComma.length; q++) {
                        String[] splitByColon = splitByComma[q].split(":");
                        mapOfObject.put(splitByColon[0], splitByColon[1]);
                    }
                } else {
                    for (int q = 0; q < splitByComma.length; q++) {
                        mapOfObject.put(Integer.toString(q), splitByComma[q]);
                    }
                }
                String nameMapObject = "Map%d".formatted(counter++);
                stringMap.put(nameMapObject, mapOfObject);
                stringsLinked.subList(x, y+1).clear();
                stringsLinked.add(x, nameMapObject);
                i = 0;

            }

        }

        return stringMap;
    }
    // Утилитарный метод преобразования текста json в строку
    public static String convertToFlatString(String input) {
        String result = input.replaceAll(" ", "").replaceAll("[\\n\\r]", "");
        return result;
    }

}
