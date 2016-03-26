package com.virginiatech.ece.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.virginiatech.ece.model.Temp;

public interface TestRepository extends CrudRepository<Temp, Long> {
	List<Temp> findAll();

}