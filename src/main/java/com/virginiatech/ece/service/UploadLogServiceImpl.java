package com.virginiatech.ece.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virginiatech.ece.model.UploadLog;
import com.virginiatech.ece.repository.UploadLogRepository;

@Service
public class UploadLogServiceImpl implements UploadLogService {
	private UploadLogRepository uploadRepository;

	@Autowired
	public void setUploadRepository(UploadLogRepository uploadRepository) {
		this.uploadRepository = uploadRepository;
	}

	public List<UploadLog> findUploads() {

		return this.uploadRepository.findAll();
	}

}
