package com.scc.web.service;

import com.amazonaws.services.s3.model.Bucket;

import java.util.List;

public interface DeleteEntryFromBucket {
    public void deleteEntry(String entry, List<Bucket> bucketsList);
}
