package ru.clevertec.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReaderOfFileWithJson {
    public static String getJsonFromTxtFile(String path) throws IOException {
        Path input = Paths.get("input.txt");
        return String.valueOf(Files.readString(input));
    }
}
