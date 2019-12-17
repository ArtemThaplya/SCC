package com.scc.web.service.Interfaces;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public interface CreateFile {
    File createFileToS3(String fileName, MultipartFile multipartFile) throws IOException;
}
