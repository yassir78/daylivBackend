package com.dayliv.dayliv.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dayliv.dayliv.dto.DeleteImageRequest;
import com.dayliv.dayliv.serviceImpl.AmazonS3BucketService;

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
    public ResponseEntity<?> deleteFile(@RequestBody DeleteImageRequest deleteImageRequest) {
        return this.amazonS3BucketService.deleteFileFromBucket(deleteImageRequest.getFileName(), deleteImageRequest.getProductImageId() );
    }
}