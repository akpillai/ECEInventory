package com.virginiatech.ece.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.virginiatech.ece.service.UploadLogServiceImpl;

@Controller
@Component
public class DashboardController {

	@Value("${page.home}")
	private String home;
	@Autowired
	private UploadLogServiceImpl uploadService;

	@RequestMapping("/home")
	String dashboard(Model model) {		
		model.addAttribute("logs", uploadService.findUploads());
		return home;

	}

}
