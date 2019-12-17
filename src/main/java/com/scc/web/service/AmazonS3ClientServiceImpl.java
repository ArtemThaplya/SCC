package com.scc.web.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.scc.web.config.S3Config;
import com.scc.web.service.Interfaces.AmazonS3ClientService;
import com.scc.web.service.Interfaces.CreateFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Component
public class AmazonS3ClientServiceImpl implements AmazonS3ClientService {
    private static final Logger logger = LoggerFactory.getLogger(AmazonS3ClientServiceImpl.class);
    private final S3Config s3Config;
    private final CreateFile createFile;

    @Autowired
    public AmazonS3ClientServiceImpl(S3Config s3Config, CreateFile createFile) {
        this.s3Config = s3Config;
        this.createFile = createFile;
    }

    @Override
    public void uploadFileToS3Bucket(MultipartFile multipartFile, boolean enablePublicReadAccess, AmazonS3 amazonS3) {
        String fileName = multipartFile.getOriginalFilename();
        try {
            File file = createFile.createFileToS3(fileName, multipartFile);
            PutObjectRequest putObjectRequest = new PutObjectRequest(s3Config.getBucketName(), fileName, file);
            if (enablePublicReadAccess) {
                putObjectRequest.withCannedAcl(CannedAccessControlList.PublicRead);
            }
            amazonS3.putObject(putObjectRequest);
            file.delete();
        } catch (IOException | AmazonServiceException ex) {
            logger.error("error [" + ex.getMessage() + "] occurred while uploading [" + fileName + "] ");
        }
    }
}
