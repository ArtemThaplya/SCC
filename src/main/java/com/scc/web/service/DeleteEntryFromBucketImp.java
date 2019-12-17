package com.scc.web.service;

import com.scc.web.service.Interfaces.DeleteEntryFromBucket;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeleteEntryFromBucketImp implements DeleteEntryFromBucket {

    @Override
    public List<String[]> deleteEntry(String entry, List<String[]> list) {
        for (String[] arr : list) {
            if (arr[0].equals(entry)) {
                list.remove(arr);
            }
        }
        return list;
    }
}
