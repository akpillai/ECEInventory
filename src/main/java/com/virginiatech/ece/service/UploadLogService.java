package com.virginiatech.ece.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.microsoft.azure.storage.StorageException;
import com.virginiatech.ece.model.Temp;
import com.virginiatech.ece.model.UploadLog;

public interface UploadLogService {
	 List<UploadLog> findUploads();
	 List<Temp> findTestData();	 
	 void uploadData(MultipartFile inventoryFile) throws IOException, InvalidKeyException, URISyntaxException, StorageException;

}
