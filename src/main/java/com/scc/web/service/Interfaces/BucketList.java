package com.scc.web.service.Interfaces;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;

import java.util.List;

public interface BucketList {
    List<Bucket> createBucketList(AmazonS3 amazonS3);
}
