package com.scc.web.service;

import com.scc.web.service.Interfaces.CreateFile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class CreateFileImp implements CreateFile {
    public File createFileToS3(String fileName, MultipartFile multipartFile) throws IOException {
        File file = new File(fileName);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(multipartFile.getBytes());
        fos.close();
        return file;
    }
}
