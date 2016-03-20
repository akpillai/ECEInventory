package com.virginiatech.ece.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.virginiatech.ece.model.UploadLog;

public interface UploadLogRepository extends CrudRepository<UploadLog, Long> {
	 List<UploadLog> findAll();

}