package ru.clevertec;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.clevertec.resolver.ResolverJson;
import ru.clevertec.testclass.Car;
import ru.clevertec.testclass.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Path input = Paths.get("input.txt");
        String strings = String.valueOf(Files.readAllLines(input));

        ResolverJson.resolve(strings);

    }
}
