package com.scc.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

@Component
public class OperationWithFile {
    private final OperationService operationService;

    @Autowired
    public OperationWithFile(OperationService operationService) {
        this.operationService = operationService;
    }

    public List<String[]> checkNameReadCsvToList() throws Exception {
        File file = operationService.checkBucketName();
        Reader reader = Files.newBufferedReader(Paths.get(
                ClassLoader.getSystemResource(Objects.requireNonNull(file).getName()).toURI()));
        return operationService.getReadCsvToList(reader);
    }
}
