package com.scc.web.service.Interfaces;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public interface CheckBucketNameReadCsvToList {
    List<String[]> readAll(Reader reader) throws Exception;

    File checkBucketNameAndCreateFile() throws IOException;
}
