package com.virginiatech.ece;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;

@Component
public class AzureBlobInitializer {

	@Value("${azure.blob.storageConnectionString}")
	private String storageConnectionString;

	public CloudBlobContainer getcontainer(String containerName)
			throws InvalidKeyException, URISyntaxException, StorageException {
		CloudStorageAccount account = CloudStorageAccount.parse(storageConnectionString);
		CloudBlobClient serviceClient = account.createCloudBlobClient();
		CloudBlobContainer container = serviceClient.getContainerReference(containerName);
		container.createIfNotExists();

		return container;

	}

}
