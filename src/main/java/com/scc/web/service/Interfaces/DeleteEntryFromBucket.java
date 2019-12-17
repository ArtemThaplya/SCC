package com.scc.web.service.Interfaces;

import java.util.List;

public interface DeleteEntryFromBucket {
    List<String[]> deleteEntry(String entry, List<String[]> list);
}
