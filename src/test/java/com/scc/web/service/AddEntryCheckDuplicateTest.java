package com.scc.web.service;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AddEntryCheckDuplicateTest {
    @Test
    public void checkDuplicateAndAddEntry() {
        List<String[]> list = new ArrayList<>();
        list.add(new String[]{"a"});
        list.add(new String[]{"b"});
        list.add(new String[]{"c"});
        String entry = "a";
        List<String[]> actual = AddEntryCheckDuplicate.checkDuplicateAndAddEntry(list, entry);
        assertEquals(list, actual);
    }
}