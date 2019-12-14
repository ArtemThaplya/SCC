package com.scc.web.service;

import com.amazonaws.services.s3.model.Bucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OperationService {
    private final DeleteEntryFromBucket deleteEntryFromBucket;
    private final BucketListImp bucketListImp;

    @Autowired
    public OperationService(DeleteEntryFromBucket deleteEntryFromBucket, BucketListImp bucketListImp) {
        this.deleteEntryFromBucket = deleteEntryFromBucket;
        this.bucketListImp = bucketListImp;
    }

    public void getDeleteEntryFromBucket(String entry, List<Bucket> bucketList) {
        deleteEntryFromBucket.deleteEntry(entry, bucketList);
    }

    public List<Bucket> getBucketList() {
        return bucketListImp.createBucketList();
    }
}
