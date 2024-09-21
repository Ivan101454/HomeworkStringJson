package ru.clevertec.resolver;

import ru.clevertec.testclass.Person;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResolverJson {
    public static <T extends Person> T resolve(String input) {

        String flat = convertToFlatString(input);
        Deque<String> stackOfLiteral = completeStackByLiteral(flat);
        Deque<String> stackOfPunct = completeStackByPunctuation(flat);

        List<Integer> counter = new ArrayList<>();
        counter.add(0);
        Deque<String> stackTemp = new LinkedList<>();

        Person person = Person.builder().build();

        Class<Person> personClass = Person.class;
        Field[] fields = personClass.getFields();
        for (int i = 0; i < fields.length; i++) {

        }

        Consumer<String> consumer = e -> {
            switch (e) {
                case "{":
                    counter.add(counter.getFirst() +1);
                    stackTemp.push(stackOfLiteral.removeFirst());
                    break;

                case "}":

                    break;

                case ":":

                    break;

                case "[":

                    break;

                case "]":

                    break;

                case ",":

                    break;
            }

        };

        stackOfPunct.stream().forEach(e -> {
            if(e.equals("{")) {

            } else
            if (e.equals("}")) {

            }
        });



        return null;
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
