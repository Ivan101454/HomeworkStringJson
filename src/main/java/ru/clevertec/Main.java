package ru.clevertec;


import ru.clevertec.reader.ReaderOfFileWithJson;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Указать путь к файлу с json
        ReaderOfFileWithJson.getJsonFromTxtFile("input.txt");

    }
}
