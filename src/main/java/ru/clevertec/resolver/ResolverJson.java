package ru.clevertec.resolver;

import ru.clevertec.enums.Bracket;
import ru.clevertec.testclass.Person;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResolverJson {


    public static Map<String, String> convertToMapCollection(String input) {
        String work = convertToFlatString(convertToFlatString(input));
        String[] split = work.split("");
        LinkedList<String> strings = new LinkedList<>(List.of(split));
        String result = null;

        Map<String, String> stringMap = new HashMap<>();
        int x = 0;
        int y = 0;
        for (int i = 0; i < split.length; i++) {

            if (strings.get(i).equals("}") || strings.get(i).equals("]")) {
                y = i;
                for (int j = i; j <= 0; j--) {
                    if (strings.get(j).equals("{") || strings.get(j).equals("[")) {
                        x = j;
                    }
                }
                StringBuilder sb = new StringBuilder();
                for (int z = x + 1; z < y; z++) {
                    sb.append(strings.get(z));
                }
                result = sb.toString();
            }
        }
        String[] split1 = result.split(",");
        for (int i = 0; i < split1.length; i++) {
            String[] split2 = split1[i].split("=");
            stringMap.put(split2[0], split2[1]);
        }
        return stringMap;
    }

    public static String convertToFlatString(String input) {
        String result = input.replaceAll(" ", "").replaceAll("[\\n\\r]", "");

        return result;
    }

    public static Deque<String> completeStackByLiteral(String flatstring) {
        Deque<String> stackByLiteral = new LinkedList<>();

        Pattern pattern = Pattern.compile("\"\\w+\"");
        Matcher matcher = pattern.matcher(flatstring);
        while (matcher.find()) {
            stackByLiteral.push(matcher.group().replaceAll("\"", ""));
        }
        return stackByLiteral;
    }

    public static Deque<String> completeStackByPunctuation(String flatstring) {
        Deque<String> stackByPunctuation = new LinkedList<>();
        Pattern pattern = Pattern.compile("[{}:\\[\\],]");
        Matcher matcher = pattern.matcher(flatstring);
        while (matcher.find()) {
            stackByPunctuation.push(matcher.group());
        }
        return stackByPunctuation;
    }

}
