package com.dayliv.dayliv.serviceImpl;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.dayliv.dayliv.dao.ProductImageDao;
import com.dayliv.dayliv.dto.DeleteImageResponse;
import com.dayliv.dayliv.model.ProductImage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class AmazonS3BucketService {

	private AmazonS3 amazonS3;

	@Value("${endpointUrl}")
	private String endpointUrl;
	@Value("${bucketName}")
	private String bucketName;
	@Value("${accessKey}")
	private String accessKey;
	@Value("${secretKey}")
	private String secretKey;

	@Autowired
	private ProductImageDao productImageDao;

	@PostConstruct
	private void initializeAmazon() {
		AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
		this.amazonS3 = new AmazonS3Client(credentials);

		// BasicAWSCredentials creds = new BasicAWSCredentials(this.accessKey,
		// this.secretKey);
		// this.amazonS3 = AmazonS3ClientBuilder.standard().withCredentials(new
		// AWSStaticCredentialsProvider(creds)).build();
	}

	public String uploadFile(MultipartFile multipartFile) {
		String fileURL = "";
		try {
			File file = convertMultipartFileToFile(multipartFile);
			String fileName = multipartFile.getOriginalFilename();
			fileURL = endpointUrl + "/" + bucketName + "/" + fileName;
			uploadFileToBucket(fileName, file);
			file.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileURL;
	}

	private File convertMultipartFileToFile(MultipartFile file) throws IOException {
		File convertedFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convertedFile);
		fos.write(file.getBytes());
		fos.close();
		return convertedFile;
	}

	private void uploadFileToBucket(String fileName, File file) {
		amazonS3.putObject(
				new PutObjectRequest(bucketName, fileName, file).withCannedAcl(CannedAccessControlList.PublicRead));
	}

	public ResponseEntity<?> deleteFileFromBucket(String fileName, long productImageId) {
		ProductImage productImage = this.productImageDao.findById(productImageId).orElse(null);
		if (productImage != null)
			this.productImageDao.deleteById(productImageId);
		amazonS3.deleteObject(new DeleteObjectRequest(bucketName, fileName));
		return new ResponseEntity<>(new DeleteImageResponse("Deleted successful!"), HttpStatus.OK);
	}

}