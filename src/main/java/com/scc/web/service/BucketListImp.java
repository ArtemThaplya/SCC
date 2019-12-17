package com.scc.web.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.scc.web.service.Interfaces.BucketList;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BucketListImp implements BucketList {

    @Override
    public List<Bucket> createBucketList(AmazonS3 amazonS3) {
        return amazonS3.listBuckets();
    }
}
