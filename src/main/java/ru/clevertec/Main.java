package ru.clevertec;


import ru.clevertec.reader.ReaderOfFileWithJson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        // Указать путь к файлу с json
        ReaderOfFileWithJson.getJsonFromTxtFile("input.txt");

    }
}
