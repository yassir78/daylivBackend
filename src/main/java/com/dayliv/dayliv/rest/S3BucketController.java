package com.dayliv.dayliv.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dayliv.dayliv.serviceImpl.AmazonS3BucketService;

@CrossOrigin(origins = "http://localhost:4800")
@RestController
public class S3BucketController {

    private AmazonS3BucketService amazonS3BucketService;

    S3BucketController(AmazonS3BucketService amazonS3BucketService) {
        this.amazonS3BucketService = amazonS3BucketService;
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
    	
        return  this.amazonS3BucketService.uploadFile(file);
    }

    @PostMapping("/deleteFile")
    public String deleteFile(@RequestBody String fileURL) {
        return this.amazonS3BucketService.deleteFileFromBucket(fileURL);
    }
}