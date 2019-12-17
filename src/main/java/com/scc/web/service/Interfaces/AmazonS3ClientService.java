package com.scc.web.service.Interfaces;

import com.amazonaws.services.s3.AmazonS3;
import org.springframework.web.multipart.MultipartFile;

public interface AmazonS3ClientService {
    void uploadFileToS3Bucket(MultipartFile multipartFile, boolean enablePublicReadAccess, AmazonS3 amazonS3);
}
