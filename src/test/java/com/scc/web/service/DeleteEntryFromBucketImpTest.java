package com.scc.web.service;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class DeleteEntryFromBucketImpTest {
    private final static String ENTRY = "a";
    private final List<String[]> list = new ArrayList<>();
    private final List<String[]> expected = new ArrayList<>();
    private final OperationService operationService = mock(OperationService.class);

    @Test
    public void deleteEntry() {
        list.add(new String[]{"a"});
        list.add(new String[]{"b"});
        list.add(new String[]{"c"});

        expected.add(new String[]{"b"});
        expected.add(new String[]{"c"});
        List<String[]> actual = operationService.getDeleteEntryFromBucket(ENTRY, list);
        assertEquals(expected, actual);
    }
}