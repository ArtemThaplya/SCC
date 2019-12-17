package com.scc.web.service;

import com.amazonaws.services.s3.model.Bucket;
import com.opencsv.CSVReader;
import com.scc.web.config.S3Config;
import com.scc.web.service.Interfaces.CheckBucketNameReadCsvToList;
import com.scc.web.service.Interfaces.CreateFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Component
public class CheckBucketNameCheckBucketNameReadCsvToListImp implements CheckBucketNameReadCsvToList {
    private final OperationService operationService;
    private final S3Config s3Config;
    private final CreateFile createFile;

    @Autowired
    public CheckBucketNameCheckBucketNameReadCsvToListImp(OperationService operationService, S3Config s3Config, CreateFile createFile) {
        this.operationService = operationService;
        this.s3Config = s3Config;
        this.createFile = createFile;
    }

    public List<String[]> readAll(Reader reader) throws Exception {
        CSVReader csvReader = new CSVReader(reader);
        List<String[]> list = csvReader.readAll();
        reader.close();
        csvReader.close();
        return list;
    }

    public File checkBucketNameAndCreateFile() throws IOException {
        File file = null;
        for (Bucket bucket : operationService.getBucketList()) {
            if (bucket.getName().equals(s3Config.getBucketName())) {
                file = createFile.createFileToS3(bucket.getName(), (MultipartFile) bucket);
            }
        }
        return file;
    }
}
