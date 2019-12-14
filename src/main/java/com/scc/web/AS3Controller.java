package com.scc.web;

import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.scc.web.config.S3Config;
import com.scc.web.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class AS3Controller {
    private final OperationService operationService;
    private final S3Config s3Config;

    @Autowired
    public AS3Controller(OperationService operationService, S3Config s3Config) {
        this.operationService = operationService;
        this.s3Config = s3Config;
    }

    @RequestMapping(value = "/addEntryToCSV")
    public boolean addEntry(@RequestParam(value = "entry") String entry) {
        for (Bucket bucket : operationService.getBucketList()) {
            if (bucket.getName().equals(entry)) {

                return false;
            }
        }
        PutObjectRequest putObjectRequest = new PutObjectRequest(s3Config.getBucketName(), s3Config.getAwsId(), entry);
        s3Config.s3client().putObject(putObjectRequest);
        return true;
    }

    @RequestMapping(value = "/viewEntryToCSV", method = RequestMethod.GET)
    public ModelAndView viewEntry() {
        ModelAndView model = new ModelAndView("viewEntry.jsp");
        model.addObject("list", operationService.getBucketList());
        return model;
    }

    @RequestMapping(value = "/deleteEntryFromBucket", method = RequestMethod.GET)
    public boolean deleteEntryFromBucket(@RequestParam(value = "entryDelete") String entryDelete) {
        List<Bucket> bucketListLoc = operationService.getBucketList();
        operationService.getDeleteEntryFromBucket(entryDelete, bucketListLoc);

        PutObjectRequest putObjectRequest = new PutObjectRequest(s3Config.getBucketName(), s3Config.getAwsId(), String.valueOf(bucketListLoc));
        s3Config.s3client().putObject(putObjectRequest);
        return true;
    }
}
