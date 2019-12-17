package com.scc.web.service;

import org.junit.Test;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SaveListToCsvTest {
    private final List<String[]> data = new ArrayList<>();

    @Test
    public void addDataToCSV() {
        data.add(new String[]{"a", "a"});
        data.add(new String[]{"b", "b"});
        data.add(new String[]{"c", "c"});
        File expected = new File("file.csv");
        File actual = SaveListToCsv.addDataToCSV(data);
        assertEquals(expected, actual);
    }
}