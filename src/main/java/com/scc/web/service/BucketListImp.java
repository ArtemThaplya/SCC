package com.scc.web.service;

import com.amazonaws.services.s3.model.Bucket;
import com.scc.web.config.S3Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BucketListImp implements BucketList {
    private final S3Config s3Config;

    @Autowired
    public BucketListImp(S3Config s3Config) {
        this.s3Config = s3Config;
    }


    @Override
    public List<Bucket> createBucketList() {
        return s3Config.s3client().listBuckets();
    }
}
