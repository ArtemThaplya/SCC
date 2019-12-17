package com.scc.web.service;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveListToCsv {
    private static File file = new File("someFile.csv");

    public static File addDataToCSV(List<String[]> data) {
        try {
            FileWriter outputFile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputFile, ';',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            writer.writeAll(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
