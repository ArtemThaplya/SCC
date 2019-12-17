package com.scc.web.service;

import java.util.List;

public class AddEntryCheckDuplicate {
    public static List<String[]> checkDuplicateAndAddEntry(List<String[]> list, String entry) {
        for (String[] arr : list) {
            if (!arr[0].equals(entry)) {
                list.add(new String[]{entry});
            }
        }
        return list;
    }
}
