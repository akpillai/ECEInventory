package com.virginiatech.ece.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.microsoft.azure.storage.StorageException;
import com.virginiatech.ece.service.UploadLogService;

@Controller
@Component
public class UploadController {

	private UploadLogService uploadService;

	@Autowired
	public void setUploadService(UploadLogService uploadService) {
		this.uploadService = uploadService;
	}

	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	public String importParse(@RequestParam("inventory") MultipartFile inventoryFile)
			throws IOException, InvalidKeyException, URISyntaxException, StorageException {
		uploadService.uploadData(inventoryFile);
		return "redirect:home";

	}

	@RequestMapping("/upload")
	public String defaultPage() {
		return "uploadFiles";

	}

	@RequestMapping("/uploadSuccess")
	public String uploadSuccess(Model model) {
		model.addAttribute("uploadedData", uploadService.findTestData());
		return "testDataSuccess";

	}

}
