package com.scc.web.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3Config {

    @Value("${cloud.aws.credentials.access-key}")
    private String awsId;

    @Value("${cloud.aws.credentials.secret-key}")
    private String awsKey;

    @Value("${cloud.aws.region.static}")
    private String region;

    @Value("${spring.couchbase.bucket.name}")
    private String bucketName;

    public String getAwsId() {
        return awsId;
    }

    public String getAwsKey() {
        return awsKey;
    }

    public String getRegion() {
        return region;
    }

    public String getBucketName() {
        return bucketName;
    }

    @Bean(name = "amazonS3")
    public AmazonS3 s3client() {

        BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsId, awsKey);

        return AmazonS3ClientBuilder.standard()
                .withRegion(Regions.fromName(region))
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .build();
    }
}
