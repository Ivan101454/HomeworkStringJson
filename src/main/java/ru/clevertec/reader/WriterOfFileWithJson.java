package ru.clevertec.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriterOfFileWithJson {
    public static void write(String output, String pathOutput) throws IOException {
        Path path = Paths.get(pathOutput);
        Files.writeString(path, output);
    }

}
