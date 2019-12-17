package com.scc.web.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.scc.web.service.Interfaces.BucketList;
import com.scc.web.service.Interfaces.CheckBucketNameReadCsvToList;
import com.scc.web.service.Interfaces.DeleteEntryFromBucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

@Component
public class OperationService {
    private final DeleteEntryFromBucket deleteEntryFromBucket;
    private final BucketList bucketList;
    private final AmazonS3 amazonS3;
    private final CheckBucketNameReadCsvToList checkBucketNameReadCsvToList;

    @Autowired
    public OperationService(DeleteEntryFromBucket deleteEntryFromBucket, BucketList bucketList, AmazonS3 amazonS3, CheckBucketNameReadCsvToList checkBucketNameReadCsvToList) {
        this.deleteEntryFromBucket = deleteEntryFromBucket;
        this.bucketList = bucketList;
        this.amazonS3 = amazonS3;
        this.checkBucketNameReadCsvToList = checkBucketNameReadCsvToList;
    }

    public List<String[]> getReadCsvToList(Reader reader) throws Exception {
        return checkBucketNameReadCsvToList.readAll(reader);
    }

    public List<String[]> getDeleteEntryFromBucket(String entry, List<String[]> list) {
        return deleteEntryFromBucket.deleteEntry(entry, list);
    }

    List<Bucket> getBucketList() {
        return bucketList.createBucketList(amazonS3);
    }

    public File checkBucketName() throws IOException {
        return checkBucketNameReadCsvToList.checkBucketNameAndCreateFile();
    }
}
