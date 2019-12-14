package com.scc.web.service;

import com.amazonaws.services.s3.model.Bucket;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeleteEntryFromBucketImp implements DeleteEntryFromBucket {

    @Override
    public void deleteEntry(String entry, List<Bucket> bucketList) {
        for (Bucket bucket : bucketList) {
            if (bucket.getName().equals(entry)) {
                bucketList.remove(bucket);
            }
        }
    }
}
