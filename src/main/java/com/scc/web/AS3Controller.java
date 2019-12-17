package com.scc.web;

import com.amazonaws.services.s3.AmazonS3;
import com.scc.web.service.AddEntryCheckDuplicate;
import com.scc.web.service.Interfaces.AmazonS3ClientService;
import com.scc.web.service.OperationService;
import com.scc.web.service.OperationWithFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.scc.web.service.SaveListToCsv.addDataToCSV;

@RestController
public class AS3Controller {
    private final OperationWithFile operationWithFile;
    private final OperationService operationService;
    private AmazonS3ClientService amazonS3ClientService;
    private AmazonS3 amazonS3;


    @Autowired
    public AS3Controller(OperationWithFile operationWithFile, OperationService operationService, AmazonS3ClientService amazonS3ClientService, AmazonS3 amazonS3) {
        this.operationWithFile = operationWithFile;
        this.operationService = operationService;
        this.amazonS3ClientService = amazonS3ClientService;
        this.amazonS3 = amazonS3;
    }

    @RequestMapping(value = "/addEntryToCSV")
    public void addEntry(@RequestParam(value = "entry") String entry) throws Exception {
        List<String[]> listChange = AddEntryCheckDuplicate.checkDuplicateAndAddEntry(operationWithFile.checkNameReadCsvToList(), entry);
        amazonS3ClientService.uploadFileToS3Bucket((MultipartFile) addDataToCSV(listChange), true, amazonS3);
    }

    @RequestMapping(value = "/viewEntryToCSV", method = RequestMethod.GET)
    public ModelAndView viewEntry() throws Exception {
        ModelAndView model = new ModelAndView("viewEntry.jsp");
        model.addObject("list", operationWithFile.checkNameReadCsvToList());
        return model;
    }

    @RequestMapping(value = "/deleteEntryFromBucket", method = RequestMethod.GET)
    public boolean deleteEntryFromBucket(@RequestParam(value = "entryDelete") String entryDelete) throws Exception {
        List<String[]> listChange = operationService.getDeleteEntryFromBucket(entryDelete, operationWithFile.checkNameReadCsvToList());
        amazonS3ClientService.uploadFileToS3Bucket((MultipartFile) addDataToCSV(listChange), true, amazonS3);
        return true;
    }
}
